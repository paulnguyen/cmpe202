

//=== STRINGS ===

// strings 16-bit unicode (ucs2)

"x" ; // no chars, use string
'abc' ;
"abc" ;  // single or double is fine
"abc's" ; // no escape
'abc\'s' ; // have to escape
var x = "12345678" ;
x.length ; // 8
"12345678".length ; // 8
"abc" + "123" ; // concat strings
"abc" + 123 ; // converts 123 to string
5 + 3 + " number" ; // 8 number
"abcdefg".indexOf( "def" ) ; // 3
"abcdefg".substr(3,3) ; // def
"abcdefg".slice(3,6) ; // def
"a,b,c,d,e,f".split(",") ; //  ['a','b','c','d','e','f']
"   ab   c  defg   ".trim() ; // 'ab   c  defg'

/*
> 5+3
8
> 5+3+"hello"
'8hello'
> 5+(3+"hello")
'53hello'
*/

