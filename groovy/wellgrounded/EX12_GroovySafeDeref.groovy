/*

?.  = Groovy's Safe Dereference (in cases of NULL)

*/


class Person
{
	private String name
}


people = [null, new Person(name:"Gweneth")]

for (Person person: people) {
  println person?.name
}


/**  JAVA Version

List<Person> people = [null, new Person(name:"Gweneth")]

for (Person person: people) {
  if (person != null) {
    println person.getName()
  }
}

**/