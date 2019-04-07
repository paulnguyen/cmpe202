import UIKit

public struct Ingredient: Equatable {
    public let name: String
    public let quantity: Int
    public let price: Int
    public let purchased: Bool
    public init(name: String, quantity: Int, price: Int, purchased: Bool) {
        self.name = name
        self.quantity = quantity
        self.price = price
        self.purchased = purchased
    }
    
    public var dictionaryRepresentation: [String: AnyObject] {
        get {
            return [
                "name": name as NSString,
                "quantity": quantity as NSNumber,
                "price": price as NSNumber,
                "purchased": purchased as NSNumber
            ]
        }
    }
}

public func == (lhs: Ingredient, rhs: Ingredient) -> Bool {
    return lhs.name == rhs.name
        && lhs.price == rhs.price
        && lhs.purchased == rhs.purchased
}

public let sampleIngredients: [Ingredient] = [
    Ingredient(name: "Tomato", quantity: 1, price: 2, purchased: false),
    Ingredient(name: "Saffron", quantity: 1, price: 6, purchased: false),
    Ingredient(name: "Chicken", quantity: 2, price: 3, purchased: true),
    Ingredient(name: "Rice", quantity: 1, price: 2, purchased: false),
    Ingredient(name: "Onion", quantity: 2, price: 1, purchased: true),
    Ingredient(name: "Garlic", quantity: 4, price: 1, purchased: false),
    Ingredient(name: "Pepper", quantity: 2, price: 3, purchased: false),
    Ingredient(name: "Salt", quantity: 1, price: 1, purchased: false)
]

func needToBuy(_ ingredient: Ingredient) -> Bool {
   return !ingredient.purchased
}

public let shoppingList = sampleIngredients.filter(needToBuy)

@available(iOS 9.0, *)
class MapCell: UITableViewCell {
    let leftTextLabel = UILabel()
    let middleTextLabel = UILabel()
    let rightTextLabel = UILabel()
    let stack = UIStackView()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        middleTextLabel.text = "→"
        middleTextLabel.textAlignment = .center
        middleTextLabel.font = UIFont.boldSystemFont(ofSize: 20)
        rightTextLabel.textAlignment = .right
        stack.distribution = .fillEqually
        stack.frame = self.contentView.bounds
        stack.addArrangedSubview(leftTextLabel)
        stack.addArrangedSubview(middleTextLabel)
        stack.addArrangedSubview(rightTextLabel)
        self.contentView.addSubview(stack)
    }
   
   required init?(coder aDecoder: NSCoder) {
      fatalError("init(coder:) has not been implemented")
   }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        stack.frame = self.contentView.bounds
    }
}

fileprivate let IngredientCellIdentifier = "IngredientCellIdentifier"

fileprivate class IngredientsListViewController: UITableViewController {
    var ingredients: [Ingredient]
    var filteredList: [Ingredient]?
    var transformed: [Int]?
    init(list: [Ingredient]) {
        ingredients = list
        super.init(style: .plain)
        
        self.view.frame = CGRect(x: 0, y: 0, width: 300, height: list.count * 44)
        
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: IngredientCellIdentifier)
        self.tableView.register(MapCell.self, forCellReuseIdentifier: "MapCell")
        self.tableView.separatorStyle = .singleLine
        self.tableView.separatorColor = .blue
    }
   
   required init?(coder aDecoder: NSCoder) {
      fatalError("init(coder:) has not been implemented")
   }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return ingredients.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let identifier = transformed == nil ? IngredientCellIdentifier : "MapCell"
        let cell = tableView.dequeueReusableCell(withIdentifier: identifier, for: indexPath)

        let ingredient = ingredients[indexPath.row]
        
        if let transforms = transformed {
            let mapCell = cell as! MapCell
            mapCell.leftTextLabel.text = "\(ingredient.quantity)x " + ingredient.name
            let transformedValue = transforms[indexPath.row]
            mapCell.rightTextLabel.text = "$\(transformedValue)"
        } else {
            cell.textLabel!.text = "\(ingredient.quantity)x " + ingredient.name
            cell.accessoryType = ingredient.purchased ? .checkmark : .none
            if filteredList != nil {
                cell.tintColor = UIColor.white
            }
            let keep = filteredList?.contains(ingredient) ?? true
            
            cell.textLabel!.textColor = keep ? UIColor.black : UIColor.white
            cell.backgroundColor = keep ? UIColor.white : UIColor(red: CGFloat(126/255.0), green: 72/255.0, blue: 229/255.0, alpha: 1.0)
        }
        return cell
    }
}

public func showIngredients(_ list: [Ingredient]) -> UIView {
    return IngredientsListViewController(list: list).view
}

public func visualize(_ list: [Ingredient], _ filteredList: [Ingredient]) -> UIView {
    let controller = IngredientsListViewController(list: list)
    controller.filteredList = filteredList
    return controller.view
}

public func visualize(_ list: [Ingredient], _ transformed: [Int]) -> UIView {
    let controller = IngredientsListViewController(list: list)
    controller.transformed = transformed
    return controller.view
}

public func visualize(_ list: [Ingredient], _ highlighted: Int?) -> UIView {
    if let highlighted = highlighted {
        let filteredList = list.prefix(upTo: highlighted) + list.suffix(from: highlighted + 1)
        return visualize(list, Array(filteredList))
    }
    return showIngredients(list)
}
