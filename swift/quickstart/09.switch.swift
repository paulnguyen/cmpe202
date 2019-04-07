
/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/


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


