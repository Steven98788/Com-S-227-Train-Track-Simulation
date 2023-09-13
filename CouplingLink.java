package hw4;

import api.Point;

import api.PositionVector;

/**
 * 
 * @author Steven Bui
 *
 */

public class CouplingLink extends AbstractLink {

	//instance variables
	private Point endPoint1;
	private Point endPoint2;

	/**
	 * 
	 * @param endpoint1
	 * @param endpoint2
	 */
	public CouplingLink(Point endpoint1, Point endpoint2) {
		

		endPoint1 = endpoint1;
		endPoint2 = endpoint2;
	}

	/**
	 *  Shifts location of the given positionVector to be between the next pair of points
	 */
	public void shiftPoints(PositionVector positionVector) {
		positionVector.setPointA(endPoint2);
		positionVector.setPointB(endPoint2.getPath().getPointByIndex(1));
	}

	/**
	 * Gets the poin that is connected to the given point by the link. Returns nill if no point is connected to the given point.
	 * @param point
	 * @return the connected point or null
	 */
	public Point getConnectedPoint(Point point) {
		if (point == endPoint1) {
			return endPoint2;
		} else if (point == endPoint2) {
			return endPoint1;
		}
		return null;
	}
}