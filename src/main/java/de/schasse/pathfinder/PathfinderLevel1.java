package de.schasse.pathfinder;

import java.util.PriorityQueue;

/**
 * This class finds the best path from the top left to the bottom right in a 
 * given matrix. The path can only turn right or down.
 * @author sebastian
 */
public class PathfinderLevel1 extends AbstractPathfinderTopLeft2BottomRight {

	/**
	 * The constructor.
	 * @param m matrix in which the shortest path is to be found 
	 */
	public PathfinderLevel1 (Matrix m) {
		super(m);
	}
	
	/** 
	 * Checks and updates the left and the lower neighbor.
	 * @see pathfinder.AbstractPathfinderLeft2Right#checkNeighbors(int, java.util.PriorityQueue, pathfinder.Cell)
	 */
	@Override
	protected void checkNeighbors(int sL, PriorityQueue<Cell> heap, Cell cell) {
		//right neighbor
		if (cell.column != m.getColumnsLength()-1) {
			checkNeighbor(cell, 
					cells[cell.line][cell.column+1][sL], heap);
		}
		
		//lower neighbor
		if (cell.line != m.getLinesLength()-1) {
			checkNeighbor(cell, 
					cells[cell.line+1][cell.column][sL], heap);
		}
	}

}
