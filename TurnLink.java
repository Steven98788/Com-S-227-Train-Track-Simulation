package hw4;

import api.Point;
import api.PositionVector;

/**
 * 
 * @author Steven Bui
 *
 */


public class TurnLink extends AbstractLink {
	
	//instance variables
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private boolean turning;
	

	/**
	 * Creates new object
	 * @param endpointA
	 * @param endpointB
	 * @param endpointC
	 */
	public TurnLink(Point endpointA, Point endpointB, Point endpointC) {
		
		pointA = endpointA;
		pointB = endpointB;
		pointC = endpointC;
		turning = false;
		
	}
	
	/**
	 * changes link to turn based on turning and parameter
	 * @param turn
	 */
	protected void setTurn (boolean turn) {
		turning = turn; 
	}

	/**
	 * shifts loaction to next pair of points
	 * @param positionVector
	 */
	public void shiftPoints(PositionVector positionVector) {
		if (positionVector.getPointA().getPath() == pointA.getPath()) {
			positionVector.setPointA(pointB);
			positionVector.setPointB(pointB.getPath().getPointByIndex(1));
		} else if(positionVector.getPointA().getPath() == pointB.getPath()) {
			positionVector.setPointA(pointA);
			positionVector.setPointB(pointA.getPath().getPointByIndex(1));
		} else if(positionVector.getPointA().getPath() == pointC.getPath()) {
			positionVector.setPointA(pointA);
			positionVector.setPointB(pointA.getPath().getPointByIndex(1));
		}	
		
	}
	
	/**
	 * Gets the point that is connected to the given point.
	 * 
	 * @param point
	 * @return returns null if no connected point
	 */
	public Point getConnectedPoint(Point point) {
		if (point == pointA) {
			return pointC;
		} else if (point == pointB) {
			return pointA;
		} else if(point == pointC) {
			return pointA;
		}
		return null;
	}
	
		
	

}