/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Processing Sequences and Collections
Sequences and collections implement methods such as `map(_:)`, `filter(_:)`, and `reduce(_:_:)` to consume and transform their contents. You can compose these methods together to efficiently implement complex algorithms.

A collection's `filter(_:)` method returns an array containing only the elements that pass the provided test. Let's create a shopping list by filtering out ingredients that have already been purchased.
*/
let shoppingList = sampleIngredients.filter { ingredient in
    return !ingredient.purchased
}
visualize(sampleIngredients, shoppingList)

/*:
The `map(_:)` method returns a new array by applying a `transform` to each element in a collection. For example, the following code multiplies the quantity of the ingredient by the cost of the ingredient to find the total cost for each ingredient.
*/
let totalPrices = shoppingList.map { ingredient in
    return ingredient.quantity * ingredient.price
}
visualize(shoppingList, totalPrices)

/*:
You can use the `reduce(_:_:)` method to combine elements of an array into a single value. The `reduce(_:_:)` method takes an initial value to start with and then a closure or function to combine each element in the array with the previous value. The following code takes the total price list and adds them together to compute a final remaining cost:
*/
let sum = totalPrices.reduce(0) { currentPrice, priceToAdd in
    return currentPrice + priceToAdd
}
sum

/*:
- Experiment: Try changing the initial value from `0` to another number. How does this affect the final sum?

The `map(_:)`, `filter(_:)`, and `reduce(_:_:)` methods compose naturally, so you can collapse the code above into a single operation. The following code example implements the `remainingCost` function, used by the app to display the remaining cost for a recipe.
*/
func remainingCost(_ list: [Ingredient]) -> Int {
    return list.filter { !$0.purchased }
               .map { $0.quantity * $0.price }
               .reduce(0) { $0 + $1 }
}
let cost = remainingCost(sampleIngredients)

/*:
 
## Sorting and Searching
 
Sequences and collections also provide methods to sort their contents or find an element matching specific criteria. Depending on the contents of your collection, you can use simple variations of these methods. For example, you can sort an array of elements that are comparable by default, like numbers or strings, with just the `sorted()` method. The following code creates a new array from the list of total prices, sorted from lowest to highest:
*/
let sortedTotals = totalPrices.sorted()

/*:
To sort an array of a type that doesn't have a defined ordering, the `sorted(by:)` method takes a closure that returns `true` if the first element should be ordered before the second. Let's sort the ingredients by their prices:
*/
let sortedIngredients = sampleIngredients.sorted { $0.price < $1.price }
showIngredients(sortedIngredients)

/*:
- Experiment: Can you reverse the sorting order of the ingredients, so the most expensive ingredient is listed first? How would you sort the list by quantity instead of price?

The methods for finding an element in a collection work the same way. When a collection's elements can be compared for equality (that is, they conform to the `Equatable` protocol), you can pass any value to the collection's `index(of:)` method to find its position in the collection. The following code creates a new array of just the names of the ingredients and then finds the position of rice in the array:
 */
let ingredientNames = sampleIngredients.map { $0.name }
if let i = ingredientNames.index(of: "Rice") {
    ingredientNames[i]
}

/*:
 Alternatively, you can use a collection's `index(where:)` method to find the position of the first element that passes the provided test. Here's how you can find the first ingredient that has already been purchased:
 */
let purchased: Int? = sampleIngredients.index(where: { $0.purchased })
visualize(sampleIngredients, purchased)

/*:
There are many more generic algorithms in the standard library similar to those above that you can compose together.

- callout(Checkpoint): 
At this point you have learned how to process sequences and collections and why value semantics make it easier to reason about the code you write. In the next section, you'll learn how to use ranges to slice into collections.
****
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
*/
