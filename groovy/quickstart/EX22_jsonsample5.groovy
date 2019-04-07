/**

http://www.groovy-tutorial.org/basic-json/

BUILDING JSON

**/

import groovy.json.JsonBuilder

def json = new JsonBuilder()
def staffListExport = json.staff {
    '1234' {
        id 1234
        name 'Fred Nurk'
        position (
            department: 'Accounts',
            role: 'Manager'
        )
    }
}

println json.toPrettyString()


