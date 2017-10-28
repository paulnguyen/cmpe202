
/*
**  http://groovy-lang.org/closures.html
*/

greeting = 'Hello'

def demo() {
	greeting = "Bonjour"
    def closure = { p -> print "${greeting} ${p}\n" }
    return closure
}

c = demo()
c.call( 'Ken' )