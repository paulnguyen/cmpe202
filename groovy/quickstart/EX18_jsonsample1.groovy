
import groovy.json.JsonBuilder

def builder = new JsonBuilder()
builder.weeks {
  capacity '8'
  tasks(
    [{
      done '0'
      total '4'
      title 'build web service'
    }, {
      done '0'
      total '1'
      title 'build web service client'
    }]
  )
}

//println builder.toString()
println builder.toPrettyString()


