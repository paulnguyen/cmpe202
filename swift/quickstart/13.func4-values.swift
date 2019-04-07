

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/



/*
 
 Functions are a first-class type. This means that a 
 function can return another function as its value.
 
*/

print( "\nfunctions as values" )
print( "-------------------" )

func makeIncrementer() -> ((Int) -> Int) {
    func addOne(number: Int) -> Int {
        return 1 + number
    }
    return addOne
}

var increment = makeIncrementer()

print( "increment: ", increment )
print( "increment(7): ", increment(7) )
