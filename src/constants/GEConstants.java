package constants;

import java.awt.Color;

public class GEConstants {

	// GEMainFrame
	public static final int WDITH_MAINFRAME = 400;
	public static final int HEIGHT_MAINFRAME = 600;
	public static final String TITLE_MAINFRAME = "GE08";
	// GEMenu
	public static final String TITLE_FILENAME = "파일";
	public static final String TITLE_EDITMENU = "편집";
	public static final String TITLE_COLORMENU = "컬러";
	// GEMenuItems
	public static enum EFileMenuItems {새로만들기, 열기, 저장, 다른이름으로저장, 종료}
	public static enum EEditMenuItems {Undo, Redo, 삭제, 잘라내기, 복사, 붙이기, Group, UnGroup}
	public static enum EColorMenuItems {SetLineColor, ClearLineColor, SetFillColor, ClearFillColor}
	// GEToolBar
	public static final String TITLE_TOOLBAR = "Shape Tools";
	public static enum EToolBarButtons {
		Select, Rectangle, Line, Ellipse, Polygon}
	public static final String IMG_URL = "images/";
	public static final String TOOLBAR_BTN = ".gif";
	public static final String TOOLBAR_BTN_SLT = "SLT.gif";
	// GEDrawingPanel
	public static final Color FOREGROUND_COLOR = Color.BLACK;
	public static final Color BACKGROUND_COLOR = Color.WHITE;
	public static enum EState {Idle, TwoPointsDrawing, NPointDrawing}
}
