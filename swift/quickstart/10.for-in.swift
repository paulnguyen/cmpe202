
/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/



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

