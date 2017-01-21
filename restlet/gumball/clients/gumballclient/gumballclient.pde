
PFont font;

int x1 = 275;
int y1 = 700;
int w1 = 80;
int h1 = 30;  

int x2 = 425;
int y2 = 700;
int w2 = 80;
int h2 = 30;  

GumballMachine gumballMachine ;

void setup() 
{
  size(800, 800) ;
  background(255) ;
  smooth() ;
  strokeWeight(2);
  strokeCap(ROUND);
  
  // load font
  font = loadFont("BookAntiqua-48.vlw");
  
  // Set Up Gumball Machine
  gumballMachine = new GumballMachine();
  System.out.println(gumballMachine);
  

}

void draw() {
  fill(0);  
  
  // Display Gumball Machine Text
  textFont(font, 32);
  text("The Gumball Machine", 250, 75);
  
  // Display Gumball Image 
  PImage image = loadImage("gumball.jpg");
  image.resize(400, 400);
  image(image, (width-image.width)/2, (height-image.height)/2 + 85);  
  
  // Render Message Box
  textFont(font, 14);
  fill(255);
  rect(200, 100, 400, 175);
  fill(0);
  text(gumballMachine.toString(), 210, 115);
  
  // Render Button 1
  textFont(font, 14);
  if ((mouseX > x1) && (mouseX < x1+w1) &&
    (mouseY > y1) && (mouseY < y1+h1)) {
    fill(#D3D3D3);
    rect(x1, y1, w1, h1);
    fill(0);
    text("Insert Coin", x1+5, y1+18);
  } else {
    fill(255);
    rect(x1, y1, w1, h1);
    fill(0);
    text("Insert Coin", x1+5, y1+18);
  }

  // Render Button 2
  if ((mouseX > x2) && (mouseX < x2+w2) &&
    (mouseY > y2) && (mouseY < y2+h2)) {
    fill(#D3D3D3);
    rect(x2, y2, w2, h2);
    fill(0);
    text("Turn Crank", x2+5, y2+18);
  } else {
    fill(255);
    rect(x2, y2, w2, h2);
    fill(0);
    text("Turn Crank", x2+5, y2+18);
  }
    
}

void mouseClicked() {
   println( "Clicked x=" + mouseX + " y=" + mouseY ) ; 
   if ((mouseX > x1) && (mouseX < x1+w1) &&
    (mouseY > y1) && (mouseY < y1+h1)) {
      println( "Insert Coin Clicked!" ) ;  
      fill(0);
      rect(x1, y1, w1, h1);
      fill(255);
      text("Insert Coin", x1+5, y1+18);
      System.out.println(gumballMachine);
      gumballMachine.insertQuarter();
 }
   if ((mouseX > x2) && (mouseX < x2+w2) &&
    (mouseY > y2) && (mouseY < y2+h2)) {
      println( "Turn Crank Clicked!" ) ;  
      fill(0);
      rect(x2, y2, w2, h2);
      fill(255);
      text("Turn Crank", x2+5, y2+18);
      System.out.println(gumballMachine);
      gumballMachine.turnCrank();
   }
}