
/*
 
Groovy script has two scopes:

binding	— The binding is the global scope for the script.
local	— variables are scoped locally to the block that they’re declared in.
def - is used to declare "untyped" variables

REF:

    http://groovy-lang.org/style-guide.HTML
    http://groovy.jmiguel.eu/groovy.codehaus.org/Scoping+and+the+Semantics+of+%22def%22.html

*/

def msg "Message" ; // declare variable in local scope
hello = "Hello";  // defined variable of String type (binding scope)


void checkHello()
{
  world = "World!"  // defined variable of Dynamic type (binding scope)
  System.out.println(hello + " " + world);
}
checkHello() ;


/*

groovyc EX6_GroovyBindingScope.groovy 
javap -private -l EX6_GroovyBindingScope


Usage: javap <options> <classes>...

where options include:
   -c                        Disassemble the code
   -classpath <pathlist>     Specify where to find user class files
   -extdirs <dirs>           Override location of installed extensions
   -help                     Print this usage message
   -J<flag>                  Pass <flag> directly to the runtime system
   -l                        Print line number and local variable tables
   -public                   Show only public classes and members
   -protected                Show protected/public classes and members
   -package                  Show package/protected/public classes
                             and members (default)
   -private                  Show all classes and members
   -s                        Print internal type signatures
   -bootclasspath <pathlist> Override location of class files loaded
                             by the bootstrap class loader
   -verbose                  Print stack size, number of locals and args for methods
                             If verifying, print reasons for failure

*/

 