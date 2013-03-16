package de.schasse.pathfinder;

/**
 * Solves the problem of the shortest path, level1, level2 and level3. For a
 * 100*100 matrix.
 * @author sebastian
 */
public class Main {
	public static void main(String[] args) {
		Matrix m = new Matrix(150, 150);
		m.randomFillMatrix(1000);
		System.out.println(m);
		
		PathfinderLevel1 pf1 = new PathfinderLevel1(m);
		pf1.findPath();
		System.out.println("Distance and last cell of shortest path Level 1:\n"
				+ pf1.getBestPath());
		
		PathfinderLevel2 pf2 = new PathfinderLevel2(m);
		pf2.findPath();
		System.out.println("Distance and last cell of shortest path Level 2:\n"
				+ pf2.getBestPath());
		
		PathfinderLevel3 pf3 = new PathfinderLevel3(m);
		pf3.findPath();
		System.out.println("Distance and last cell of shortest path Level 3:\n"
				+ pf3.getBestPath());
	}
}
