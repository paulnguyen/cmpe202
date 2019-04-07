import Foundation

public struct Message {
    public let from: String
    public let contents: String
    public let date: Date
    
    public init(from: String, contents: String, date: Date) {
        self.from = from
        self.contents = contents
        self.date = date
    }
}

extension Message: CustomDebugStringConvertible {
    public var debugDescription: String {
        return "[\(date) From: \(from)] \(contents)"
    }
}

private var dateFormatter: DateFormatter = {
    let formatter = DateFormatter()
    formatter.doesRelativeDateFormatting = true
    formatter.dateStyle = .short
    formatter.timeStyle = .short
    
    return formatter
}()

extension Message: CustomStringConvertible {
    public var description: String {
        return "\(contents)\n   \(from) \(dateFormatter.string(from: date))"
    }
}

public var messages: [Message] = [
    Message(from: "Sandy", contents: "Hey, what's going on tonight?", date: messageDates[0]),
    Message(from: "Michelle", contents: "Studying for Friday's exam. You guys aren't?", date: messageDates[1]),
    Message(from: "Christian", contents: "Nope. That's what tomorrow is for. Let's get food, I'm hungry!", date: messageDates[2]),
    Message(from: "Michelle", contents: "Maybe. What do you want to eat?", date: messageDates[3])
]
