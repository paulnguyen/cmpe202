
// Public access modifiers (optional)

class EX8_GroovyClassA
{
	private int x = -10 ;  
	public  int y =  10 ;
	        int z =  99 ;  // defaults to property
	        
	public  publicMethod() { return "hello" }
	private privateMethod() { return "world" }
	
	def dump() {
		println this.metaClass.methods*.name.sort().unique() 
	}
}

/*

Private fields access broken.  Fix in Groovy 3.X
https://issues.apache.org/jira/browse/GROOVY-3010

*/