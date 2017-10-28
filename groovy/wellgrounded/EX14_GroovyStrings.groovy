
/*
	Strings can contain Groovy Expressions (i.e. ${ })

*/

String name = 'Gweneth'
def x = 2
String crawling = "${name} is crawling ${3*x} feet!"
println crawling 


String single_quote = '${name} is crawling ${3*x} feet!'
println single_quote 


String multi_line = """
This is a test
This is another test
"""
println multi_line


