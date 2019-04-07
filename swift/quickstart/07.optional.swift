

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/


// You can use if and let together to work with values that might be missing.
// These values are represented as optionals. An optional value either
// contains a value or contains nil to indicate that a value is missing. Write
// a question mark (?) after the type of a value to mark the value as
// optional.

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




