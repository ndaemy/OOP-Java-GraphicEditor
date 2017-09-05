package frames;

import javax.swing.JFrame;

import constants.GEConstants;

public class GEMainFrame extends JFrame{

	private static GEMainFrame uniqueMainFrame = 
			new GEMainFrame(GEConstants.TITLE_MAINFRAME);
	private GEDrawingPanel drawingPanel;

	private GEMainFrame(String titleMainframe) {
		super(titleMainframe);
		drawingPanel = new GEDrawingPanel();
		this.add(drawingPanel);
	}
	
	public static GEMainFrame getInstance() {
		return uniqueMainFrame;
	}
	public void init(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(GEConstants.WDITH_MAINFRAME, GEConstants.HEIGHT_MAINFRAME);
		this.setVisible(true);
		
	}
	
}
