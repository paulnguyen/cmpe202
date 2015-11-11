
class Person {

    String name
    Integer age

    Person( name, age ) {
        this.name = name
        this.age = age
    }

}

def person1 = new Person( 'Marie', 1 )
def person2 = ['Marie', 2] as Person
Person person3 = [ 'Marie', 3]


