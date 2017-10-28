

/*
	http://groovy-lang.org/closures.html
*/


def closure = { println "hello " + it }
closure.call( "world!" )

[1, 2, 3].each ( { item -> println "${item}" } )

[ "k1":"v1", "k2":"v2" ].each ( {key, value -> println key + "=" + value } )

