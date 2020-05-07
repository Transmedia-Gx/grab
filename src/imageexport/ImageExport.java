package imageexport;

import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 */

public class ImageExport {
	
	// myParent is a reference to the parent sketch
	PApplet parent;
	
	public final static String VERSION = "##library.prettyVersion##";
	

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
		System.out.println("pre()");
	}

	/**
	 * Complete the capturing after the draw() call
	 */
	public void post() {
		System.out.println("post()");
	}
}

