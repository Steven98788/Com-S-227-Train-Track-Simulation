package hw4;


import api.PointPair;
import api.PositionVector;
import api.Point;

/**
 * 
 * @author Steven Bui
 *
 */

public class MultiSwitchLink extends AbstractLink  {
	
	//instance variables
	private boolean trainCrossing;
	
	private PointPair[] connection;
	
	
/**
 * Creates a new MultiSwitchLink
 * @param connection
 */
	public MultiSwitchLink(PointPair[] connection) {
		
		this.connection = connection;
		trainCrossing = false;
		
		
	}
	
	
	
	/**
	 * @param pointPair
	 * @param index
	 */
	public void switchConnection(PointPair pointPair, int index) {
		if (trainCrossing == false) {
			connection[index] = pointPair;
		}
	}
	
	/**
	 * changes train crossing to true when called
	 */
	public void trainEnteredCrossing()	{
		trainCrossing = true;
	}
	/**
	 * changes train crossing to false when called
	 */
	public void trainExitedCrossing() {
		trainCrossing = false;
	}
	
	/**
	 * Shift location to next pair of points
	 */
	public void shiftPoints(PositionVector i) {
		i.setPointA(getConnectedPoint(i.getPointB()));
		i.setPointB(getConnectedPoint(i.getPointB()).getPath().getPointByIndex(1));
	}
	
	@Override
	/**
	 * gets the point that is conencted 
	 * @return null if no point is connected
	 */
	public Point getConnectedPoint(Point i) {
		for (PointPair a : connection) {
			if (i == a.getPointA()) {
				return a.getPointB();
			} else if (i == a.getPointB()) {
				return a.getPointA();
			}
		}
		return null;
	}
	
	
	
}
