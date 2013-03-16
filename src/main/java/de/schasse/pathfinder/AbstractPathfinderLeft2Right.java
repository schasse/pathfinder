package de.schasse.pathfinder;

import java.util.PriorityQueue;

/**
 * The abstract class PathfinderLeft2Right calculates the shortest path from
 * the very left column to the very right column for a matrix. The Method 
 * "checkNeighbors" needs to be implemented.
 * @author sebastian
 */
public abstract class AbstractPathfinderLeft2Right {
	/**
	 * The matrix in which the shortest path is to be found.
	 */
	protected Matrix m;
	/**
	 * The 3d array of cells in which the distances etc. are saved. First entry
	 * for the line, second for the column and third entry for the starting line
	 * of the path.
	 */
	protected Cell[][][] cells;
	/**
	 * After the best path is calculated, the attribute bestPath points to the
	 * last cell in the best path. In each cell is a reference to the predator 
	 * stored.
	 */
	protected Cell bestPath;
	
	/**
	 * The constructor.
	 * @param m matrix in which the shortest path is to be found 
	 * @param startLines number of start lines, mostly the same as number of 
	 * lines as in the matrix.
	 */
	public AbstractPathfinderLeft2Right(Matrix m, int startLines) {
		this.m = m;
		this.cells = new Cell[m.getLinesLength()][m.getColumnsLength()][startLines];
		for (int l = 0; l < cells.length; l++) {
			for (int c = 0; c < cells[l].length; c++) {
				for (int n = 0; n < cells[l][c].length; n++) {
					cells[l][c][n] = new Cell(l, c);
				}
			}
		}
	}
	
	/**
	 * Calculates the shortest Path. Path is stored in bestPath.
	 */
	public void findPath() {
		
		for (int sL = 0; sL < m.getLinesLength(); sL++) {
			findPathHelp(sL);
		}
		
		PriorityQueue<Cell> allPaths = new PriorityQueue<Cell>();
		for (int l = 0; l < cells.length; l++) {
			int lastColumn = cells[l].length-1;
			for (int sL = 0; sL < cells[l][lastColumn].length; sL++) {
				allPaths.add(cells[l][lastColumn][sL]);
			}
		}
		
		/* test for 5*5matrix */
		
//		for (int l = 0; l < 5; l++) {
//			for (int sL = 0; sL < 5; sL++) {
//				allPaths.add(cells[l][4][sL]);
//			}
//		}
		bestPath = allPaths.peek();
	}
	
	/**
	 * Calculates the best path for a single given start line.
	 * @param sL start line
	 */
	protected void findPathHelp(int sL) {
		
		for (int l = 0; l < cells.length; l++) {
			for (int c = 0; c < cells[l].length; c++) {
				cells[l][c][sL].pred = null;
				cells[l][c][sL].distance = Integer.MAX_VALUE;
			}
		}
		
		cells[sL][0][sL].distance = m.getValue(sL, 0);
		
		PriorityQueue<Cell> heap = new PriorityQueue<Cell>();
		heap.add(cells[sL][0][sL]);
		
		Cell curCell;
		while (!heap.isEmpty()) {
			curCell = heap.poll();
			checkNeighbors(sL, heap, curCell);
		}
	}

	/**
	 * Checks and updates the distances of all the neighbors of the given cell.
	 * Here can decide inheriting classes which neighbors are supposed to be 
	 * checked. Please use the method checkNeighbor for checking a single 
	 * neighbor.
	 * @param sL start line
	 * @param heap heap for registered cells
	 * @param cell cell
	 */
	abstract protected void checkNeighbors(int sL, PriorityQueue<Cell> heap, Cell cell); 
	
	/**
	 * Checks and updates the distances of a single given neighbor of a given 
	 * cell.
	 * @param cell cell
	 * @param neighbor neighbor to check
	 * @param heap heap for registered cells
	 */
	protected void checkNeighbor(Cell cell, Cell neighbor, PriorityQueue<Cell> heap) {
		int newDistance = cell.distance
				+ m.getValue(neighbor.line, neighbor.column);
		if (newDistance < neighbor.distance) {
			neighbor.pred = cell;
			neighbor.distance = newDistance;
			heap.add(neighbor);
		}
	}
	
	/**
	 * Get the distance to the start line for a given cell.
	 * @param line cell.line
	 * @param column cell.column
	 * @param startLine start line
	 * @return distance
	 */
	public int getDistance(int line, int column, int startLine) {
		return cells[column][line][startLine].distance;
	}
	
	/**
	 * Gets the last cell of the best path.
	 * @return last cell of best path
	 */
	public Cell getBestPath() {
		return bestPath;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (bestPath != null) {
			String retString = "{\n";
			Cell curCell = bestPath;
			while(curCell != null) {
				retString+=curCell+"\n";
				curCell = curCell.pred;
			}
			return retString+"}";
		} else {
			return "Best path not yet calculated!";
		}
	}
}
