/*:
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
****
# Understanding Value Semantics
Sequences and collections in the standard library use _value semantics_, which makes it easy to reason about your code. Every variable has an independent value, and references to that value aren't shared. For example, when you pass an array to a function, that function can't accidentally modify the caller's copy of the array.

Over the next few pages, we'll use a recipe app with a shopping list feature to illustrate how collections work in the standard library.

To illustrate value semantics, let's write a function that takes a recipe's ingredients list and displays a table with the ingredients sorted alphabetically. Here's the list of ingredients, with check marks indicating items that have already been purchased:
*/
import UIKit
showIngredients(sampleIngredients)

/*:
The `sortedList(_:)` function uses the `sort(by:)` method to sort the ingredients in place. You'll learn more about sorting in [Processing Sequences and Collections](Processing%20Sequences%20and%20Collections).
*/
func sortedList(_ list: [Ingredient]) -> [Ingredient] {
    var list = list
    list.sort { first, second in
        return first.name.localizedStandardCompare(second.name) == .orderedAscending
    }
    
    return list
}
let finalList = sortedList(sampleIngredients)
showIngredients(finalList)

/*:
The `sortedList(_:)` function sorts the passed-in array, and then returns it. With reference semantics, where instances are shared, this would be a dangerous operation. The `sampleIngredients` variable and the `list` variable would share a reference to the same array object, and any operations performed inside `sortedList(_:)` would apply to the `sampleIngredients` array as well, reordering the original list.
 
Because arrays in Swift have value semantics, the `sampleIngredients` array keeps its independent value when it's passed to the `sortedList(_:)` function. Within the function, the `list` array is its own unique collection of elements that can be modified independently. You can verify below that all of the the ingredients are present in the original order in the original array:
*/
showIngredients(sampleIngredients)

/*:
Arrays in Swift use an optimization called *copy-on-write* to provide value semantics efficiently. A copy of an array, like the `list` variable in the `sortedList` function, can share storage with the original array until the value of the original array or the copy is changed. At that point, the elements of the modified instance are copied to preserve the independence of the arrays. This optimization lets Swift provide reliable value semantics while still guaranteeing excellent performance.
 
- callout(Checkpoint): 
At this point, you have learned how sequences and collections in the standard library use value semantics to improve safety and make it easier to reason about your code. In the next section, you'll learn how to use generic algorithms and basic functional concepts to process and manipulate sequences and collections.
****
[Table of Contents](Table%20of%20Contents) | [Previous](@previous) | [Next](@next)
*/
