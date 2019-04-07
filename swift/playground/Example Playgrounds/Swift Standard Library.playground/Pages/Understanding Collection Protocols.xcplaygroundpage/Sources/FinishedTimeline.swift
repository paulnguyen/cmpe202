import UIKit

extension Calendar : CustomPlaygroundQuickLookable {
  public var customPlaygroundQuickLook: PlaygroundQuickLook {
    return .text("Current calendar")
  }
}

private let calendar = Calendar.current

private var dateFormatter: DateFormatter?

private struct DateIndex: CustomDebugStringConvertible, Comparable {
    typealias Distance = Int
    let date: Date
    
    init (_ date: Date) {
        self.date = calendar.startOfDay(for: date)
    }
    
    var debugDescription: String {
        if dateFormatter == nil {
            dateFormatter = DateFormatter()
            dateFormatter!.dateFormat = "MMMM d"
        }
        return dateFormatter!.string(from: date)
    }

    public static func == (lhs: DateIndex, rhs: DateIndex) -> Bool {
        return lhs.date == rhs.date
    }

    public static func < (lhs: DateIndex, rhs: DateIndex) -> Bool {
        return lhs.date.compare(rhs.date) == .orderedAscending
    }
}

private func dateIsOrderedBefore(lhs: Date, rhs: Date) -> Bool {
    return lhs.compare(rhs) == .orderedAscending
}

private struct ImageTimeline: RandomAccessCollection {
    
    private var storage: [Date: UIImage] = [:]
    
    var startIndex = DateIndex(Date.distantPast)
    var endIndex = DateIndex(Date.distantPast)
    
    subscript (i: DateIndex) -> UIImage? {
        get {
            return storage[i.date]
        }
        set {
            if let value = newValue {
                // Adding a value
                storage[i.date] = value

                if isEmpty {
                    startIndex = i
                    endIndex = index(after: i)
                } else if i < startIndex {
                    startIndex = i
                } else if i >= endIndex {
                    endIndex = index(after: i)
                }
                
            } else {
                // Removing a value
                storage[i.date] = nil

                // Update start and/or end index if we've removed the first/last item
                if i == startIndex {
                    if let newStartDate = storage.keys.sorted(by: dateIsOrderedBefore).first {
                        startIndex = DateIndex(newStartDate)
                    } else {
                        startIndex = DateIndex(Date.distantPast)
                        endIndex = startIndex
                    }
                } else if i == endIndex {
                    if let newEndDate = storage.keys.sorted(by: dateIsOrderedBefore).last {
                        endIndex = index(after: DateIndex(newEndDate))
                    } else {
                        startIndex = DateIndex(Date.distantPast)
                        endIndex = startIndex
                    }
                }
            }
        }
    }
    
    subscript (date: Date) -> UIImage? {
        get {
            return self[DateIndex(date)]
        }
        set {
            self[DateIndex(date)] = newValue
        }
    }

    func index(after i: DateIndex) -> DateIndex {
        let nextDay = calendar.date(byAdding: .day, value: 1, to: i.date)!
        return DateIndex(nextDay)
    }
    
    func index(before i: DateIndex) -> DateIndex {
        let previousDay = calendar.date(byAdding: .day, value: -1, to: i.date)!
        return DateIndex(previousDay)
    }
    
    func distance(from start: DateIndex, to end: DateIndex) -> Int {
        return calendar.dateComponents([.day], from: start.date, to: end.date).day!
    }
    
    func index(_ i: DateIndex, offsetBy n: Int) -> DateIndex {
        let offsetDate = calendar.date(byAdding: .day, value: n, to: i.date)!
        return DateIndex(offsetDate)
    }
}

public var finishedApp: UIView = {
    var dates = ImageTimeline()
    for elem in loadElements() {
        dates[elem.date] = elem.image
    }
    
    return visualize(dates)
}()



