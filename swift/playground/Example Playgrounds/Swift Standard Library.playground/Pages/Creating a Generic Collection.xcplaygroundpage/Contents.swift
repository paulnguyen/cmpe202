/*:
 [Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
 ****
 # Creating a Generic Collection
 
 In the last section, you created a collection for images over a continuous range of dates. While the `ImageTimeline` collection served its purpose in the daily photo app, a collection that could store any type of data over a range of dates would be much more versatile, able to store strings, custom types, or even other collections organized by date. Let's create a new, generic version of the timeline collection, called `Timeline`.
 
 The `ImageTimeline` collection only needs a few changes to be generic:
 
 1. Generic types declare a *generic parameter* in their type declaration, so instead of `struct ImageTimeline`, declare the new type with `struct Timeline<Element>`. The `Element` parameter becomes a placeholder for the specific type of the collection's elements: When you create a `Timeline` instance later, the `Element` type can be a string, a number, or an array of images.
 2. The required indexed subscript must return the collection's `Element` type. We'll change the date-based subscript to return an `Element` as well.
 3. The `storage` declaration changes from a `[Date: UIImage]` dictionary to a `[Date: Element]` dictionary. The value type of the dictionary will match the element type of any instance of the `Timeline` collection.
 
 Here's the implementation of the `Timeline<Element>` collection, reusing the `DateIndex` type from the last section:
 */
import UIKit
struct Timeline<Element>: RandomAccessCollection {
   
    var storage: [Date: Element] = [:]
    
    var startIndex = DateIndex(Date.distantPast)
    var endIndex = DateIndex(Date.distantPast)
    
    subscript (i: DateIndex) -> Element? {
        get {
            return storage[i.date]
        }
        set {
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
    
    subscript (date: Date) -> Element? {
        get {
            return self[DateIndex(date)]
        }
        set {
            self[DateIndex(date)] = newValue
        }
    }
    
    func index(after i: DateIndex) -> DateIndex {
        let nextDay = calendar.date(byAdding: DateComponents(day: 1), to: i.date)!
        return DateIndex(nextDay)
    }
    
    func index(before i: DateIndex) -> DateIndex {
        let previousDay = calendar.date(byAdding: DateComponents(day: -1), to: i.date)!
        return DateIndex(previousDay)
    }
    
    func distance(from start: DateIndex, to end: DateIndex) -> Int {
        return calendar.dateComponents([.day], from: start.date, to: end.date).day!
    }
    
    func index(_ i: DateIndex, offsetBy n: Int) -> DateIndex {
        let offsetDate = calendar.date(byAdding: DateComponents(day: n), to: i.date)!
        return DateIndex(offsetDate)
    }
}
/*:
 With the generic `Timeline<Element>` collection, you can store any type of data organized by date. For example, let's create a "word of the day" collection, which stores a `(String, String)` tuple for every dated entry. Here's a `wordsOfTheDay` collection for today and the following two days:
 */
var wordsOfTheDay = Timeline<(word: String, definition: String)>()
wordsOfTheDay[today]            = ("chicanery", "trickery; subterfuge")
wordsOfTheDay[tomorrow]         = ("enigma", "puzzle; mystery")
wordsOfTheDay[dayAfterTomorrow] = ("laconic", "using few words; brief")

// The collection spans three days:
wordsOfTheDay.count

// The first word is 'chicanery':
wordsOfTheDay.first??.word

/*:
 In the `wordsOfTheDay` collection, the `Element` type is a tuple of two strings: `(word: String, definition: String)`.
 
 Finally, here's the photo memory app once again, this time using the generic collection as its source for dates and photos:
 */
var imageTimeline = Timeline<UIImage>()

for elem in loadElements() {
   imageTimeline[elem.date] = elem.image
}
visualize(imageTimeline)
/*:
 - callout(Checkpoint):
 In this section you converted a type-specific collection that only stores images to a generic collection that can store any type of value. Even if you don't create more generic collections of your own, you've now seen how generics in the standard library allow type-safe collections to be created easily and without boilerplate.
****
 [Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
 */
