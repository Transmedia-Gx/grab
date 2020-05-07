// Tell Processing to use the Image Export and PDF library
import imageexport.*;
import processing.pdf.*;

// Activate the Image Export library
// Hit p key for exporting PDF, and j for jpg
ImageExport export = new ImageExport(this);



// Basic setup() and draw()
void setup() {
  size(500, 500);
  pixelDensity(displayDensity());
}

void draw() {
  background(0);
  fill(255);
  circle(mouseX, mouseY, 50);
}
