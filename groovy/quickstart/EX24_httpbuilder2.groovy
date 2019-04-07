
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.JSON
 
def http = new HTTPBuilder( 'http://ajax.googleapis.com' )
http.request( GET, JSON ) {
  uri.path = '/ajax/services/search/web'
  uri.query = [ v:'1.0', q: 'Calvin and Hobbes' ]
 
  response.success = { resp, json ->
    assert json.size() == 3
    println "Query response: "
    json.responseData.results.each {
      println "  ${it.titleNoFormatting} : ${it.visibleUrl}"
    }
  }
}


