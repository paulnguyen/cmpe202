
public interface IScreen
{

    void key(String keypad) ; 	// send key entry to screen 
    String message() ;      	// get screen message
    String advertisement() ;	// return ad message
 
 	String A() ;
	String B() ;
	String C() ;
	String D() ;
	String E() ;
	String F() ;
	String G() ;
	String H() ;

	void selectA() ;
	void selectB() ;
	void selectC() ;
	void selectD() ;
	void selectE() ;
	void selectF() ;
	void selectG() ;
	void selectH() ;

}
