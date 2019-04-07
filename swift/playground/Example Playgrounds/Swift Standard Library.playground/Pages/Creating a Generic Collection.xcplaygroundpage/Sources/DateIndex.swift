import Foundation

public let calendar = Calendar.current

let dateFormatter: DateFormatter = {
    let f = DateFormatter()
    f.dateFormat = "MMMM d"
    return f
}()

public struct DateIndex: Comparable, CustomDebugStringConvertible {
    public let date: Date
    
    public init (_ date: Date) {
        self.date = calendar.startOfDay(for: date)
    }
    
    public var debugDescription: String {
        return dateFormatter.string(from: date)
    }

    public static func == (lhs: DateIndex, rhs: DateIndex) -> Bool {
        return lhs.date == rhs.date
    }

    public static func < (lhs: DateIndex, rhs: DateIndex) -> Bool {
        return lhs.date.compare(rhs.date) == .orderedAscending
    }
}

public let today = Date()
public let tomorrow = calendar.date(byAdding: DateComponents(day: 1), to: today)!
public let dayAfterTomorrow = calendar.date(byAdding: DateComponents(day: 2), to: today)!
