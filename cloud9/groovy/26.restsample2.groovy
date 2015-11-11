/**

https://www.bingmapsportal.com/

Key: AqQT7jfu-KSQWWS-PYVdW8Yv9o00ws7wB6T14Em8EziYT7AswMgLILiRA4SDiO8v
Application Url: http://www.nguyenresearch.com
Key type: Basic / Education
Created date: 07/31/2015
Expiration date: None 


@Grab(
  group='org.codehaus.groovy.modules.http-builder',
  module='http-builder',
  version='0.6'
)

**/


import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.XML
import groovyx.net.http.RESTClient
import groovy.json.JsonOutput

class LocationFinder {

  static final KEY = 'AqQT7jfu-KSQWWS-PYVdW8Yv9o00ws7wB6T14Em8EziYT7AswMgLILiRA4SDiO8v'
  static final URL = 'http://dev.virtualearth.net'
  static final BASE_PATH = '/REST/v1/Locations/'

  def printCityCoordinates(countryCode, city) {

    def mapClient = new RESTClient(URL)
    def path = "${countryCode}/${city}"
    def response = mapClient.get(
                     path: "${BASE_PATH}${path}",
                     query: [key: KEY]
                   )

    assert response.status == 200
    assert response.contentType == JSON.toString()


    //println response.data
    println response.data.resourceSets.estimatedTotal
    //println response.data.getClass().getName()
    println JsonOutput.prettyPrint(response.data)

  }
}

LocationFinder map = new LocationFinder()
//map.printCityCoordinates('fr', 'paris')
map.printCityCoordinates('uk', 'london')
