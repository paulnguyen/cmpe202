
/*

Using Groovy Builders:

{
    "person": {
        "id": 2,
        "name": "Gweneth",
        "age": 1
    }
}

*/

import groovy.json.*


def json1 = new groovy.json.JsonBuilder()
json1.person {
  id 2
  name 'Gweneth'
  age 1
}
println "=== JSON Builder ==="
println json1.toPrettyString()


/** ALSO:

Parsing JSON into Groovy Beans:

http://groovy-lang.org/json.html

**/

class JsonExample {
	static def PERSON =
	"""
	{
    	"person": {
        	"id": 2,
        	"name": "Gweneth",
        	"age": 1
    	}
	}	
	"""
}


class Person { def id; def name; def age}
def json2 = new JsonSlurper().parseText(JsonExample.PERSON)
Person p = new Person(id: json2.person.id, name: json2.person.name, age: json2.person.age)
println "=== JSON to Groovy Bean ==="
println "ID: ${p.id} NAME: ${p.name} AGE: ${p.age}"
