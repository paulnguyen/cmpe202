/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardExp implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String date = "" ;
	private ConcreteDecoratorSlash cds;
	private ConcreteDecoratorSpace cds1;
	private String date1 = "";
	private String date2 = "";
	private ICardDecorator c;


	public CreditCardExp(){
		cds = new ConcreteDecoratorSlash(c);
		cds1 = new ConcreteDecoratorSpace(c);
	}
    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( date.equals("") )
			return "[MM/YY]" + "  " ;
		else
			return "[" + date + "]" + "  " ;
	}	

	public void key(String ch, int cnt) {
		if ( cnt >= 17 && cnt <= 20  )
			date += ch ;
		if (date.length() == 4){
			date1 = cds.addCharacter(date.substring(0, 1));
			date2 = cds1.addCharacter(date.substring(2, 3));

			date = date1 + date2;
		}
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}