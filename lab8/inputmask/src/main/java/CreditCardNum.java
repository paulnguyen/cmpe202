/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String number = "" ;
	private String number1 = "";
	private String number2 = "";
	private String number3 = "";
	private String number4 = "";
	private ICardDecorator c;

	private ConcreteDecoratorSpace cds;

	public CreditCardNum()
	{
     	cds = new ConcreteDecoratorSpace(c);

	}

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( number.equals("") )
			return "[4444 4444 4444 4444]" + "  " ;
		else
			return "[" + number + "]" + "  " ;
	}	

	public void key(String ch, int cnt) {
		if ( cnt <= 16 ) {
			number += ch;
			if (number.length() == 16){
				number1 = cds.addCharacter(number.substring(0, 4));
				number2 = cds.addCharacter(number.substring(4, 8));
				number3 = cds.addCharacter(number.substring(8, 12));
				number4 = number.substring(12, 16);

				number = number1 + number2 + number3 + number4;
			}

		}
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}