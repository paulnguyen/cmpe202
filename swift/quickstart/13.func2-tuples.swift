

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/




/*
 
    Use a tuple to make a compound value. For example, to 
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



