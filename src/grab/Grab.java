package grab;

import processing.core.*;
import processing.event.KeyEvent;


/**
 * An easy-to-use pdf/jpeg exporter
 */
public class Grab implements PConstants {
	
	// myParent is a reference to the parent sketch
	PApplet parent;
	
	// Trigger mode
	Mode mode;
	
	// Version of the library
	public final static String VERSION = "##library.prettyVersion##";
	
	// default key for jpg export
	private final static String JPG_KEY = "j";

	// default key for pdf export
	private final static String PDF_KEY = "p";

	// Keep track of PDF export status
	private enum PDFExportStatus {
	    NONE,
	    WILL_EXPORT,
	    EXPORTING,
	}
	PDFExportStatus pdfExportStatus = PDFExportStatus.NONE;
	
	/**
	 * Default constructor with Keyboard mode
	 * 
	 * @param parent the parent PApplet
	 */
	public Grab(PApplet parent) {
		this(parent, Mode.KEYBOARD);
	}

	/**
	 * Custom constructor which accepts mode
	 * 
	 * @param parent the parent PApplet
	 * @param mode what triggers the capture (keyboard, mouse, custom)
	 */
	public Grab(PApplet parent, Mode mode) {
		this.parent = parent;
		this.mode = mode;
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
		parent.registerMethod("draw", this);
		parent.registerMethod("keyEvent", this);
	}
	
	/**
	 * Start the capturing before the draw() call
	 */
	public void pre() {
		if (pdfExportStatus == PDFExportStatus.WILL_EXPORT) {
			pdfExportStatus = PDFExportStatus.EXPORTING;
			startExportingPDF();
		}
	}

	/**
	 * Complete the capturing after the draw() call
	 */
	public void draw() {
		if (pdfExportStatus == PDFExportStatus.EXPORTING) {
			finishExportingPDF();
			pdfExportStatus = PDFExportStatus.NONE;
		}
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
			} else if (lowercaseKey.equals(PDF_KEY)) {
			    System.out.println("[" + PDF_KEY + "] is typed");
			    if (pdfExportStatus == PDFExportStatus.NONE) {
			    	pdfExportStatus = PDFExportStatus.WILL_EXPORT;
			    }
			}
		}		
	}

	/**
	 * Start exporting a PDF file
	 */
	void startExportingPDF() {
	    String filename = getFileNameForExport("pdf");
	    parent.beginRecord(PDF, filename);
	    System.out.println("  --> Saving " + filename);
	    parent.scale(1.0f / parent.displayDensity());
	}

	/**
	 * Finish exporting a PDF file
	 */
	void finishExportingPDF() {
		parent.endRecord();
	    System.out.println("  --> Done saving the PDF!");
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
