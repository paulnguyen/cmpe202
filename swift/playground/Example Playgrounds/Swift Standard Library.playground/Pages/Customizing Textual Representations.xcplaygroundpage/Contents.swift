/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Customizing Textual Representations of Values
When you display a model object on screen or debug code, it's often useful to create a textual representation of a value. In Swift, you use the `CustomStringConvertible` and `CustomDebugStringConvertible` protocols to declare that a type can be represented as a string for display or debugging purposes. When you create a type that conforms to one of these protocols, printing facilities like `print(_:)`, `debugPrint(_:)`, and string interpolation will use your custom properties to provide descriptions of objects, rather than falling back to the default object description.

Here's a new type, `Message`, along with a few instances of that type for a group chat:
*/
import Foundation

struct Message {
    let from: String
    let contents: String
    let date: Date
}

let messages = [
    Message(from: "Sandy", contents: "Hey, what's going on tonight?", date: messageDates[0]),
    Message(from: "Michelle", contents: "Studying for Friday's exam. You guys aren't?", date: messageDates[1]),
    Message(from: "Christian", contents: "Nope. That's what tomorrow is for. Let's get food, I'm hungry!", date: messageDates[2]),
    Message(from: "Michelle", contents: "Maybe. What do you want to eat?", date: messageDates[3])
]
/*:
If you print one of the messages, you get the default object description, which returns the description of each property of the structure in a list. This is okay–it does list all of the information in the structure—but it isn't formatted all that well for logging and debugging in this specific case: a chat app. You can adopt the `CustomDebugStringConvertible` protocol to customize how your type is represented for debugging.

The `CustomDebugStringConvertible` protocol has a single required property, `debugDescription`. The string you return from this property is used by functions such as `debugPrint(_:)` to provide a description of the instance. Let's conform to `CustomDebugStringConvertible`, and then try printing a message.
*/
extension Message: CustomDebugStringConvertible {
    public var debugDescription: String {
        return "[\(date) From: \(from)] \(contents)"
    }
}

debugPrint(messages[0])

/*:
This description is suitable for debugging, however when you display a chat message to a user, you'll probably want to use a more user-friendly timestamp adjusted to their local time. Let's conform to `CustomStringConvertible`, the user-friendly equivalent to `CustomDebugStringConvertible`. By providing a `CustomStringConvertible` description, string interpolation and `print(_:)` will no longer fall back to the `debugDescription` property.
*/
let dateFormatter = DateFormatter()
dateFormatter.doesRelativeDateFormatting = true
dateFormatter.dateStyle = .short
dateFormatter.timeStyle = .short

extension Message: CustomStringConvertible {
    public var description: String {
        return "\(contents)\n   \(from) \(dateFormatter.string(from: date))"
    }
}

print(messages[0])

/*:
- callout(Checkpoint):
At this point in the chapter, you've learned how `String` provides Unicode APIs to simplify universal text processing. You've also learned how to provide string representations of types for debugging and display.
****
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
*/
