
// called only once at start-up
void setup() {
   size(400, 400);
   stroke(255);
   background(192, 64, 0);
} 

// called repeatedly by processing
void draw() {
  line(150, 25, mouseX, mouseY);
}