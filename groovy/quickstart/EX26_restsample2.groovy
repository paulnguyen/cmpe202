/**

https://github.com/jgritman/httpbuilder/wiki/RESTClient

Simple Fake REST API:

http://jsonplaceholder.typicode.com/

GET:  http://jsonplaceholder.typicode.com/posts/1

{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit\nsuscipit recusandae consequuntur"
}

**/

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.XML
import groovyx.net.http.RESTClient
import groovy.json.JsonOutput

class Post {

  static final URL = 'http://jsonplaceholder.typicode.com'
  static final BASE_PATH = '/posts'

  def display(id) {

    def client = new RESTClient(URL)
    def response = client.get(
                     path: "${BASE_PATH}/${id}"
                   )

    assert response.status == 200
    assert response.contentType == JSON.toString()


    //println response.data
    //println response.data.getClass().getName()
    println "User ID = ${response.data.userId}"
    println "Post ID = ${response.data.id}"
    println "Title = ${response.data.title}"    

  }
}

Post p = new Post()
p.display('1')
