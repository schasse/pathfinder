package de.schasse.pathfinder;


/**
 * The abstract class PathfinderTopLeft2Bottomright calculates the shortest path 
 * from the top left to the bottom right of a matrix. The Method 
 * "checkNeighbors" needs to be implemented.
 * @author sebastian
 */
public abstract class AbstractPathfinderTopLeft2BottomRight 
	extends AbstractPathfinderLeft2Right {

	/**
	 * The constructor.
	 * @param m matrix in which the shortest path is to be found 
	 */
	public AbstractPathfinderTopLeft2BottomRight (Matrix m) {
		super(m, 1);
	}
	
	/* (non-Javadoc)
	 * @see arraypathfinder.PathfinderLeft2Right#findPath()
	 */
	@Override
	public void findPath() {
		super.findPathHelp(0);
		super.bestPath = cells[m.getLinesLength()-1][m.getColumnsLength()-1][0];
	}
}
