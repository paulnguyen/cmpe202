

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/



/* functions
 
   Use func to declare a function. Call a function by following its name
   with a list of arguments in parentheses. Use -> to separate the parameter
   names and types from the function’s return type.
 
*/

print( "\nfunctions" )
print( "---------" )

func greet(person: String, day: String) -> String {
    return "Hello \(person), today is \(day)."
}
print( greet(person: "Bob", day: "Tuesday") )


// function argument labels - note "_" == no label

print( "\nfunctions with argument labels" )
print( "--------------------------------" )

func greet(_ person: String, on day: String) -> String {
    return "Hello \(person), today is \(day)."
}
print( greet("John", on: "Wednesday") )



