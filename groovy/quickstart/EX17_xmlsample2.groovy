
import groovy.xml.MarkupBuilder

TimeZone.default = TimeZone.getTimeZone("CET")

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)                    

builder.invoices {
  for (day in 1..3) {
    def invDate = Date.parse('yyyy-MM-dd', "2015-01-0$day")
    invoice(date: invDate) {
      item(count: day) {
        product(name: 'ULC', dollar: 1499)
      }
    }
  }
}

println ( writer.toString() )




