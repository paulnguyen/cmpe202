


/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/


// Maps

var occupations = [
    "Malcolm": "Captain",
    "Kaylee": "Mechanic",
]
occupations["Jayne"] = "Public Relations"
print( "occupations: ", occupations )

// Using Initializer to create empty Map

let emptyDictionary = [String: Float]()
print( "emptyDictionary: ", emptyDictionary )

// Alternative Empty Map Notation

occupations = [:]
print( occupations )
