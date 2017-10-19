package frames;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import constants.GEConstants.EState;
import constants.GEConstants.EToolBarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GEPolygon;
import shapes.GERectangle;
import shapes.GEShape;

public class GEDrawingPanel extends JPanel{
	private GEShape currentShape;
	private ArrayList<GEShape> shapeList;
	private EState currentState;
	private MouseDrawingHandler drawingHandler;
	
	public GEDrawingPanel(){
		super();
		shapeList = new ArrayList<GEShape>();
		currentState = EState.Idle;
		drawingHandler = new MouseDrawingHandler();
		this.addMouseListener(drawingHandler);
		this.addMouseMotionListener(drawingHandler);
		this.setForeground(GEConstants.FOREGROUND_COLOR);
		this.setBackground(GEConstants.BACKGROUND_COLOR);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		for (GEShape shape: shapeList) {
			shape.draw(g2D);
		}
	}
	
	public void setCurrentShape(GEShape currentShape) {
		this.currentShape = currentShape;
	}

	private void initDraw(Point startP) {
		currentShape = currentShape.clone();
		currentShape.initDraw(startP);
	}
	
	public void continueDrawing(Point currentP) {
		((GEPolygon)currentShape).continueDrawing(currentP);
	}
	
	public void animateDraw(Point currentP) {
		Graphics2D g2D = (Graphics2D)getGraphics();
		g2D.setXORMode(g2D.getBackground());
		
		currentShape.draw(g2D);
		currentShape.setCoordinate(currentP);
		currentShape.draw(g2D);
	}

	private void finishDraw() {
		shapeList.add(currentShape);
	}
	
	private class MouseDrawingHandler extends MouseInputAdapter {
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if (currentState == EState.TwoPointsDrawing) {
				animateDraw(e.getPoint());
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if (currentState == EState.Idle) {
				initDraw(e.getPoint());
				if (currentShape instanceof GEPolygon) {
					currentState = EState.NPointDrawing;
				} else {
					currentState = EState.TwoPointsDrawing;
				}
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if (currentState == EState.TwoPointsDrawing) {
				finishDraw();
				currentState = EState.Idle;
				repaint();
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (currentState == EState.NPointDrawing) {
					if (e.getClickCount() == 1) {
						continueDrawing(e.getPoint());
					} else if (e.getClickCount() == 2) {
						finishDraw();
						currentState = EState.Idle;
						repaint();
					}
				}
			}
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			if (currentState == EState.NPointDrawing) {
				animateDraw(e.getPoint());
			}
		}
		
	}
}