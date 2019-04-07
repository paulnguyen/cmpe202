/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Access Nested Data

You can write an app that uses JSON from an external source
or an existing local format.
In either instance, you might find inconsistencies between
the structure of the concepts you're modeling in your app
and concepts modeled by the producer of the JSON.
Sometimes, a logical bundle of data for your Swift program is spread out
among several nested objects or arrays in the JSON you use.
Bridge the structural gap by writing a decodable type that matches
the structure of the JSON you're reading in.
The decodable type serves as an intermediate type that's safe to decode.
It serves as the data source in an initializer for the
type that you'll use in the rest of your app.

With intermediate types, you can use the most natural types in your own code
while maintaining compatibility with a variety of shapes of external JSON.

The example below introduces a type representing a grocery store
and a list of the products it sells:

*/
import Foundation

struct GroceryStore {
    var name: String
    var products: [Product]
    
    struct Product: Codable {
        var name: String
        var points: Int
        var description: String?
    }
}
/*:
An API might supply information about grocery stores using JSON that's structured as follows:
*/
let json = """
[
    {
        "name": "Home Town Market",
        "aisles": [
            {
                "name": "Produce",
                "shelves": [
                    {
                        "name": "Discount Produce",
                        "product": {
                            "name": "Banana",
                            "points": 200,
                            "description": "A banana that's perfectly ripe."
                        }
                    }
                ]
            }
        ]
    },
    {
        "name": "Big City Market",
        "aisles": [
            {
                "name": "Sale Aisle",
                "shelves": [
                    {
                        "name": "Seasonal Sale",
                        "product": {
                            "name": "Chestnuts",
                            "points": 700,
                            "description": "Chestnuts that were roasted over an open fire."
                        }
                    },
                    {
                        "name": "Last Season's Clearance",
                        "product": {
                            "name": "Pumpkin Seeds",
                            "points": 400,
                            "description": "Seeds harvested from a pumpkin."
                        }
                    }
                ]
            }
        ]
    }
]
""".data(using: .utf8)!
/*:
The JSON returned by the API contains more information than is needed
to populate the corresponding Swift type.
In particular, it has a structural incompatibility with the `GroceryStore` structure
defined earlier:
its products are nested inside aisles and shelves.
Although the provider of the JSON likely needs the extra information,
it might not be useful inside all of the apps that depend on it.

To extract the data you need from the outer containers,
you write a type that mirrors the shape of the source JSON
and mark it as `Decodable`.
Then, write an initializer on the type you'll use in the rest of your app
that takes an instance of the type that mirrors the source JSON.

In the example below, the `GroceryStoreService` structure serves as
an intermediary between the grocery JSON
and the `GroceryStore` structure that is ideal for its
intended use in an app:
*/
struct GroceryStoreService: Decodable {
    let name: String
    let aisles: [Aisle]
    
    struct Aisle: Decodable {
        let name: String
        let shelves: [Shelf]
        
        struct Shelf: Decodable {
            let name: String
            let product: GroceryStore.Product
        }
    }
}
/*:
Because the `GroceryStoreService` structure matches the structure
of the source JSON—including aisles and shelves—its conformance to the `Decodable`
protocol is automatic when the protocol is included in the structure's list of inherited types.
The `GroceryStore` structure's nested `Product` structure is reused in the `Shelf`
structure because the data uses the same names and types.

To complete the `GroceryStoreService` structure's role as an intermediate type,
use an extension to the `GroceryStore` structure.
The extension adds an initializer that takes a `GroceryStoreService` instance
and removes the unnecessary nesting
by looping through and discarding the aisles and shelves:

*/
extension GroceryStore {
    init(from service: GroceryStoreService) {
        name = service.name
        products = []
        
        for aisle in service.aisles {
            for shelf in aisle.shelves {
                products.append(shelf.product)
            }
        }
    }
}
/*:
Using the relationships between types in the examples above,
you can safely and succinctly read in JSON, pass it through the `GroceryStoreService`
intermediate type, and use the resulting `GroceryStore` instances in your app:
*/
let decoder = JSONDecoder()
let serviceStores = try decoder.decode([GroceryStoreService].self, from: json)

let stores = serviceStores.map { GroceryStore(from: $0) }

for store in stores {
    print("\(store.name) is selling:")
    for product in store.products {
        print("\t\(product.name) (\(product.points) points)")
        if let description = product.description {
            print("\t\t\(description)")
        }
    }
}
//: [Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
