import UIKit

public var pastAllowedLengthFunction: ((String) -> Range<String.Index>?)?

private let messageCellIdentifier = "MessageCell"

private class GroupChatController: UITableViewController {
    
    override init(style: UITableView.Style) {
        super.init(style: style)
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: messageCellIdentifier)
        view.frame = CGRect(x: 0, y: 0, width: 320, height: 300)
        tableView.separatorStyle = .singleLine
        tableView.separatorColor = .blue
        tableView.estimatedRowHeight = 60
    }
   
    required init?(coder aDecoder: NSCoder) {
       fatalError("init(coder:) has not been implemented")
    }
  
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return messages.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: messageCellIdentifier, for: indexPath)
        
        let attributedString = NSMutableAttributedString(string: String(describing: messages[indexPath.row]))
        if let redRangeFunction = pastAllowedLengthFunction,
           let redRange = redRangeFunction(messages[indexPath.row].contents)
        {
            let redAttribute: [NSAttributedString.Key: Any] = [
                .backgroundColor: #colorLiteral(red: 0.9859465361, green: 0, blue: 0.04060116783, alpha: 0.4969499144)
            ]
         
            let contents = messages[indexPath.row].contents
            let location = contents.distance(from:contents.startIndex, to: redRange.lowerBound)
            let length = contents.distance(from: redRange.lowerBound, to: redRange.upperBound)
            attributedString.setAttributes(redAttribute, range: NSRange(location: location, length: length))
        }
        
        cell.textLabel!.numberOfLines = 0
        cell.textLabel!.attributedText = attributedString
        return cell
    }
}

private let chatController = GroupChatController(style: .plain)
private var chatView: UIView {
    return chatController.view
}

public func showChatView(_ rangeFunc: @escaping (_ contents: String) -> Range<String.Index>?) -> UIView {
    pastAllowedLengthFunction = rangeFunc
    return chatView
}
