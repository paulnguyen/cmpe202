#include <stdio.h>#include "gumball.h"void init_gumball( GUMBALL *ptr, int size ) {	ptr->num_gumballs = size ;	ptr->has_quarter = 0 ;}void turn_crank( GUMBALL *ptr ){	if ( ptr->has_quarter )
	{
		if ( ptr->num_gumballs > 0 )
		{
			ptr->num_gumballs-- ;
			ptr->has_quarter = 0 ;
			printf( "Thanks for your quarter.  Gumball Ejected!\n" ) ;
		}
		else
		{
			printf( "No More Gumballs!  Sorry, can't return your quarter.\n" ) ;
		}
	}
	else 
	{
		printf( "Please insert a quarter\n" ) ;
	}}void insert_quarter( GUMBALL *ptr, int coin ){	if ( coin == 25 )
		ptr->has_quarter = 1 ;
	else 
		ptr->has_quarter = 0 ;}