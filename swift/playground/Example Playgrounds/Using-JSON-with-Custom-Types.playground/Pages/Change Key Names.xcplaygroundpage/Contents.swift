/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Change Key Names

Names you use in your Swift code don't always match
the names in JSON that refer to the same values.
When working with the `JSONEncoder` and `JSONDecoder` classes in Swift,
you can easily adopt conventional Swift names in your data types even
when using JSON that requires the use of other names.

To create a mapping between Swift names and JSON names,
you use a nested enumeration named `CodingKeys` within the same type that
adds conformance to `Codable`, `Encodable`, or `Decodable`.

In the example below, see how the Swift property name `points` is mapped to and from
the name `"product_name"` when the property is encoded and decoded.
*/
import Foundation

let json = """
[
    {
        "product_name": "Bananas",
        "product_cost": 200,
        "description": "A banana grown in Ecuador."
    },
    {
        "product_name": "Oranges",
        "product_cost": 100,
        "description": "A juicy orange."
    }
]
""".data(using: .utf8)!

struct GroceryProduct: Codable {
    var name: String
    var points: Int
    var description: String?
    
    private enum CodingKeys: String, CodingKey {
        case name = "product_name"
        case points = "product_cost"
        case description
    }
}

let decoder = JSONDecoder()
let products = try decoder.decode([GroceryProduct].self, from: json)

print("The following products are available:")
for product in products {
    print("\t\(product.name) (\(product.points) points)")
    if let description = product.description {
        print("\t\t\(description)")
    }
}
/*:
Although the name `description` is consistent between the two representations,
you still include it in the `CodingKeys` enumeration
because it's a value required by the `GroceryProduct` structure.
Its enumeration case doesn't need an explicit raw value because
its name is the same as the corresponding property name.
*/
//: [Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
