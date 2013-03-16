package de.schasse.pathfinder;
import java.util.Random;


/**
 * The class Matrix represents a n*m matrix.
 * @author sebastian
 */
public class Matrix{
	
	/**
	 * The matrix itself. Outer array for the lines, 
	 * inner array for the columns.
	 * E.g. matrix[5][2] gives the second element in
	 * the fifth line.
	 */
	private int[][] matrix;
	
	/**
	 * Maximum random number in the Matrix.
	 */
	private int randomBound;
	
	/**
	 * The Constructor.
	 * @param n number of lines
	 * @param m number of columns
	 */
	public Matrix (int n, int m) {
		matrix = new int[n][m];
	}
	
	/**
	 * Fills the matrix with pseudo-random numbers.
	 */
	public void randomFillMatrix (int randomBound) {
		this.randomBound = randomBound;
		Random r = new Random(533);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = r.nextInt(randomBound);
			}
		}
	}
	
	/**
	 * Gets the number of lines in the matrix.
	 * @return number of lines
	 */
	public int getLinesLength() {
		return matrix.length;
	}
	
	/**
	 * Gets the number of columns in the matrix.
	 * @return length of columns
	 */
	public int getColumnsLength() {
		return matrix[0].length;
	}
	
	/**
	 * Gets the value of the given position.
	 * @param line
	 * @param column
	 * @return value
	 */
	public int getValue(int line, int column) {
		return matrix[line][column];
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String retString = "{\n";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				retString+=Util.intToString(matrix[i][j], randomBound)+" ";
			}
			retString+="\n";
		}
		return retString+"}";
	}
}
