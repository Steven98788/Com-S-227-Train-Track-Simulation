package hw4;

import api.Point;
import api.PositionVector;

/**
 * 
 * @author Steven Bui
 *
 */

public class SwitchLink extends AbstractLink {

	//instance variables
	private Point pointA;
	private Point pointB;
	private Point pointC;

	private boolean trainCrossing;
	private boolean turning;

	
	/**
	 * points match paths below
	 * @param endpointA
	 * @param endpointB
	 * @param endpointC
	 */
	public SwitchLink(Point endpointA, Point endpointB, Point endpointC) {
	
		pointA = endpointA;
		pointB = endpointB;
		pointC = endpointC;
		turning = false;
		trainCrossing = false;

	}
	
	/**
	 * changes turning based on parameter and traincrossing
	 * @param turn
	 */
	public void setTurn(boolean turn) {
		if (trainCrossing == false) {
			if (turn == true) {
				turning = turn;
			} else {
				turning = false;
			}
		}
	}
	
	public Point getConnectedPoint(Point point) {
		if (point.equals(pointA)) {
			if(turning) {
				return pointC;
			}
			else {
				return pointB;
			}
		}
		else if (point.equals(pointB) || point.equals(pointC)) {
			return pointA;
		}
		return null;
		
	}

	/**
	 * shifts location to next pair of points
	 * @param turn
	 */
	public void shiftPoints(PositionVector positionVector) {
		if (positionVector.getPointA().getPath() == pointB.getPath()) {
			positionVector.setPointA(pointA);
			positionVector.setPointB(pointA.getPath().getPointByIndex(1));
		} else if (positionVector.getPointA().getPath() == pointC.getPath()) {
			positionVector.setPointA(pointA);
			positionVector.setPointB(pointA.getPath().getPointByIndex(1));
		} else if (turning) {
			positionVector.setPointA(pointB);
			positionVector.setPointB(pointB.getPath().getPointByIndex(1));
		} else if (!turning) {
			positionVector.setPointA(pointB);
			positionVector.setPointB(pointB.getPath().getPointByIndex(1));
		}

	}

}
