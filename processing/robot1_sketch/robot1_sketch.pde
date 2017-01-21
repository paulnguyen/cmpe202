
int x = 30;
Robot hal = new Robot() ;

void setup() 
{
  size(500, 500);
  smooth() ;
  strokeWeight(3);
  strokeCap(ROUND);
  background(#EAE6E6);
  
  // Only draw once
  noLoop();
}

void draw() {  
  hal.draw() ;
}