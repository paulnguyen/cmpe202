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


/*
 
    Use a tuple to make a compound value—for example, to 
    return multiple values from a function. The elements 
    of a tuple can be referred to either by name or by number.
 
*/

print( "\ntuple values" )
print( "--------------" )
func calculateStatistics(scores: [Int]) -> (min: Int, max: Int, sum: Int) {
    var min = scores[0]
    var max = scores[0]
    var sum = 0
    
    for score in scores {
        if score > max {
            max = score
        } else if score < min {
            min = score
        }
        sum += score
    }
    
    return (min, max, sum)
}
let statistics = calculateStatistics(scores: [5, 3, 100, 3, 9])
print("scores: ", [5, 3, 100, 3, 9])
print("statistics: ", statistics)
print("statistics.sum: ", statistics.sum)
print("statistics.0: ", statistics.0)
print("statistics.1: ", statistics.1)
print("statistics.2: ", statistics.2)


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



