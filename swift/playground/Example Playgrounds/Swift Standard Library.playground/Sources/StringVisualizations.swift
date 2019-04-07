import UIKit

fileprivate enum Theme {
    enum Color {
        static let border = UIColor(red: CGFloat(184/255.0), green: 201/255.0, blue: 238/255.0, alpha: 1)
        static let shade = UIColor(red: CGFloat(227/255.0), green: 234/255.0, blue: 249/255.0, alpha: 1)
        static let highlight = UIColor(red: CGFloat(14/255.0), green: 114/255.0, blue: 199/255.0, alpha: 1)
    }
    enum Font {
        static let codeVoice = UIFont(name: "Menlo-Regular", size: 14)!
    }
}

fileprivate struct StyledString {
    let string: String
    let shaded: Bool
    let highlighted: Bool
    let bordered: Bool
}

fileprivate extension UILabel {
    convenience init(styledString: StyledString) {
        self.init()
        text = styledString.string
        textAlignment = .center
        font = Theme.Font.codeVoice
        textColor = styledString.highlighted ? Theme.Color.highlight : UIColor.black
        backgroundColor = styledString.shaded ? Theme.Color.shade : UIColor.white
        if (styledString.bordered) {
            layer.borderColor = Theme.Color.border.cgColor
            layer.borderWidth = 1.0
        }
    }
}

public func visualize(_ str: String) -> UIView {
    return _visualize(str)
}

public func visualize(_ str: String, index: String.Index) -> UIView {
   let range = index..<str.index(after:index)
   return _visualize(str, range: range)
}

public func visualize(_ str: String, range: Range<String.Index>) -> UIView {
    return _visualize(str, range: range)
}

fileprivate func _visualize(_ str: String, range: Range<String.Index>? = nil) -> UIView {
    let styledCharacters = zip(str.indices, str).map { arg -> StyledString in
        let (characterIndex, char) = arg
        let shaded = range?.contains(characterIndex) == true
        return StyledString(string: String(char), shaded: shaded, highlighted: false, bordered: true)
    }
    
    let characterLabels = styledCharacters.map(UILabel.init(styledString:))
    
    let styledIndices = str.indices.enumerated().map { arg -> StyledString in
        let (offset, characterIndex) = arg
        let nextCharacterIndex = str.index(after: characterIndex)
        let highlighted = range?.lowerBound == characterIndex || range?.upperBound == nextCharacterIndex
        
        return StyledString(string: String(offset), shaded: false, highlighted: highlighted, bordered: false)
    }
    
    let indexLabels = styledIndices.map(UILabel.init(styledString:))
    
    let charStacks: [UIStackView] = zip(characterLabels, indexLabels).map { arg -> UIStackView in
        let (charLabel, indexLabel) = arg
        let stack = UIStackView()
        stack.axis = .vertical
        stack.distribution = .fillEqually
        stack.addArrangedSubview(indexLabel)
        stack.addArrangedSubview(charLabel)
        return stack
    }
    
    let stackView = UIStackView(frame: CGRect(x: 0, y: 0, width: 25 * charStacks.count, height: 50))
    stackView.distribution = .fillEqually
    for stack in charStacks {
        stackView.addArrangedSubview(stack)
    }
    
    return stackView
}

public let messageDates = [
    Date().addingTimeInterval(-2000),
    Date().addingTimeInterval(-1500),
    Date().addingTimeInterval(-500),
    Date()
]
