/**

http://www.groovy-tutorial.org/basic-json/

WRITING JSON

**/


import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class Position {
    String department, role
}

class StaffMember {
    Number id
    String name

    Position position

    def displayNameTag() {
        "Staff member: $name [$id]\n${position.role} - ${position.department}"
    }
}

def staffList = [
        new StaffMember(id: 1234, name: 'Fred Nurk',
                position: [ department: 'Accounts', role: 'Manager' ] as Position),
        new StaffMember(id: 8673, name: 'Alexa Sample',
                position: [ department: 'Accounts', role: 'Manager' ] as Position),
        new StaffMember(id: 4568, name: 'Jane Doe',
                position: [ department: 'Accounts', role: 'Manager' ] as Position),
        new StaffMember(id: 8473, name: 'Ian Random',
                position: [ department: 'Accounts', role: 'Manager' ] as Position)
]

//Convert the staffList to JSON using JsonOutput
def json = JsonOutput.toJson(staffList)
println JsonOutput.prettyPrint(json)

//Now read the JSON back in using JsonSlurper
JsonSlurper slurper = new JsonSlurper()
def staffListImport = slurper.parseText(json)

for (person in staffListImport) {
    StaffMember staff = person as StaffMember
    println staff.displayNameTag()
}



