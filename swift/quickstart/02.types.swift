

/*

    A Swift Tour

    https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html

*/


// Type Inference

let implicitInteger = 70
let implicitDouble = 70.0

print ("\(type(of: implicitInteger))")
print ("\(type(of: implicitDouble))")

// Explicit Type

let explicitDouble: Double = 70
print("explicitDouble:", explicitDouble )

// Type Conversion

let label = "The width is "
let width = 94
let widthLabel2 = label + String(width)
print ( widthLabel2 )

