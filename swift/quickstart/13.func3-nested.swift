

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/




/*
 
    Functions can be nested. Nested functions have 
    access to variables that were declared in the 
    outer function. You can use nested functions 
    to organize the code in a function that is 
    long or complex.
 
*/

print( "\nnested functions" )
print( "----------------" )

func returnFifteen() -> Int {
    var y = 10
    func add() {
        y += 5
    }
    add()
    return y
}

print( "returnFifteen(): ", returnFifteen() )

