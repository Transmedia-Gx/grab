// Tell Processing that my code uses the Image Export library
import imageexport.*;

// Activate the Image Export library
// If you hit the p or j key,
// a PDF or jpeg image will be exported under exports/ directory
ImageExport export = new ImageExport(this);

void setup() {
  // Create a canvas size of 500x500
  size(500, 500);
  
  // Make the sketch crisp on RetinaDisplay
  pixelDensity(displayDensity());
}

void draw() {
  // Set the background to black
  background(0);
  
  // Use white fill color
  fill(255);
  
  // Draw a circle at the position of the mouse
  circle(mouseX, mouseY, 50);
}
