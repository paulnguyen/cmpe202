/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Indexing and Slicing Strings
It's common to think of a string as a sequence of the characters you see on screen. However, what you perceive as a character may in some cases be represented by multiple, variable-length Unicode scalars in memory. For example, it requires more bits to encode a character like the top hat emoji (`🎩`) than a simple character like the letter `A`, and it requires multiple Unicode scalars to represent characters with combining marks, such as é⃝. For more information about Unicode support in Swift, see [Strings and Characters](https://developer.apple.com/library/ios/documentation/Swift/Conceptual/Swift_Programming_Language/StringsAndCharacters.html#//apple_ref/doc/uid/TP40014097-CH7-ID285) in _The Swift Programming Language_.

In Swift, the `String` type handles these details for you. Each `Character` element in a string represents a user-perceived Unicode character, regardless of the character's length or representation in memory. However, because of this abstraction, it doesn't make sense to index into a string using integers. Instead, the standard library includes `String.Index`, a type that better represents a position in any string, regardless of its representation in memory.

Take a look at the string below, which contains various Unicode characters of different sizes and complexity.
*/
var str = "Héllo, 🇺🇸laygr😮und!"
/*:
Here's what it looks like when you plot the string's characters against their user-perceived indices. Notice that even though the flag (🇺🇸) is actually a grapheme cluster made up of two combining Unicode scalars, Swift counts the flag as just one user-perceived character. This makes tasks like form validation, cursor positioning, and text wrapping much simpler to implement. Counting, indexing, and slicing are all based on user-perceived character indices, rather than the layout of the string in memory.
*/
visualize(str)

/*:

- Experiment: Try changing the `str` variable and see how the string visualizations in the playground change. You can add special characters by placing your cursor inside the string and going to Edit > Emoji & Symbols in the menu bar.
 
  When you're done, you can copy and paste the original string back into the variable: `"Héllo, 🇺🇸laygr😮und!"`

Take a look at the counts in the code below. A string is a collection of the Unicode characters in the string, while the `utf16` property contains a collection of the UTF-16 code points. If you compare the number of user-perceived characters with the number of UTF-16 code points in the string, you'll find that the number of UTF-16 code points is higher than the number of Unicode characters.
*/
str.count
str.utf16.count

/*:
Let's create a range that you can use to index and slice the string. At first glance, you might attempt to create a range from integers. If you option-click the `badRange` constant below, you'll notice that this line of code creates a value of type `CountableRange<Int>`. This isn't exactly right–you usually want to slice the string on user-perceived characters. If you uncomment the line of code after, you'll get a compiler error, because you can't subscript a `String` value with a range of integers.
*/
let badRange = 3..<10
//str[badRange] // uncomment this line to see error
/*:
Instead, you can use specialized `String.Index` objects to index and slice strings. Every string has a `startIndex` and an `endIndex`, and you can pass the indices to the string's `index(after:)` and `index(before:)` methods to increment or decrement them, respectively. You can also use the `index(_:offsetBy:)` method to offset an index–the integer you pass in is used to determine how many times to invoke `index(after:)` or `index(before:)`. The `String.Index` type is Unicode-aware, so the `index(_:offsetBy:)` method will always advance a string index correctly. The `index(_:offsetBy:)` method takes into account any large or complex Unicode characters to make sure your range starts, advances, and ends on a complete, user-perceived character.

- Note: The `endIndex` of a string or a range is always one past the end. This makes it easier to check if it's empty: If the `startIndex` and the `endIndex` are equal, then there are no characters in the string. It also makes it easier to check where you are: If your current index is equal to the `endIndex`, then you have reached the end. Therefore, it is a runtime error to call `str[endIndex]` because you are asking for a character at an index past the end of the string.

Try option-clicking the `range` constant. The `index(_:offsetBy:)` method returns a value with the same type as the original index you pass in, so the `..<` range operator produces a range of that type.
*/
let range = str.index(str.startIndex, offsetBy: 3)..<str.index(str.startIndex, offsetBy: 10)
/*:
Because the `index(_:offsetBy:)` method offsets any index by a specified integer amount, you can use the `index(_:offsetBy:)` method to retrieve a character at a certain index in a string.
*/
str[str.index(str.startIndex, offsetBy: 7)]
visualize(str, index: str.index(str.startIndex, offsetBy: 7))

/*:
Now that you have a range of `String.Index` values, you can use the indexing subscript operator with the lower or upper bound of a range as well. By using `String.Index` values as the start and endpoint of the range, you're guaranteed to retrieve a fully-formed character–whether it's a simple ASCII character at the `lowerBound` or an emoji character at the `upperBound`.
*/
str[range.lowerBound]
visualize(str, index: range.lowerBound)
str[range.upperBound]
visualize(str, index: range.upperBound)

/*:
Putting it all together, you can use the `range` variable we created above to retrieve a slice of the string. Notice that the last character in the returned slice is not the same as the character returned when you retrieved the character at the `upperBound` above. The upper bound of a range is just like the `endIndex` of a collection—always one past the end. Algorithms that operate on indices take that information into account.

- Experiment: Try changing the `range` variable to start and end on different offsets from the `startIndex` of the string.
*/
str[range]
visualize(str, range: range)

/*:
## Applying Concepts
Using the patterns you learned on this page, let's build a group chat application that promotes quick messaging by limiting message length to 30 characters. 

The app needs to indicate when a user's message is over the character limit. In the code below, the closure passed to the `showChatView` function uses a special version of the method you saw used above to offset an index. The `index(_:offsetBy:limitedBy:)` method takes an end index limit in addition to the start index and offset that you've seen previously. This version of the method increments the `startIndex` up to the `endIndex` without overrunning the end. If the string is less than 30 characters long (the value of `messageLimit`), the `index(_:offsetBy:limitedBy:)` method returns `nil`, so you know you didn't reach the desired offset. If the string is over 30 characters, the closure returns a range starting at the message limit and extending to the end of the message. The app takes the range returned by the method and highlights that range in red.
*/
let messageCharacterLimit = 30
let chatView = showChatView { (contents: String) -> Range<String.Index>? in
    if let i = contents.index(contents.startIndex, offsetBy: messageCharacterLimit, limitedBy: contents.endIndex) {
        return i < contents.endIndex ? i..<contents.endIndex : nil
    }
    return nil
}
chatView

/*:
- Experiment: Try changing the `messageCharacterLimit` variable. Notice how messages that are less than the character limit are handled properly by the `index(_:offsetBy:limitedBy:)` method.

- callout(Checkpoint): At this point, you've read about the `String` type's Unicode character handling and learned how to index into and slice strings. On the next page, you'll learn how to customize the way your types are printed and displayed.
****
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
*/
