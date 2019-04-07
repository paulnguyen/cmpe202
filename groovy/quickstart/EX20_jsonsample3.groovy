/**

http://www.groovy-tutorial.org/basic-json/

READING JSON

**/


class Student {
    Number id
    String name
    Map results
}

class ClassReport {
    String testScore
    String projectScore
    String comment
}

import groovy.json.JsonSlurper
import java.nio.file.Paths

JsonSlurper slurper = new JsonSlurper()
def studentList

Paths.get('./EX20_jsonsample3.json').withReader { reader ->
    studentList = slurper.parse(reader)
}

println studentList.dump()