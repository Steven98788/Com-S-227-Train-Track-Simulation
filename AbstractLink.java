package hw4;
import api.Point;
import api.PositionVector;
import api.Crossable;

/**
 * 
 * @author sbui14
 *
 */

public abstract class AbstractLink implements Crossable {

	
	private int numPaths;

	/**
	 * Constructs a new object for Abstract Link
	 * @param i
	 */


	@Override
	/**
	 * called when the location of the given position vector to be between the next pair of points
	 */

	public void shiftPoints(PositionVector positionVector) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * returns null 
	 */
	public Point getConnectedPoint(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Called when the train has entered Crossing
	 */
	public void trainEnteredCrossing() {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Called when the train has exited Crossing
	 */
	public void trainExitedCrossing() {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * returns number of paths
	 */
	public int getNumPaths() {
		// TODO Auto-generated method stub
		return numPaths;
	}

}
