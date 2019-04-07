
background(255) ;
size(800, 800) ;

// Examples of loading a text file and a JPEG image
// from the data folder of a sketch.

String[] lines = loadStrings("helloworld.txt");
PImage image = loadImage("gumball.jpg");

println( "Image Width: " + image.height ) ;
println( "Image Height: " + image.width ) ;
printArray( lines ) ;

// Displays the image (centered on canvas) at its actual size
image(image, (width-image.width)/2, (height-image.height)/2);