/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Slicing Collections
You can use standard indexing operations to index and slice into any collection. When you slice into a collection, the returned value is typically related, but not the same as, the type of the object that you sliced. In the standard library, slicing operations on collection types instead produce efficient containers that represent a sub-sequence of the collection or collection slice. These slices often share many of the same methods and properties as their respective collections, but do not have their own storage. Instead, slices are _views_ into the collections they originated from. This means you can implement algorithms that work with slices without drastically growing your app's memory footprint.

For example, you can retrieve a slice containing the elements from the index 2 through the index 5 by creating a range and slicing into an existing array:
*/
let numbers = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
let numberSlice = numbers[2...5]

/*:
If you option-click on `numberSlice`, you'll notice that `numberSlice` is of type `ArraySlice<Int>`.
 
You can also create slices of a collection using a number of standard collection methods. The variations of the `prefix`, `suffix`, `dropFirst`, and `dropLast` methods all return slices of a collection. For example, you can retrieve a slice containing the last five elements of an array by using the `suffix(_:)` method.
*/
let numberSuffix = numbers.suffix(5)

/*:
The `suffix` method returns at most the number of elements you specify.
 
- Experiment: Try changing the value passed to the `suffix(_:)` method. What happens if you try to retrieve more than ten elements?
 
To make shopping faster, let's create a short list of the next few shopping list items that you could show in a glance on the user's Apple Watch. In the code below, the `glanceList(_:)` function retrieves a slice into `shoppingList` with at most 3 ingredients. If the list has fewer than 3 ingredients, the `shortList` slice includes the entire `shoppingList`. Finally, instead of creating a new array first, `glanceList(_:)` maps over the array slice and returns a dictionary representation of each ingredient. The app can send the array of ingredient dictionaries to the user's watch.
*/
func glanceList(_ list: [Ingredient]) -> [[String: AnyObject]] {
    let shortList = list.prefix(3)
    let serializedList = shortList.map { ingredient in
        return ingredient.dictionaryRepresentation
    }
    
    return serializedList
}
let glanceData = glanceList(shoppingList)

/*:
If a collection adopts the `RangeReplaceableCollection` protocol, you can replace a slice of a collection as well, swapping existing elements with new ones. For example, the recipe app has a feature that allows the user to pick replacement ingredients if there's something they don't like. Let's make a mutable copy of the shopping list and use the `replaceSubrange(_:with:)` method to swap out some of the items with suitable replacements.
*/
var swappedList = shoppingList
let chiliPowder = Ingredient(name: "Chili Powder", quantity: 1, price: 2, purchased: false)
let chives = Ingredient(name: "Chives", quantity: 5, price: 1, purchased: false)
let oregano = Ingredient(name: "Oregano", quantity: 2, price: 1, purchased: true)
swappedList.replaceSubrange(3...4, with: [chiliPowder, chives, oregano])
showIngredients(swappedList)

/*:
- Experiment: Notice that the code above replaces two ingredients with three. With the `RangeReplaceableCollection` protocol, you replace the entire slice at once with another collection. You can, for example, replace a range of elements with an empty collection. Try removing or adding ingredients to the replacement array above and see what happens.

- callout(Checkpoint): At this point you have learned how to process and slice collections. In the next section, you'll learn how to use protocols in the standard library to implement your own collection type.
****
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
*/
