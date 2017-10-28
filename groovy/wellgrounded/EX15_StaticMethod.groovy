
/* 
	Static Methods in Groovy
*/

class StringUtils
{
	static String sayHello(String name)
	{
		return "Hello ${name}!"
	}
}

println StringUtils.sayHello( "Bob" ) ;