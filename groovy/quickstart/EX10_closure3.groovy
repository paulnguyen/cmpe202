

/*
**  http://groovy-lang.org/closures.html
*/


greeting='Hello'
def clos={ param -> println "${greeting} ${param}" }
clos.call( 'World' )

greeting='Welcome'
clos.call( 'World' )

def demo(c) {
    def greeting='Bonjour'
    c.call( 'Ken' )
}
demo(clos)

def outer() {
    def greeting='Goodbye'
    return { p -> println "${greeting} ${p}" }
}
greeting='Welcome'
clos=outer()
clos.call( 'Ken' )