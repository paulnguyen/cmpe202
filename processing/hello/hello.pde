int x = 30;
HelloObject obj = new HelloObject() ;
//Robot hal = new Robot() ;

void setup() 
{
  size(500, 500);
  smooth() ;
  strokeWeight(3);
  strokeCap(ROUND);
  //background(#EAE6E6);
  
  // Only draw once
  //noLoop();
}

void draw() {

  background(#EAE6E6);
  
  // print hello world
  fill(0);
  text(obj.getMessage(), x, 60) ;
  println( obj.getMessage() ) ;

  // clear the screen on mouse press
  if (mousePressed)
  {
    fill(0) ;
    println( "Mouse Pressed" ) ;
  }
  else
  {  
    fill(255) ;
  }
  println( "mouse x: " + mouseX + " mouse y:" + mouseY ) ;
  //ellipse(mouseX, mouseY, 80, 80);
  rect(mouseX, mouseY, 220, 40);
  
  //hal.draw() ;
  
}

