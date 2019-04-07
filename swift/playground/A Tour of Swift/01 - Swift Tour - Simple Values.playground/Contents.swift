
/*
    A Swift Tour
    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html
 */

// Constants and Variables

let const = 10
var variable = 10
print ( "const + variable = ", const + variable )

// Type Inference

let implicitInteger = 70
let implicitDouble = 70.0

// Explicit Type

let explicitDouble: Double = 70
print("explicitDouble:", explicitDouble )

// Type Conversion

let label = "The width is "
let width = 94
let widthLabel2 = label + String(width)
print ( widthLabel2 )

// Arrays

var shoppingList = ["catfish", "water", "tulips", "blue paint"]
shoppingList[1] = "bottle of water"
print( "shoppingList: ", shoppingList )

// Maps

var occupations = [
    "Malcolm": "Captain",
    "Kaylee": "Mechanic",
]
occupations["Jayne"] = "Public Relations"
occupations["Malcolm"]
print( "occupations: ", occupations )

// Using Initializer to create empty Array or Map

let emptyArray = [String]()
let emptyDictionary = [String: Float]()

// Alternative Empty Array/Map Notation

shoppingList = []
occupations = [:]

print( "emptyArray: ", emptyArray )
print( "emptyDictionary: ", emptyDictionary )

