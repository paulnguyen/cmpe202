
/*

 Use protocol to declare a protocol.
 
*/
 
 protocol ExampleProtocol {
    var simpleDescription: String { get }
    mutating func adjust()
 }
 
/*

 Classes, enumerations, and structs can all adopt protocols.
 
*/

// Notice the use of the mutating keyword in the declaration
// of SimpleStructure to mark a method that modifies the structure.

struct SimpleStructure: ExampleProtocol {
    var simpleDescription: String = "A simple structure"
    mutating func adjust() {
        simpleDescription += " (adjusted)"
    }
}
var b = SimpleStructure()
b.adjust()
let bDescription = b.simpleDescription


// The declaration of SimpleClass doesn’t need any of its methods
// marked as mutating because methods on a class can always modify the class.

class SimpleClass: ExampleProtocol {
    var simpleDescription: String = "A very simple class."
    var anotherProperty: Int = 69105
    func adjust() {
        simpleDescription += "  Now 100% adjusted."
    }
}
var a = SimpleClass()
a.adjust()
let aDescription = a.simpleDescription



/*

    Experiment: Write an enumeration that conforms to this protocol.

*/

enum SimpleEnum: ExampleProtocol {
    
    case Default, Adjusted
    
    init() {
        self = .Default
    }
    
    var simpleDescription: String { get { return "\(self) Value" }}
    
    mutating func adjust() {
        self = .Adjusted
    }
}

var simpleEnum = SimpleEnum()
simpleEnum.adjust()
let adjustedSimple = simpleEnum.simpleDescription


/*

    Use extension to add functionality to an existing type, 
    such as new methods and computed properties. 
 
    You can use an extension to add protocol conformance 
    to a type that is declared elsewhere, or even to a 
    type that you imported from a library or framework.
 
 */

extension Int: ExampleProtocol {
    var simpleDescription: String {
        return "The number \(self)"
    }
    mutating func adjust() {
        self += 42
    }
}

print(7.simpleDescription)
//7.adjust()





