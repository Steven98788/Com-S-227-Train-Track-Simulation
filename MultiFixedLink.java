package hw4;

import api.Point;
import api.PointPair;
import api.PositionVector;

/**
 * 
 * @author Steven Bui
 *
 */

public class MultiFixedLink extends AbstractLink {

	private PointPair[] connection;

	/**
	 * Super class for Multi Switch
	 * 
	 * @param connection
	 */
	public MultiFixedLink(PointPair[] connection) {
		
	}
	
	

	@Override
	/**
	 * shift the location of the given position vector to be between the next pair
	 * of points
	 */
	public void shiftPoints(PositionVector i) {
		i.setPointA(getConnectedPoint(i.getPointB()));
		i.setPointB(getConnectedPoint(i.getPointB()).getPath().getPointByIndex(1));
	}

	@Override
	/**
	 * @param point
	 * @return connected point or null
	 */
	
	
	/*
	 * public Point getConnectedPoint(Point point) { for (PointPair p :
	 * connection.length) { if (point == p.getPointA()) { return p.getPointB(); }
	 * else if (point == p.getPointB()) { return p.getPointA(); } } return null; }
	 */

	public Point getConnectedPoint(Point point) {
		Point otherPoint = null;
		for (int i = 0; i < connection.length; i++) {
			PointPair connect = connection[i];
			if (point.equals(connect.getPointA())) {
				otherPoint = connect.getPointB();
			} else if (point.equals(connect.getPointB())) {
				otherPoint = connect.getPointA();
			}
		}
		return otherPoint;
	}
}
