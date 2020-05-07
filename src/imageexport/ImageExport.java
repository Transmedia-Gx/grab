package imageexport;

import processing.core.*;
import processing.event.KeyEvent;

/**
 * An easy-to-use pdf/jpeg exporter
 */
public class ImageExport implements PConstants {
	
	// myParent is a reference to the parent sketch
	PApplet parent;
	
	// Version of the library
	public final static String VERSION = "##library.prettyVersion##";
	
	// default key for jpg export
	private final static String JPG_KEY = "j";
	
	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the Library.
	 * 
	 * @param parent the parent PApplet
	 */
	public ImageExport(PApplet parent) {
		this.parent = parent;
		showWelcomeMessage();
		registerForEvents();
	}
	
	/**
	 * Helper method to print welcome message
	 */
	private void showWelcomeMessage() {
		System.out.println("##library.name## ##library.prettyVersion## is activated");
	}
	
	/**
	 * Helper method to register events from parents
	 */
	private void registerForEvents() {
		parent.registerMethod("pre", this);
		parent.registerMethod("post", this);
		parent.registerMethod("keyEvent", this);
	}
	
	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}
	
	/**
	 * Start the capturing before the draw() call
	 */
	public void pre() {
	}

	/**
	 * Complete the capturing after the draw() call
	 */
	public void post() {
	}
	
	/**
	 * Event handler for key events
	 */	
	public void keyEvent(KeyEvent e) {
		if (e.getAction() == KeyEvent.PRESS) {
			String lowercaseKey = Character.toString(e.getKey()).toLowerCase();
			
			if (lowercaseKey.equals(JPG_KEY)) {
			    System.out.println("[" + JPG_KEY + "] is typed");
			    exportJpg();
			}
		}		
	}
	
	/**
	 * Export a jpg file
	 */
	private void exportJpg() {
	    String jpgFilename = getFileNameForExport("jpg");
	    System.out.println("  --> Saving " + jpgFilename);
	    parent.save(jpgFilename);
	    System.out.println("  --> Done saving the jpg!");
	}

	/**
	 * return the filename based on the current date and time
	 * 
	 * @return String
	 */
	private String getFileNameForExport(String extension) {
		return String.format(
			"exported/artwork_%02d%02d-%02d%02d%02d.%s",
			PApplet.month(),
			PApplet.day(),
			PApplet.hour(),
			PApplet.minute(),
			PApplet.second(),
			extension
		);
	}
}
