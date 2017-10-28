
/*

Using Groovy Builders:

<person id='2'>
  <name>Gweneth</name>
  <age>1</age>
</person>


*/

import groovy.xml.*


def writer = new StringWriter()
def xml1 = new groovy.xml.MarkupBuilder(writer)
xml1.person(id:2) {
  name 'Gweneth'
  age 1
}
println "=== XML Builder ==="
println writer.toString()


/** ALSO:

Parsing XML into Groovy Beans:

XMLParser		- Supports GPath expressions for XML documents
XMLSlurper		- Similar to XMLParser but does so in a lazy loading manner
DOMCategory		- Low-level parsing of the DOM with some syntax support

http://docs.groovy-lang.org/latest/html/documentation/#gpath_expressions

**/

class XmlExample {
	static def PERSON =
	"""
		<person id='2'>
			<name>Gweneth</name>
			<age>1</age>
		</person>
	"""
}

class Person { def id; def name; def age}
def xml2 = new XmlParser().parseText(XmlExample.PERSON)
Person p = new Person(id: xml2.@id, name: xml2.name.text(), age: xml2.age.text())
println "=== XML to Groovy Bean ==="
println "ID: ${p.id} NAME: ${p.name} AGE: ${p.age}"
