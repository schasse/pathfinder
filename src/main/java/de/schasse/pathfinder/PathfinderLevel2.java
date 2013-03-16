package de.schasse.pathfinder;

import java.util.PriorityQueue;

/**
 * This class calculates the best path from the very left column to the very right 
 * column in a given matrix. The path can turn up, right or down.
 * @author sebastian
 */
public class PathfinderLevel2 extends AbstractPathfinderLeft2Right{

	/**
	 * The constructor.
	 * @param m matrix in which the shortest path is to be found 
	 */
	public PathfinderLevel2 (Matrix m) {
		super(m, m.getLinesLength());
	}
	
	/** 
	 * Checks and updates the upper, right and lower neighbor.
	 * @see pathfinder.AbstractPathfinderLeft2Right#checkNeighbors(int, java.util.PriorityQueue, pathfinder.Cell)
	 */
	@Override
	protected void checkNeighbors(int sL, PriorityQueue<Cell> heap, Cell cell) {
		//upper neighbor
		if (cell.line != 0) {
			checkNeighbor(cell, 
					cells[cell.line-1][cell.column][sL], heap);
		}
		
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
