#include <stdio.h>
#include "gumball.h"

int main(int argc, char **argv)
{
	GUMBALL m1[1] ;
	GUMBALL m2[1] ;
	
	/* init gumball machines */
	init_gumball( m1, 1 ) ;
	init_gumball( m2, 10 ) ;
	
	printf("Simple Gumball Machine - Version 3\n");
	
	insert_quarter( m1 ) ;
	turn_crank( m1 ) ;
	insert_quarter( m1 ) ;
	turn_crank( m1 ) ;
	insert_quarter( m1 ) ;
	turn_crank( m1 ) ;

	insert_quarter( m2 ) ;
	turn_crank( m2 ) ;
	turn_crank( m2 ) ;
	insert_quarter( m2 ) ;
	eject_quarter( m2 ) ;
	
	return 0;
}


