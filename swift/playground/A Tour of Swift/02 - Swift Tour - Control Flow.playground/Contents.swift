
/*
    A Swift Tour
    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html
 */


// if-else, for-in -- parentheses optional
print( "\nif-else, for-in" )
print( "---------------" )
let individualScores = [75, 43, 103, 87, 12]
var teamScore = 0
for score in individualScores {
    if score > 50 {
        teamScore += 3
    } else {
        teamScore += 1
    }
}
print("teamScore: ", teamScore)


// optional values & if let -- Write a question mark (?) after
// the type of a value to mark the value as optional.
print( "\noptional values & if let" )
print( "------------------------" )
var optionalString: String? = "Hello"
print("optionalString == nil: ", optionalString == nil)

var optionalName: String? = "John Appleseed"
var greeting = "Hello!"
print("optionalName: ", optionalName)
if let name = optionalName {
    greeting = "Hello, \(name)"
    print( "greeting: ", greeting )
}

var optionalName2: String?  = nil
print("optionalName2: ", optionalName2)
if let name = optionalName2 {
    greeting = "Hello, \(name)"
    print( "greeting: ", greeting )
}


// ?? default value operator
// Another way to handle optional values is to provide
// a default value using the ?? operator. If the optional
// value is missing, the default value is used instead.

print( "\n?? default value operator" )
print( "-------------------------" )
let nickName: String? = nil
let fullName: String = "John Appleseed"
let informalGreeting = "Hi \(nickName ?? fullName)"
print( "informalGreeting:  ", informalGreeting )
let nickName2: String? = "Jonny"
var fullName2: String? = nil
let informalGreeting2 = "Hi \(nickName2 ?? fullName2)"
print( "informalGreeting2: ", informalGreeting2 )



/*
 Switches support any kind of data and a wide variety
 of comparison operations—they aren’t limited to integers
 and tests for equality.
 
 Note: there is no need to explicitly break out of the
 switch at the end of each case’s code
 */

print( "\nSwitch Statements" )
print( "-------------------" )
let vegetable = "red pepper"
switch vegetable {
case "celery":
    print("Add some raisins and make ants on a log.")
case "cucumber", "watercress":
    print("That would make a good tea sandwich.")
case let x where x.hasSuffix("pepper"):
    print("Is it a spicy \(x)?")
default:
    print("Everything tastes good in soup.")
}

/*
 
 You use for-in to iterate over items in a dictionary
 by providing a pair of names to use for each key-value
 pair. Dictionaries are an unordered collection, so their
 keys and values are iterated over in an arbitrary order.
 
 */

print( "\nfor-in to iterate over items in a dictionary" )
print( "--------------------------------------------" )
let interestingNumbers = [
    "Prime": [2, 3, 5, 7, 11, 13],
    "Fibonacci": [1, 1, 2, 3, 5, 8],
    "Square": [1, 4, 9, 16, 25],
]
var largest = 0
for (kind, numbers) in interestingNumbers {
    print(kind)
    for number in numbers {
        print (number)
        if number > largest {
            largest = number
        }
    }
}
print("largest = ",largest)


// while loop

print( "\nwhile-condition" )
print( "-----------------" )
var n = 2
while n < 100 {
    n *= 2
}
print(n)

print( "\nrepeat-while" )
print( "-----------------" )
var m = 2
repeat {
    m *= 2
} while m < 100
print(m)

// looping over index ranges

print( "\nlooping over index ranges" )
print( "-------------------------" )
var total = 0
for i in 0..<4 {
    total += i
}
print(total)

