package de.schasse.pathfinder;

import java.util.PriorityQueue;

public class PathfinderLevel3 extends AbstractPathfinderTopLeft2BottomRight {

	/**
	 * The constructor.
	 * @param m matrix in which the shortest path is to be found 
	 */
	public PathfinderLevel3(Matrix m) {
		super(m);
	}
	
	/**
	 * Checks and updates the upper, right, lower and left neighbor.
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
		
		//left neighbor
		if (cell.column != 0) {
			checkNeighbor(cell,
					cells[cell.line][cell.column-1][sL], heap);
		}
	}

}
