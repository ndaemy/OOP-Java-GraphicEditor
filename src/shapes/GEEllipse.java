package shapes;

import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class GEEllipse extends GEShape {
	// private Point startP;
	// private Ellipse2D ellipse;
	
	public GEEllipse() {
		super(new Ellipse2D.Double());
	}
	
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	
	public void setCoordinate(Point currentP) {
		Ellipse2D ellipse = (Ellipse2D)myShape;
		ellipse.setFrame(startP.x, startP.y, 
				currentP.x - startP.x, currentP.y - startP.y);
	}
}
