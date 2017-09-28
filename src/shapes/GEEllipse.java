package shapes;

import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class GEEllipse {
	private Point startP;
	private Ellipse2D ellipse;
	
	public GEEllipse() {
		ellipse = new Ellipse2D.Double();
	}
	
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	
	public void setCoordinate(Point currentP) {
		ellipse.setFrame(startP.x, startP.y, 
				currentP.x - startP.x, currentP.y - startP.y);
	}
	
	public Ellipse2D getEllipse() {
		return ellipse;
	}
}
