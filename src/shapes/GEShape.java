package shapes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import constants.GEConstants.EAnchorTypes;
import utils.GEAnchorList;

public abstract class GEShape {
	protected Shape myShape;
	protected Point startP;
	protected boolean selected;
	protected GEAnchorList anchorList;
	protected EAnchorTypes selectedAnchor;
	
	public GEShape(Shape shape) {
		this.myShape = shape;
		anchorList = null;
		selected = false;
	}
	
	public void draw(Graphics2D g2D) {
		g2D.draw(myShape);
		if (selected == true) {
			anchorList.draw(g2D);
		}
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
		if (selected == true) {
			anchorList = new GEAnchorList();
			anchorList.setPosition(myShape.getBounds());
		} else {
			anchorList = null;
		}
	}
	
	public boolean onShape(Point p) {
		if (anchorList != null) {
			selectedAnchor = anchorList.onAnchors(p);
			if (selectedAnchor != EAnchorTypes.NONE) {
				return true;
			}
		}
		return myShape.intersects(new Rectangle(p.x, p.y, 4, 4));
	}
	
	public abstract void initDraw(Point startP);
	public abstract void setCoordinate(Point currentP);
	public abstract GEShape clone();
}
