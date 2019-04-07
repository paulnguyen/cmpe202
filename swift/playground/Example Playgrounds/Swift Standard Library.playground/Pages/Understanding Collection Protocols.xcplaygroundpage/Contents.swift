/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Understanding Collection Protocols
The best way to understand how collection protocols work in the standard library is to implement your own conforming type. Let's build a daily photo app that allows users to capture the most important moment of every day and view these moments in a timeline. To implement the model layer, we'll create a custom collection type that represents a continuous range of dates and associated images. Here's what the finished app looks like:
*/
import UIKit
let app = finishedApp

/*:
## Model Architecture
When you model your app's storage, it's important to consider the required behaviors and expected performance characteristics. This is true whether you implement your own custom storage or use a combination of standard library data types. For the timeline app, there are three areas to consider:
1. Each date can be associated with an image
2. The timeline displays a continuous, ordered series of days
3. Dates can be incremented arbitrarily and compared in constant time

When you look at the sum of these considerations, the built-in collection types can be ruled out. Dictionaries provide adequate representation for pairs of dates and images and support fast retrieval of values using keys, but are not ordered and cannot contain keys that do not have associated values. On the other hand, arrays are ordered but cannot quickly retrieve values using keys. Additionally, there are application-specific constraints and behaviors that could be modeled at a higher level, but would be simpler to maintain in the storage itself. A collection type that is not generic, but instead understands the qualities of the types it contains may provide considerable benefits.

Let's examine the second and third areas more closely. The timeline displays an _ordered_ series of days. With a collection that has knowledge of the type of the elements, this is trivial to implement–dates have a natural, well defined order. The series is _continuous_ as well–even if a day is not associated with an image, it is still present in the collection and displayed in the timeline. Therefore, in addition to order, the indices are trivially knowable and can be generated as needed. This means the collection can represent every date in a large span of time–without using any memory for dates without images. Finally, because dates can be incremented and compared in constant time, indexing by date can be implemented in constant time. Therefore, a collection with a date 100 years in the past and 100 years in the future should be just as performance and memory efficient as a collection containing two consecutive dates.

With this information, the shape of our collection comes into focus: A collection called `ImageTimeline` with the behaviors and performance characteristics of an array, but with an API that–in some important cases–mirrors that of a dictionary.

## Implementing the Index
Before we implement the collection, let's implement the collection's index type–the type you use to iterate over and subscript into the collection. In our `ImageTimeline` type, the indices into the collection are dates.

To be used as a collection index, a type must implement basic behavior to support operations like subscripting and `for`-`in` style iteration. At a minimum, an index type must adopt the `Comparable` protocol, so indices can quickly be put in order. Rather than use Foundation's `Date` type itself as the collection's index type, let's wrap the `Date` type in a new `DateIndex` where we can implement additional behavior, starting with this simple structure:
*/
struct DateIndex {
    let date: Date
}
/*:
The `Date` type doesn't just store the date–it also stores the time down to the millisecond. Recall that the timeline app is designed to capture and display the most important moment in a user's day. The particular time of day isn't important, and every time a user takes a new photo on the same day it should replace the current photo for that day if one exists.

To make it easy to step through and look up images for particular days, the `DateIndex` type needs to normalize the date when one is created. In the extension below, the `DateIndex` structure is extended with a new initializer that uses the `startOfDay(for:)` method on the user's current calendar to shift the provided date to the first moment in that date's day. As long as the rest of the collection implementation traffics in `DateIndex` objects rather than directly in `Date` objects, we can be sure that the time of day of a date will not impact comparison, iteration, or image lookup.
*/
let calendar = Calendar.current
extension DateIndex {
    init(_ date: Date) {
        self.date = calendar.startOfDay(for: date)
    }
}
/*:
After you write the basic implementation of a type, it's useful to adopt the `CustomDebugStringConvertible` protocol. Whenever you use the type in a playground or as an argument to the `debugPrint` function, the `debugDescription` property is used to print a description of the type. You can read more about custom descriptions in [Customizing Textual Representations](Customizing%20Textual%20Representations).

In the code below, the `DateIndex` structure conforms to `CustomDebugStringConvertible` and returns the stored date as a simple string containing the month and the day.
*/
let dateFormatter = DateFormatter()
dateFormatter.dateFormat = DateFormatter.dateFormat(fromTemplate: "MMMM d", options: 0, locale: .current)

