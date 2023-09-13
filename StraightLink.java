package hw4;

import api.Point;
import api.PositionVector;

/**
 * 
 * @author Steven Bui
 *
 */

public class StraightLink extends AbstractLink {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	

	/**
	 * 
	 * @param endpointA
	 * @param endpointB
	 * @param endpointC
	 */
	public StraightLink(Point endpointA, Point endpointB, Point endpointC) {
		
		pointA = endpointA;
		pointB = endpointB;
		pointC = endpointC;

	}

	/**
	 * Gets the point connected to the other point. Returns null is no point is connected.
	 */
	public Point getConnectedPoint(Point point) {
		if (point == pointA) {
			return pointB;
		} else if (point == pointB) {
			return pointA;
		} else if (point == pointC) {
			return pointC;
		} else {
			return null;
		}
	}


	public int getNumPaths() {
		return 3;
	}

	/**
	 * 
	 */
	public void shiftPoints(PositionVector positionVector) {
		if (positionVector.getPointA().getPath() == pointA.getPath()) {
			positionVector.setPointA(pointB);
			positionVector.setPointB(pointB.getPath().getPointByIndex(1));
		} else if (positionVector.getPointA().getPath() == pointB.getPath()) {
			positionVector.setPointA(pointA);
			positionVector.setPointB(pointA.getPath().getPointByIndex(1));
		} else if (positionVector.getPointA().getPath() == pointC.getPath()) {
			positionVector.setPointA(pointA);
			positionVector.setPointB(pointA.getPath().getPointByIndex(1));
		}

	}

}
