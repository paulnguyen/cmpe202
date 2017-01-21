
int x = 30;
HelloObject obj = new HelloObject() ;

void setup() 
{
  size(500, 500);
  smooth() ;
  strokeWeight(3);
  strokeCap(ROUND);
  background(#EAE6E6);
  
  // Only draw once
  //noLoop();
}

void draw() {

  background(#EAE6E6);
  
  // print hello world
  fill(0);
  text(obj.getMessage(), x, 60) ;
   
}