extension DateIndex: CustomDebugStringConvertible {
    var debugDescription: String {
        return dateFormatter.string(from: date)
    }
}
/*:
Now that instances of `DateIndex` are normalized and debuggable, the next step is to adopt the `Comparable` protocol, which inherits from the `Equatable` protocol. To adopt the `Comparable` protocol, you must provide the less-than operator (`<`) and the equal-to operator (`==`) as static methods. Using your implementations, the standard library fills in the rest of the relational operators, so you can use `>`, `<=`, `>=`, and `!=` without any additional code on your part.
 
The wrapped `Date` type already conforms to the `Equatable` protocol, so the equal-to operator (`==`) implementation below simply compares the indices' dates, while the less-than operator (`<`) implementation uses the `Date` type's `compare(_:)` method. After implementing these two operators, the `DateIndex` structure completely adopts the `Comparable` protocol.
*/
extension DateIndex: Comparable {
    static func == (lhs: DateIndex, rhs: DateIndex) -> Bool {
        return lhs.date == rhs.date
    }

    static func < (lhs: DateIndex, rhs: DateIndex) -> Bool {
        return lhs.date.compare(rhs.date) == .orderedAscending
    }
}
/*:
## Implementing the Collection
 
To implement a type that conforms to the `Collection` protocol, you implement–at a minimum–four requirements of the protocol:
 
1. A property called `startIndex` that returns the first index in the collection.
2. A property called `endIndex` that returns the index one past the end.
3. A function called `index(after:)` that advances an index by one position.
4. A subscript that accepts an index and returns an element in the collection.

 In addition to these syntactically defined requirements, there are also _semantic_ and _performance_ requirements. These are requirements that cannot be expressed in code, but are still equally important. The `Collection` protocol documentation contains two such requirements:
 
 * Computing each of these requirements—the start and end index, the successor of an index, and the value at a specific index—must be a constant-time (`O(1)`) operation. Otherwise, generic collection algorithms would have inconsistent or unexpected performance characteristics.
 * The successor of an index must be well-defined. In other words, you must consistently return the same successor from the `index(after:)` method for a given index.

From these four requirements, the remaining requirements in the `Collection` protocol—such as `makeIterator()`, `isEmpty`, and `count`—are implemented for you using default implementations in protocol extensions. For example, the `isEmpty` property has a default implementation expressed in terms of the `startIndex` and `endIndex`: If the `startIndex` and `endIndex` are equal, then there are no elements in the collection.

In the code below, we implement the `ImageTimeline` structure and the minimum syntactic, semantic, and performance requirements to act as a collection. The timeline collection implements its underlying storage as a dictionary of `Date`-`UIImage` pairs for performance and efficiency, but provides access to this storage through `DateIndex` APIs to maintain our high level constraints. This achieves performance characteristics and API influenced by both `Array` and `Dictionary`–while maintaining higher level application constraints like order.
 
- Note: Although we're learning about the `Collection` protocol now, we need to declare conformance in this declaration to the `RandomAccessCollection` protocol and declare the `index(before:)` method, which satisfies a `BidirectionalCollection` protocol requirement. You'll read more about `BidirectionalCollection` and `RandomAccessCollection` below.
*/
struct ImageTimeline: RandomAccessCollection {
   
    private var storage: [Date: UIImage] = [:]
    
    var startIndex = DateIndex(Date.distantPast)
    var endIndex = DateIndex(Date.distantPast)
    
    func index(after i: DateIndex) -> DateIndex {
        let nextDay = calendar.date(byAdding: .day, value: 1, to: i.date)!
        return DateIndex(nextDay)
    }
    
    func index(before i: DateIndex) -> DateIndex {
        let previousDay = calendar.date(byAdding: .day, value: -1, to: i.date)!
        return DateIndex(previousDay)
    }

    subscript (i: DateIndex) -> UIImage? {
        get {
            return storage[i.date]
        }
        set {
            // `ImageTimeline` expands dynamically to include the earliest 
            // and latest dates. To implement this functionality, any time 
            // a new date-image pair is stored using this subscript, we check
            // to see if the date is before the `startIndex` or after the 
            // `endIndex`. Additionally, if the `startIndex` is one of the 
            // placeholder dates, we adjust the `startIndex` upwards to the 
            // passed-in date.
            if isEmpty {
                startIndex = i
                endIndex = index(after: i)
            } else if i < startIndex {
                startIndex = i
            } else if i >= endIndex {
                endIndex = index(after: i)
            }
            
            storage[i.date] = newValue
        }
    }
}
/*:
In particular, note that the `index(after:)` method creates a new date by incrementing the given index's date by one day and then returns a new `DateIndex` instance with the new date. Because successive dates are consistently producible and can be computed in constant time, we have satisfied both additional documented requirements.
 
We'll also implement a subscript and range operators that take `Date` objects and wrap them up as `DateIndex` instances. While the collection uses normalized `DateIndex` objects in its implementation, it surfaces those implementation details as little as possible as they are not semantically important.
*/
extension ImageTimeline {
    subscript (date: Date) -> UIImage? {
        get {
            return self[DateIndex(date)]
        }
        set {
            self[DateIndex(date)] = newValue
        }
    }
}

