

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/


/*
 
    Functions are actually a special case of closures: blocks of 
    code that can be called later. The code in a closure has access
    to things like variables and functions that were available in 
    the scope where the closure was created, even if the closure 
    is in a different scope when it is executed—you saw an example 
    of this already with nested functions. 
 
    You can write a closure without a name by surrounding code 
    with braces ({}).
 
    Use in to separate the arguments and return type from the body.

*/

print( "\nclosures" )
print( "---------" )

var numbers = [20, 19, 7, 12]

print( "numbers: ", numbers )
print( "numbers (map 3x):" )
print( numbers.map({ (number: Int) -> Int in
    let result = 3 * number
    return result
 }))

/*  Rewrite the closure to return zero for all odd numbers.  */

print( "\nRewrite the closure to return zero for all odd numbers." )
print( "-------------------------------------------------------" )

print( "numbers: ", numbers )
print( "result:" )
print ( numbers.map({ (number: Int) -> Int in
    if number % 2 != 0 {
        return 0
    }
    else {
        return number
    }
}))

/*
 
    You have several options for writing closures more concisely. 
    When a closure’s type is already known, such as the callback 
    for a delegate, you can omit the type of its parameters, 
    its return type, or both. Single statement closures implicitly 
    return the value of their only statement.
 
*/

print( "\nSingle statement closures implicitly return the value of their only statement")
print( "-----------------------------------------------------------------------------" )

print( "closure: { number in 10 * number }" )
let mappedNumbers = numbers.map({ number in 10 * number })
print(mappedNumbers)


/*
 
    You can refer to parameters by number instead of by name—this 
    approach is especially useful in very short closures. A closure 
    passed as the last argument to a function can appear immediately 
    after the parentheses. When a closure is the only argument to 
    a function, you can omit the parentheses entirely.
 
*/

print( "\nYou can refer to parameters by number instead of by name" )
print( "--------------------------------------------------------" )

let sortedNumbers1 = numbers.sorted { n1, n2 in n1 > n2 }
print(sortedNumbers1)

let sortedNumbers2 = numbers.sorted { $0 > $1 }
print(sortedNumbers2)


/* Reduce:
 
    When numbers.reduce(_:_:) is called, the following steps occur:
 
    (1) The nextPartialResult closure is called with initialResult—0 in
        this case—and the first element of numbers, returning the sum: 1.
 
    (2) The closure is called again repeatedly with the previous call’s 
        return value and each element of the sequence.
 
    (3) When the sequence is exhausted, the last value returned from 
        the closure is returned to the caller.
 
    (4) If the sequence has no elements, nextPartialResult is never 
        executed and initialResult is the result of the call to reduce(_:_:).
 
*/

print( "\nreduce" )
print( "------" )

let nums = [1, 2, 3, 4]
print( "nums: ", nums)
let sum = nums.reduce(0, { x, y in x + y })
print( "reduce: let sum = nums.reduce(0, { x, y in x + y })")
print(sum)



