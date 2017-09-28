package frames;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GERectangle;

public class GEDrawingPanel extends JPanel{
	private GERectangle rectangle;
	private GEEllipse ellipse;
	private GELine line;
	
	private EToolBarButtons selectShape;
	
	private MouseDrawingHandler drawingHandler;
	
	public GEDrawingPanel(){
		super();
		
		drawingHandler = new MouseDrawingHandler();
		this.addMouseListener(drawingHandler);
		this.addMouseMotionListener(drawingHandler);
		this.setForeground(GEConstants.FOREGROUND_COLOR);
		this.setBackground(GEConstants.BACKGROUND_COLOR);
	}
	
	public void setSelectShape(EToolBarButtons selectShape) {
		this.selectShape = selectShape;
	}

	private void initDraw(Point startP) {
		if(selectShape == EToolBarButtons.Rectangle) {
			rectangle = new GERectangle();
			rectangle.initDraw(startP);
		} else if(selectShape == EToolBarButtons.Ellipse) {
			ellipse = new GEEllipse();
			ellipse.initDraw(startP);
		} else if(selectShape == EToolBarButtons.Line) {
			line = new GELine();
			line.initDraw(startP);
		}
	}
	
	public void animateDraw(Point currentP) {
		Graphics2D g2D = (Graphics2D)getGraphics();
		g2D.setXORMode(g2D.getBackground());
		
		if(selectShape == EToolBarButtons.Rectangle) {
			g2D.draw(rectangle.getRectangle());
			rectangle.setCoordinate(currentP);
			g2D.draw(rectangle.getRectangle());
		} else if(selectShape == EToolBarButtons.Ellipse) {
			g2D.draw(ellipse.getEllipse());
			ellipse.setCoordinate(currentP);
			g2D.draw(ellipse.getEllipse());
		} else if(selectShape == EToolBarButtons.Line) {
			g2D.draw(line.getLine());
			line.setCoordinate(currentP);
			g2D.draw(line.getLine());
		}
	}

	private class MouseDrawingHandler extends MouseInputAdapter {
		
		@Override
		public void mouseDragged(MouseEvent e) {
			animateDraw(e.getPoint());
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			initDraw(e.getPoint());
		}
		
	}
}