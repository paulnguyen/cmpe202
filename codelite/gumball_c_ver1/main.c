#include <stdio.h>

int has_quarter = 0 ;
int num_gumballs = 1 ;

void insert_quarter( int coin )
{
	if ( coin == 25 )
	   has_quarter = 1 ;
	else 
		has_quarter = 0 ;
}

void turn_crank()
{
	if ( has_quarter )
	{
		if ( num_gumballs > 0 )
		{
			num_gumballs-- ;
			has_quarter = 0 ;
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
	}
}

int main(int argc, char **argv)
{
	printf("Simple Gumball Machine - Version 1\n");
	insert_quarter( 25 ) ;
	turn_crank() ;
	insert_quarter( 25 ) ;
	turn_crank() ;
	insert_quarter( 10 ) ;
	turn_crank() ;
	return 0;
}

