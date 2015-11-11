
class Person {

    String name
    Integer age

    Person( name, age ) {
        this.name = name
        this.age = age
    }

    def greetings() {
        println "Hello and welcome, ${this.name}"
    }

}

def person1 = new Person( 'Marie', 1 )
def person2 = ['Marie', 2] as Person
Person person3 = [ 'Marie', 3]

person1.greetings()
person2.greetings()
person3.greetings()





