package de.schasse.pathfinder;

/**
 * The class Cell represents a cell in a matrix and stores some data which is 
 * necessary to calculate the shortest path in a matrix.
 * @author sebastian
 */
public class Cell implements Comparable<Cell>{
	/**
	 * The line of the cell in the matrix.
	 */
	final int line;
	/**
	 * The column of the cell in the matrix.
	 */
	final int column;
	/**
	 * The distance to the start cell.
	 */
	int distance;
	/**
	 * The predecessor of the cell in the path to the start cell.
	 */
	Cell pred;
	
	/**
	 * The Constructor
	 * @param line
	 * @param column
	 */
	public Cell(int line, int column) {
		this.line = line;
		this.column = column;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return distance+":("+line+","+column+")";
	}


	/** 
	 * Compares the distances.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Cell c) {
		return distance - c.distance;
	}
}
