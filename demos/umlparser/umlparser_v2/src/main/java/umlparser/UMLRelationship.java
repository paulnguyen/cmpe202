
package umlparser ;

/*

[Customer]-[Order]   					// Association
[Customer]->[Order]               		// Association (Directional)
[Customer]<->[Order]               		// Association (Bi-Directional)
[Customer]<>->[Order]             		// Aggregation
[Customer]++->[Order]             		// Composition
[Customer]1-0..1>[Order]          		// Cardinality
[Customer]1-0..orders 1>[Order]   		// Assoc Labels
[Customer]-.-[note: DAO]          		// Notes
[Parent]^[Child]               			// Inheritance
[Child]-^[Parent]               		// Inheritance
[Customer|name;address|save()]    		// Properties
[≪IDisposable≫;Customer]          		// Interface
[Customer|var arr［］ ]            		// Brackets
[Customer {bg:green}]             		// Colour
[Client]]uses-.->[<<interface>>;I] 		// Uses an Interface
[Class]-.-^[<<interface>>;I]			// Implements an Interface

*/


class UMLRelationship {

	public String key ;			// --,            uses-->,      <*>-->         <>-->
	public String type ;		// "association", "dependency", "composition", "aggregation"
	public String source ;
	public String target ;
	public String source_multiplicity ;
	public String target_multiplicity ;

}