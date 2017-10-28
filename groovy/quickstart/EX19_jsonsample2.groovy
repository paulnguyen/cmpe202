
import groovy.json.JsonBuilder

def builder = new JsonBuilder()
builder {
  invoices(1..3) { day ->                                       
    invoice(date: "2015-01-0$day") {                            
      item(count: day) {                                        
        product(name: 'ULC', dollar: 1499)                      
      }                                                         
    }                                                          
  }
}

println builder.toString()
//println builder.toPrettyString()

