// Tell Processing to use the PDF and Grab library
import processing.pdf.*;
import grab.*;

// Activate the Grab library with mouse mode
// Left click: PDF, right click: JPG
Grab grab = new Grab(this, Mode.MOUSE);



// Basic setup() and draw() with keyboard interaction
char letterToDraw = 'a';

void setup() {
  size(500, 500);
  pixelDensity(displayDensity());
}

void draw() {
  background(0);
  fill(255);
  textSize(400);
  textAlign(CENTER);
  text(letterToDraw, width/2, height - 120);
}

void keyPressed() {
  letterToDraw = key;
}
