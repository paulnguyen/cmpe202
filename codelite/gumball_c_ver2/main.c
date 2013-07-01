#include <stdio.h>
#include "gumball.h"

int main(int argc, char **argv)
{
	GUMBALL m1[1] ;
	GUMBALL m2[1] ;
	
	/* init gumball machines */
	init_gumball( m1, 1 ) ;
	init_gumball( m2, 10 ) ;
	
	printf("Simple Gumball Machine - Version 2\n");
	
	insert_quarter( m1, 25 ) ;
	turn_crank( m1 ) ;
	insert_quarter( m1, 25 ) ;
	turn_crank( m1 ) ;
	insert_quarter( m1, 10 ) ;
	turn_crank( m1 ) ;

	insert_quarter( m2, 25 ) ;
	turn_crank( m2 ) ;
	insert_quarter( m2, 25 ) ;
	turn_crank( m2 ) ;
	insert_quarter( m1, 10 ) ;
	turn_crank( m2 ) ;
	
	return 0;
}


