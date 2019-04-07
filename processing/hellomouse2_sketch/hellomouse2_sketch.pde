
// called only once at start-up
void setup() {
   size(400, 400);
   stroke(255);
} 

// called repeatedly by processing
// referesh background with each call
void draw() {
  background(192, 64, 0);
  line(150, 25, mouseX, mouseY);
}