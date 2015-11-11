
// REF:  http://groovy.codehaus.org/modules/http-builder/doc/index.html

import groovyx.net.http.*

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType
import groovyx.net.http.Method
import groovyx.net.http.RESTClient

import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.POST
import static groovyx.net.http.ContentType.XML


def payload = """
<?xml version="1.0" encoding="utf-8"?>
<Order>
	<OrderHeader>
		<OrderNumber>
			<BuyerOrderNumber>123456xxx</BuyerOrderNumber>
		</OrderNumber>
		<OrderIssueDate>20141001T00:00:00</OrderIssueDate>
		<OrderReferences>
			<AccountCode>
				<Reference>
					<RefNum>OPENAIR</RefNum>
				</Reference>
			</AccountCode>
			<QuoteReference>
				<Reference>
					<RefNum>None</RefNum>
				</Reference>
			</QuoteReference>
			<OtherOrderReferences>
				<ListOfReferenceCoded>
					<ReferenceCoded>
						<ReferenceTypeCoded>Other</ReferenceTypeCoded>
						<PrimaryReference>
							<Reference>
								<RefNum>E0</RefNum>
							</Reference>
						</PrimaryReference>
						<ReferenceDescription>PaperControlCode</ReferenceDescription>
					</ReferenceCoded>
					<ReferenceCoded>
						<ReferenceTypeCoded>Other</ReferenceTypeCoded>
						<PrimaryReference>
							<Reference>
								<RefNum>1EIO</RefNum>
							</Reference>
						</PrimaryReference>
						<ReferenceDescription>HeaderUserStatus</ReferenceDescription>
					</ReferenceCoded>
					<ReferenceCoded>
						<ReferenceTypeCoded>Other</ReferenceTypeCoded>
						<PrimaryReference>
							<Reference>
								<RefNum>5527</RefNum>
							</Reference>
						</PrimaryReference>
						<ReferenceDescription>OpenAirID</ReferenceDescription>
					</ReferenceCoded>
				</ListOfReferenceCoded>
			</OtherOrderReferences>
		</OrderReferences>
		<Purpose>
			<PurposeCoded>Original</PurposeCoded>
		</Purpose>
		<OrderType>
			<OrderTypeCoded>Order</OrderTypeCoded>
			<OrderTypeCodedOther>ZDR</OrderTypeCodedOther>
		</OrderType>
		<OrderCurrency>
			<Currency>
				<CurrencyCoded>USD</CurrencyCoded>
			</Currency>
		</OrderCurrency>
		<OrderLanguage>
			<Language>
				<LanguageCoded>en</LanguageCoded>
			</Language>
		</OrderLanguage>
		<OrderParty>
			<BuyerParty>
				<Party>
					<PartyID>
						<Identifier>
							<Agency>
								<AgencyCoded>AssignedByBuyerOrBuyersAgent</AgencyCoded>
							</Agency>
							<Ident>500907812</Ident>
						</Identifier>
					</PartyID>
					<OrderContact>
						<Contact>
							<ContactName>General Dynamics</ContactName>
						</Contact>
					</OrderContact>
				</Party>
			</BuyerParty>
			<BuyerTaxInformation>
				<PartyTaxInformation>
					<TaxIdentifier>
						<Identifier>
							<Agency>
								<AgencyCoded>AssignedByBuyerOrBuyersAgent</AgencyCoded>
							</Agency>
							<Ident>E</Ident>
						</Identifier>
					</TaxIdentifier>
				</PartyTaxInformation>
			</BuyerTaxInformation>
			<SellerParty>
				<Party>
					<PartyID>
						<Identifier>
							<Agency>
								<AgencyCoded>AssignedByBuyerOrBuyersAgent</AgencyCoded>
							</Agency>
							<Ident>500907812</Ident>
						</Identifier>
					</PartyID>
					<OrderContact>
						<Contact>
							<ContactName/>
						</Contact>
					</OrderContact>
				</Party>
			</SellerParty>
			<ShipToParty>
				<Party>
					<PartyID>
						<Identifier>
							<Agency>
								<AgencyCoded>AssignedByBuyerOrBuyersAgent</AgencyCoded>
							</Agency>
							<Ident>500907812</Ident>
						</Identifier>
					</PartyID>
					<NameAddress>
						<Name1>General Dynamics</Name1>
					</NameAddress>
					<ReceivingContact>
						<Contact>
							<ContactName>General Dynamics</ContactName>
						</Contact>
					</ReceivingContact>
				</Party>
			</ShipToParty>
			<BillToParty>
				<Party>
					<PartyID>
						<Identifier>
							<Agency>
								<AgencyCoded>AssignedByBuyerOrBuyersAgent</AgencyCoded>
							</Agency>
							<Ident>500907812</Ident>
						</Identifier>
					</PartyID>
					<OrderContact>
						<Contact>
							<ContactName>General Dynamics</ContactName>
						</Contact>
					</OrderContact>
				</Party>
			</BillToParty>
		</OrderParty>
		<OrderPaymentInstructions>
			<PaymentInstructions>
				<PaymentTerms>
					<PaymentTerm>
						<PaymentTermCoded>Other</PaymentTermCoded>
						<PaymentTermCodedOther>NT30</PaymentTermCodedOther>
					</PaymentTerm>
				</PaymentTerms>
				<PaymentMethod>
					<PaymentMeanCoded>Other</PaymentMeanCoded>
				</PaymentMethod>
			</PaymentInstructions>
		</OrderPaymentInstructions>
		<ListOfStructuredNote>
			<StructuredNote>
				<GeneralNote>Vann_Test Project-5635</GeneralNote>
				<NoteID>InvoiceComments</NoteID>
			</StructuredNote>
			<StructuredNote>
				<GeneralNote>FOR QUESTIONS:</GeneralNote>
				<NoteID>InvoiceComments</NoteID>
			</StructuredNote>
			<StructuredNote>
				<GeneralNote>ESP.SERVICESINVOICING@HP.COM</GeneralNote>
				<NoteID>InvoiceComments</NoteID>
			</StructuredNote>
		</ListOfStructuredNote>
	</OrderHeader>
	<OrderDetail>
		<ListOfItemDetail>
			<ItemDetail>
				<BaseItemDetail>
					<LineItemNum>
						<BuyerLineItemNum>1</BuyerLineItemNum>
					</LineItemNum>
					<LineItemType>
						<LineItemTypeCoded>Item</LineItemTypeCoded>
					</LineItemType>
					<ItemIdentifiers>
						<PartNumbers>
							<SellerPartNumber>
								<PartNum>
									<PartID>HP152A1</PartID>
								</PartNum>
							</SellerPartNumber>
						</PartNumbers>
						<Category>
							<CategoryID>57</CategoryID>
						</Category>
					</ItemIdentifiers>
					<TotalQuantity>
						<Quantity>
							<QuantityValue>1.0</QuantityValue>
							<UnitOfMeasurement>
								<UOMCoded>1</UOMCoded>
							</UnitOfMeasurement>
						</Quantity>
					</TotalQuantity>
				</BaseItemDetail>
				<PricingDetail>
					<ListOfPrice>
						<Price>
							<PricingType>
								<PriceTypeCoded>DiscountAmountAllowed</PriceTypeCoded>
							</PricingType>
							<UnitPrice>
								<UnitPriceValue>1000</UnitPriceValue>
							</UnitPrice>
						</Price>
					</ListOfPrice>
				</PricingDetail>
				<ListOfStructuredNote>
					<StructuredNote>
						<GeneralNote>Chan, Vann-02/26/15-</GeneralNote>
						<NoteID>InvoiceComments</NoteID>
					</StructuredNote>
				</ListOfStructuredNote>
			</ItemDetail>
		</ListOfItemDetail>
	</OrderDetail>
</Order>
""" 


