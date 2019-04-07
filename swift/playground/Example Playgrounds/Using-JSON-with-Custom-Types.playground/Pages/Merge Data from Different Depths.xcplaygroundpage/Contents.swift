/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Merge Data from Different Depths

Sometimes the data model used by a JSON file or API doesn't match
the model you're using in an app.
When that happens, you may need to merge or separate objects from the JSON
when encoding and decoding.
As a result, the encoding or decoding of a single instance involves
reaching upward or downward in the JSON object's hierarchy.

The example below demonstrates a common occurrence of this style of data merging.
It models a grocery store that keeps track of the name, price, and other details
for each of the products it sells.
*/
import Foundation

let json = """
{
    "Banana": {
        "points": 200,
        "description": "A banana grown in Ecuador."
    },
    "Orange": {
        "points": 100
    }
}
""".data(using: .utf8)!
/*:
Notice that the name of the product is also the name of the key
that defines the rest of the details of the product.
In this case, that the information for the `"Banana"` product is stored
in an object nested under the product name itself.
However, it's only by convention that it's clear that
the name of the product comes from the object's identifying key.

By contrast, another formulation of the JSON structure could have had
a `"product"` key for each product and a `"name"` key to store each
of the individual product names.
That alternative formulation matches how you model the data in Swift,
as seen in the example below:
*/
struct GroceryStore {
    struct Product {
        let name: String
        let points: Int
        let description: String?
    }

    var products: [Product]

    init(products: [Product] = []) {
        self.products = products
    }
}
/*:
The following extension to the `GroceryStore` structure makes it conform
to the `Encodable` protocol, which brings the structure halfway to
eventual conformance to the `Codable` protocol.
Notably, it uses a nested *structure*, `ProductKey`,
rather than the more typical *enumeration* with the same kind of conformance
to the `CodingKey` protocol.
A structure is needed to account for a possibly unlimited number of coding keys
that might be used as names for instances of the `Product` structure.
*/
extension GroceryStore: Encodable {
    struct ProductKey: CodingKey {
        var stringValue: String
        init?(stringValue: String) {
            self.stringValue = stringValue
        }

        var intValue: Int? { return nil }
        init?(intValue: Int) { return nil }

        static let points = ProductKey(stringValue: "points")!
        static let description = ProductKey(stringValue: "description")!
    }
    
    func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: ProductKey.self)
        
        for product in products {
            // Any product's `name` can be used as a key name.
            let nameKey = ProductKey(stringValue: product.name)!
            var productContainer = container.nestedContainer(keyedBy: ProductKey.self, forKey: nameKey)
            
            // The rest of the keys use static names defined in `ProductKey`.
            try productContainer.encode(product.points, forKey: .points)
            try productContainer.encode(product.description, forKey: .description)
        }
    }
}
/*:
With the conformance to the `Encodable` protocol in the example above,
any `GroceryStore` instance can be encoded into JSON using a `JSONEncoder` instance:
*/
var encoder = JSONEncoder()
encoder.outputFormatting = .prettyPrinted

let store = GroceryStore(products: [
    .init(name: "Grapes", points: 230, description: "A mixture of red and green grapes."),
    .init(name: "Lemons", points: 2300, description: "An extra sour lemon.")
])

print("The result of encoding a GroceryStore:")
let encodedStore = try encoder.encode(store)
print(String(data: encodedStore, encoding: .utf8)!)
print()
/*:
The second half of implementing conformance to the `Codable` protocol is decoding.
The following extension completes the conformance for the `GroceryStore` structure.
As part of decoding incoming JSON objects,
the initializer loops over all of the keys of the first level of nesting in the object.
*/
extension GroceryStore: Decodable {
    public init(from decoder: Decoder) throws {
        var products = [Product]()
        let container = try decoder.container(keyedBy: ProductKey.self)
        for key in container.allKeys {
            // Note how the `key` in the loop above is used immediately to access a nested container.
            let productContainer = try container.nestedContainer(keyedBy: ProductKey.self, forKey: key)
            let points = try productContainer.decode(Int.self, forKey: .points)
            let description = try productContainer.decodeIfPresent(String.self, forKey: .description)

            // The key is used again here and completes the collapse of the nesting that existed in the JSON representation.
            let product = Product(name: key.stringValue, points: points, description: description)
            products.append(product)
        }

        self.init(products: products)
    }
}

let decoder = JSONDecoder()
let decodedStore = try decoder.decode(GroceryStore.self, from: json)

print("The store is selling the following products:")
for product in decodedStore.products {
    print("\t\(product.name) (\(product.points) points)")
    if let description = product.description {
        print("\t\t\(description)")
    }
}
//: [Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
