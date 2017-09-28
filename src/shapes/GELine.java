package shapes;

import java.awt.Point;
import java.awt.geom.Line2D;

public class GELine {
	private Point startP;
	private Line2D line;
	
	public GELine() {
		line = new Line2D.Double();
	}
	
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	
	public void setCoordinate(Point currentP) {
		line.setLine(startP.x, startP.y, currentP.x, currentP.y);
	}
	
	public Line2D getLine() {
		return line;
	}
}