// REF:  http://coderberry.me/blog/2012/05/07/stupid-simple-post-slash-get-with-groovy-httpbuilder/

def postText(String baseUrl, String path, payload, method = Method.POST) {
    try {
        def ret = null
        def http = new HTTPBuilder(baseUrl)
		http.auth.basic ('opa', 'hpopenair')
		http.parser.'application/xml' = http.parser.'text/plain'
		//http.ignoreSSLIssues()

        // perform a POST request, expecting TEXT response
        http.request(method, ContentType.XML ) {
            uri.path = path
			body = payload
			headers.Accept = 'text/xml'
			headers.'Content-Type' = "text/xml"
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            //uri.query = query

            // response handler for a success response code
            response.success = { resp, reader ->
                println "response status: ${resp.statusLine}"
                println 'Headers: -----------'
                resp.headers.each { h ->
                    println " ${h.name} : ${h.value}"
                }
                ret = reader.getText()
                println 'Response data: -----'
                println ret
                println '--------------------'
            }

		  // handler for any failure status code:
		  response.failure = { resp ->
		    println "Unexpected error: ${resp.status} : ${resp.statusLine.reasonPhrase}"
            println 'Headers: -----------'
            resp.headers.each { h ->
                println " ${h.name} : ${h.value}"
            }
   		  }

        }
        return ret

    } catch (groovyx.net.http.HttpResponseException ex) {
        ex.printStackTrace()
        return null
    } catch (java.net.ConnectException ex) {
        ex.printStackTrace()
        return null
    }
}

// Call Service
def response = postText( "https://h20243.www2.hp.com/", "/invoke/hpGateway:orderInbound", payload)

