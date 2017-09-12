package frames;

import javax.swing.JFrame;
import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame{

	private static GEMainFrame uniqueMainFrame = 
			new GEMainFrame(GEConstants.TITLE_MAINFRAME);
	private GEDrawingPanel drawingPanel;
	private GEMenuBar menuBar;

	private GEMainFrame(String title) {
		super(title);
		
		drawingPanel = new GEDrawingPanel();
		this.add(drawingPanel);
		
		menuBar = new GEMenuBar();
		setJMenuBar(menuBar);
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
