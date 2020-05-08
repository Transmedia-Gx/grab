## Grab Processing Library

Processing library for exporting a JPG or PDF of the current state of the sketch window via input from keyboard or mouse.

### Setup

Just add these 3 lines at the beginning of your Processing Sketch. Then, hit `p` key for exporting a PDF, and `j` key for a JPG.

```java
import processing.pdf.*;
import grab.*;
Grab grab = new Grab(this);

```

### Keyboard vs Mouse Mode

You can choose between keyboard or mouse mode by passing argument to the constructor.

Keyboard mode (`p` for PDF, `j` for JPG)

```java
Grab grab = new Grab(this); // Keyboard is default
```

```java
Grab grab = new Grab(this, Mode.KEYBOARD); // You can explicitly pass Mode.KEYBOARD too
```

Mouse mode (left click for PDF, right click for JPG)

```
Grab grab = new Grab(this, Mode.MOUSE); // Pass Mode.MOUSE to use the mouse mode
```
