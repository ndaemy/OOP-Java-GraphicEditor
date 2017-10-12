package shapes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

public abstract class GEShape {
	protected Shape myShape;
	protected Point startP;
	
	public GEShape(Shape shape) {
		this.myShape = shape;
	}
	
	public void draw(Graphics2D g2D) {
		g2D.draw(myShape);
	}
	
	public abstract void initDraw(Point startP);
	public abstract void setCoordinate(Point currentP);
	public abstract GEShape clone();
}