func ... (lhs: Date, rhs: Date) -> ClosedRange<DateIndex> {
    return DateIndex(lhs)...DateIndex(rhs)
}

func ..< (lhs: Date, rhs: Date) -> Range<DateIndex> {
    return DateIndex(lhs)..<DateIndex(rhs)
}
/*:
At this point, we've implemented everything that's required for `ImageTimeline` to conform to the `Collection` protocol. The Swift standard library includes default implementations that use the methods and properties we've defined so far to implement the remaining `Collection` requirements like `count`, `map`, and efficient slicing. Let's take a look at the timeline of images in action:
*/
var timeline = ImageTimeline()

for elem in loadElements() {
    timeline[elem.date] = elem.image
}

maySeventh
let image = timeline[maySeventh]

let view = UIView(frame: CGRect(x: 0, y: 0, width: timeline.count * 75, height: 75))
for (position, image) in timeline.enumerated() {
    let imageView = UIImageView(frame: CGRect(x: position * 75, y: 0, width: 75, height: 75))
    imageView.image = image ?? UIImage(named: "NoImage.jpg")
    view.addSubview(imageView)
}
view

/*:
## Refining the Collection
 
The timeline collection now sufficiently implements the syntactic, semantic, and performance requirements of the `Collection` protocol. However, we've missed out on some easy performance enhancements and additional functionality. By continually refining the collection, we can drastically improve performance and opt in to additional functionality.

The first of these refinements is the `BidirectionalCollection` protocol. The `BidirectionalCollection` protocol inherits from the `Collection` protocol and adds one method, `index(before:)`. The `index(before:)` method mirrors the `index(after:)` method–including the semantic and performance requirements–and decrements the index by one. Using the same constant time `Calendar` method, the extension below adopts `BidirectionalCollection` and implements the `index(before:)` method.

By adopting the `BidirectionalCollection` protocol, the timeline collection gains access to additional default implementation, such as `reversed()`, which provides an efficient reverse view into the collection, and a more efficient `suffix(_:)` operation.

    extension ImageTimeline: BidirectionalCollection {
        func index(before i: DateIndex) -> DateIndex {
            let previousDay = calendar.date(byAdding: .day, 
                                            value: -1, 
                                            to: i.date)!
            return DateIndex(previousDay)
        }
    }

The default implementation for `count` that is applied to forward or bidirectional collections retrieves the `startIndex` and then counts how many times `index(after:)` must be called to reach the `endIndex` of the collection. This is a reasonable `O(n)` implementation, but offers poor performance in the case where dates with images are spread far apart. It's also a problem that's easily resolved with a constant time implementation because dates are used as indices.

The `RandomAccessCollection` protocol can be adopted by collections that are able to compute the distance between two indices and advance multiple positions in constant time. For example, an array's index type is `Int`. `Array` conforms to `RandomAccessCollection` because you can add an offset to a position represented by an integer in constant time. When you adopt the `RandomAccessCollection` protocol, a more specific, faster default implementation for collection APIs like `count` is used instead.

Conforming to `RandomAccessCollection` imposes only _performance_ requirements. The methods defined below are provided to every collection through default implementations—a random access collection must implement both methods as `O(1)` operations to meet the performance expectations of the `RandomAccessCollection` protocol. The code below implements its two requirements in terms of `Calendar` methods that compute and compare dates.
*/
extension ImageTimeline {
    func distance(from start: DateIndex, to end: DateIndex) -> Int {
        return calendar.dateComponents([.day], from: start.date, to: end.date).day!
    }
    
    func index(_ i: DateIndex, offsetBy n: Int) -> DateIndex {
        let offsetDate = calendar.date(byAdding: .day, value: n, to: i.date)!
        return DateIndex(offsetDate)
    }
}

let fastCount = timeline.count

/*:
Here is the completed photo memory app:
*/
visualize(timeline)

/*:
- callout(Checkpoint): 
At this point you've processed and sliced collections using generic algorithms, and you've learned how standard library protocols combine to define collections and sequences. The concepts you've learned on this page apply whether or not you plan to implement your own custom collection type. By understanding how the standard library divides functionality into small protocols that work together to define many different types, you can write generic code that is flexible and expressive. More generally, the design patterns used by the standard library apply to your own code–consider reaching first for protocols and structures to improve how you reason about your code.
 
    In the next section, you'll convert the `ImageTimeline` from a collection of images to a generic collection that can store a timeline of any type of element.
****
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
*/
