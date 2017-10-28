
// Groovy Class

class EX8_GroovyClassB
{
	def static run()
	{
		EX8_GroovyClassA t = new EX8_GroovyClassA() ;
	
		// Dump MetaClass 
		//println t.class.metaClass.properties
		//println t.class.metaClass.methods
		t.class.metaClass.properties.each { println "property: ${it.name}" }
		t.class.metaClass.methods.each { println "method: ${it}" }

		
		// Test Access
		println "private  x: ${t.x}" ;  // private attribute, should fail
		println "public   y: ${t.y}" ;  // public attribute
		println "property z: ${t.z}" ;  // public property (has backing setter/getter)
	}
}


