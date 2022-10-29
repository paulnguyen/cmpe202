
greeting = 'Hello'

def demo() {
    def greeting = "Bonjour"
    def closure = { p -> print "${greeting} ${p}\n" }
    return closure
}

c = demo()
c.call( 'Ken' )
println greeting





