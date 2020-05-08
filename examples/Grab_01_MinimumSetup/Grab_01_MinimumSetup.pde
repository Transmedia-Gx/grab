// Tell Processing to use the PDF and Grab library
import processing.pdf.*;
import grab.*;

// Activate the Grab library
// Hit p key for exporting PDF, and j for jpg
Grab grab = new Grab(this);



// Basic setup() and draw() with mouse interaction
void setup() {
  size(500, 500);
  pixelDensity(displayDensity());
}

void draw() {
  background(0);
  fill(255);
  circle(mouseX, mouseY, 50);
}
