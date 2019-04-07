

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/


// if-else, for-in -- parentheses optional

print( "\nif-else, for-in" )
print( "---------------" )
let individualScores = [75, 43, 103, 87, 12]
var teamScore = 0
for score in individualScores {
    if score > 50 {
        teamScore += 3
    } else {
        teamScore += 1
    }
}
print("teamScore: ", teamScore)




