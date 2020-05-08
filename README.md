# Grab Processing Library

Processing library for exporting a JPG or PDF of the current state of the sketch window via input from keyboard or mouse.

## Setup

Just add these 3 lines at the beginning of your Processing Sketch. Then, hit `p` key for exporting a PDF, and `j` key for a JPG.

```java
import processing.pdf.*;
import grab.*;
Grab grab = new Grab(this);

```

## Keyboard vs Mouse Mode

You can choose between keyboard or mouse mode by passing argument to the constructor.

Keyboard mode (`p` for PDF, `j` for JPG)

```java
Grab grab = new Grab(this); // Keyboard is default
```

```java
Grab grab = new Grab(this, Mode.KEYBOARD); // You can explicitly pass Mode.KEYBOARD too
```

Mouse mode (left click for PDF, right click for JPG)

```java
Grab grab = new Grab(this, Mode.MOUSE); // Pass Mode.MOUSE to use the mouse mode
```


## Keyboard Mode Example

Available under `File > Examples` then `Contributed Libraries > Grab > Grab_01_KeyboardMode`


```java
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
```


## Mouse Mode Example

Available under `File > Examples` then `Contributed Libraries > Grab > Grab_02_MouseMode`


```java
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
```