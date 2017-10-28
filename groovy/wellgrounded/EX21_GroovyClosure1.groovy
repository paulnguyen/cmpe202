

/*
 	http://groovy-lang.org/closures.html
*/


def closure = { param -> println( "hello ${param}" ) }
closure.call( "world!" )

closure = { greeting, name -> println( greeting + name) }
closure.call( "hello ", "world!" )


def sayHello(name)
{
    println "Hello There ${name}"
    return "Fun!"
}

println sayHello('John')

def closure = { param -> println( "hello ${param}" ) }
closure.call( "world!" )

def displayItem = { x -> println x+1 }
[1, 2, 3, 4, 5].each( displayItem )

printMe( it )
{
    println it
}
list = [1, 2, 3, 4, 5]
for ( item in list )
    printMe(item)
    
[1, 2, 3, 4, 5].each ( {println it} )