// Tell Processing that my code uses the Image Export library
import imageexport.*;

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
