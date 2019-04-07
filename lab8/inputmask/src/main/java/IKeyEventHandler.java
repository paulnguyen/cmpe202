 
/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public interface IKeyEventHandler
{

    void key(String ch, int cnt) ; 				// send key entry events to screen 
    void setNext( IKeyEventHandler next) ;		// set next handler in event chain

}