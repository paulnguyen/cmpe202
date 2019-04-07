
def list = [1, 2, 3]
for (i in list) { println i }

println list[0]
println list[1]
println list[2]


def list = ["hello" ,2 ,"goodbye", [1,2,3]]

for ( item in list )
{
    println item.getClass().getName()
    println item ;
    if ( item.getClass().getName().equals("java.util.ArrayList") )
    {
        //println item.size() ;
        for ( innerItem in item )
            println innerItem ;
    }
}