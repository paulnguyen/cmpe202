
/* 

Java Way
========

public void sendMessageToClient(
    @Nullable Client client,
    @Nullable String message,
    @NotNull Mailer mailer
) {
    if (client == null || message == null) return;

    PersonalInfo personalInfo = client.getPersonalInfo();
    if (personalInfo == null) return;

    String email = personalInfo.getEmail();
    if (email == null) return;

    mailer.sendMessage(email, message);
}

Kotlin Way
==========

fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
){
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

*/



// Main

fun main(args: Array<String>) {

	// val name1 : String = null // not allowed
	val name2 : String = "Bob"
	val name3 : String? = null // Ok

    println( "name2: $name2, name3: $name3" )
    println ( "** name2 **")
    print_name( name2 )
    println ( "** name3 **")
    print_name( name3 )

}


fun print_name( name : String? ) {

	// explicit check -- like in Java
	if ( name != null ) {
		// Safe to dereference name in here!
		println( "Print if not null: $name" )
	}

	// safe dereference operator: ?
	val upper : String? = name?.toUpperCase()
	println( "Upper if not null: $upper" )

	// Using let & lambda expression
	name?.let { it : String -> 
		// In here. It's safe to assume not null!
		println( "Safe upper if not null: ${it.toUpperCase()}" )
	}

}


