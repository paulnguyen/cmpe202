

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/




/*
    A function can take another function as one of its arguments.
*/

print( "\nfunctions as function args (higher-order functions)" )
print( "---------------------------------------------------" )

func hasAnyMatches(list: [Int], condition: (Int) -> Bool) -> Bool {
    for item in list {
        if condition(item) {
            return true
        }
    }
    return false
}

func lessThanTen(number: Int) -> Bool {
    return number < 10
}

var numbers = [20, 19, 7, 12]
print( "numbers: ", numbers )
print( "lastThenTen: ", lessThanTen )
print( "hasAnyMatches(list: numbers, condition: lessThanTen): ", hasAnyMatches(list: numbers, condition: lessThanTen))


