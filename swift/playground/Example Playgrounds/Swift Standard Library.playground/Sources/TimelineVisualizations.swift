import UIKit

public func loadElements() -> [(date: Date, image: UIImage)] {
   let plistElements = NSArray(contentsOf: Bundle.main.url(forResource: "Timeline", withExtension: "plist")!)! as! [[String: AnyObject]]
    return plistElements.map { elem in
        return (date: elem["date"] as! Date, image: UIImage(named: elem["image"] as! String)!)
    }
}

fileprivate final class TimelineCollectionCell: UICollectionViewCell {
    let photoView = UIImageView()
    let dateLabel = UILabel()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        self.backgroundColor = UIColor.white
        
        photoView.contentMode = .scaleAspectFit
        photoView.translatesAutoresizingMaskIntoConstraints = false
        self.contentView.addSubview(photoView)
        
        dateLabel.font = UIFont.systemFont(ofSize: 12)
        dateLabel.textAlignment = .right
        dateLabel.numberOfLines = 1
        dateLabel.translatesAutoresizingMaskIntoConstraints = false
        self.contentView.addSubview(dateLabel)
        
        let hPhotoConstraints = NSLayoutConstraint.constraints(
            withVisualFormat: "|[photoView]|",
            options: [],
            metrics: nil,
            views: ["photoView": photoView])
        let hDateConstraints = NSLayoutConstraint.constraints(
            withVisualFormat: "|[dateLabel]|",
            options: [],
            metrics: nil,
            views: ["dateLabel": dateLabel])
        let vConstraints = NSLayoutConstraint.constraints(
            withVisualFormat: "V:|[dateLabel(<=14)]-3-[photoView(134)]|",
            options: [],
            metrics: nil,
            views: ["photoView": photoView, "dateLabel": dateLabel])
        self.contentView.addConstraints(hPhotoConstraints + hDateConstraints + vConstraints)
    }
   
   required init?(coder aDecoder: NSCoder) {
      fatalError("init(coder:) has not been implemented")
   }
}

fileprivate final class TimelineCollectionController: UICollectionViewController {
    let timelineCellIdentifier = "TimelineCellIdentifier"
    
    var elements = [(date: String, image: UIImage?)]()
    
    override func viewDidLoad() {
        self.collectionView!.backgroundColor = .white
        collectionView!.register(TimelineCollectionCell.self, forCellWithReuseIdentifier: timelineCellIdentifier)
        self.view.frame.size = CGSize(width: 1180, height: 160)
        collectionView!.contentInset = UIEdgeInsets(top: 5, left: 5, bottom: 5, right: 5)
    }
    
    override func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 1
    }
    
    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return elements.count
    }
    
    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: timelineCellIdentifier, for: indexPath) as! TimelineCollectionCell
        
        let (date, image) = elements[indexPath.row]
        cell.photoView.image = image ?? UIImage(named: "NoImage.jpg")
        cell.dateLabel.text = date
        
        return cell
    }
}

// UICollectionViewControllers are deallocated before their collection view is rendered unless you store them somewhere.
fileprivate var timelines = [TimelineCollectionController]()

fileprivate final class BorderView: UIView {
    fileprivate override func draw(_ rect: CGRect) {
        UIColor(white: CGFloat(0.75), alpha: 1.0).set()
        UIRectFill(rect)
    }
}

fileprivate func showTimelineCollection(_ elements: [(date: String, image: UIImage?)]) -> UIView {
    let layout = UICollectionViewFlowLayout()
    layout.scrollDirection = .horizontal
    layout.minimumInteritemSpacing = 0
    layout.minimumLineSpacing = 7
    layout.itemSize = CGSize(width: 134, height: 150)
    let timeline = TimelineCollectionController(collectionViewLayout: layout)
    timeline.elements = elements
    timelines.append(timeline)

    let topBorder = BorderView(frame: CGRect(x: 0, y: 0, width: 1180, height: 1))
    let bottomBorder = BorderView(frame: CGRect(x: 0, y: 161, width: 1180, height: 1))
    
    let view = UIView(frame: CGRect(x: 0, y: 0, width: 1180, height: 162))
    view.addSubview(topBorder)
    timeline.view.frame.origin.y = 1
    view.addSubview(timeline.view)
    view.addSubview(bottomBorder)
    
    return view
}

public let mayFirst = Date(timeIntervalSince1970: 1.4305e9)
public let maySeventh = Date(timeIntervalSince1970: 1.431e9)

public func visualize<C: Collection>(_ collection: C) -> UIView
  where C.Iterator.Element == UIImage?
{
  let elements = zip(collection.indices, collection).map { (x: (C.Index, UIImage?)) -> (date: String, image: UIImage?) in
        let (date, image) = x
        return (date: String(reflecting: date), image: image)
    }
    
    return showTimelineCollection(elements)
}
