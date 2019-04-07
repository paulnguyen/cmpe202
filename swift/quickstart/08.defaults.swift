

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/


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





