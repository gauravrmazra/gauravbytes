package dev.codefoundry.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://codefoundry.dev}
 *
 *         You are given a two-dimensional integer matrix containing 0s, 1s, 2s,
 *         and 3s where 0 represents an empty cell 1 represents a wall 2
 *         represents a house 3 represents a bus stop
 * 
 *         Return the shortest distance from any house to any bus stop. You can
 *         move up, down, left, and right but you can't move through a house or
 *         a wall cell. If there's no solution, return -1.
 *
 */
public class NearestBusStop {
	private final int[] UP = new int[] { -1, 0 };
    private final int[] DOWN = new int[] { 1, 0 };
    private final int[] LEFT = new int[] { 0, -1 };
    private final int[] RIGHT = new int[] { 0, 1 };
    
    class Pair {
    	int row;
    	int col;
    	int depth;
    	Pair(int row, int col, int depth) {
    		this.row = row;
    		this.col = col;
    		this.depth = depth;
    	}
    	
    	@Override
		public int hashCode() {
    		return this.row + this.col;
		}
    	
    	@Override
		public boolean equals(Object obj) {
			if (obj == null || !Pair.class.isInstance(obj)) return false;
			
			Pair that = Pair.class.cast(obj);
			return this.row == that.row && this.col == that.col;
		}
    	
    	@Override
		public String toString() {
			return "[ Row: " + this.row + ", Col: " + this.col + ", Depth: " + this.depth + " ]";
		}
    }

	public int solve(int[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int route = Integer.MAX_VALUE;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (isHouse(matrix, row, col)) {
					route = Math.min(route, searchRouteToBusStop(matrix, row, col));
				}
			}
		}

		return route == Integer.MAX_VALUE ? -1 : route;
	}

	private int searchRouteToBusStop(int[][] matrix, int row, int col) {
		Set<Pair> seen = new HashSet<Pair>();
		Queue<Pair> pairs = new LinkedList<>();
		pairs.offer(new Pair(row, col, 0));
		seen.add(new Pair(row, col, 0));
		
		Pair p;
		Pair next;
		while(!pairs.isEmpty()) {
			p = pairs.poll();
			
			if (isValid(matrix, p.row,p.col)) {
				if (isWall(matrix, p.row, p.col) 
						|| (isHouse(matrix, p.row, p.col) && p.depth != 0)) continue;
				
				if (isBusStop(matrix, p.row, p.col)) {
					return p.depth;
				}
				
				next = new Pair(p.row + UP[0], p.col + UP[1], p.depth + 1);
				if (isValid(matrix, next.row, next.col) && !seen.contains(next)) {
					pairs.offer(next);
					seen.add(next);
				}
				
				next = new Pair(p.row + DOWN[0], p.col + DOWN[1], p.depth + 1);
				if (isValid(matrix, next.row, next.col) && !seen.contains(next)) {
					pairs.offer(next);
					seen.add(next);
				}
				
				next = new Pair(p.row + LEFT[0], p.col + LEFT[1], p.depth + 1);
				if (isValid(matrix, next.row, next.col) && !seen.contains(next)) {
					pairs.offer(next);
					seen.add(next);
				}
				
				next = new Pair(p.row + RIGHT[0], p.col + RIGHT[1], p.depth + 1);
				if (isValid(matrix, next.row, next.col) && !seen.contains(next)) {
					pairs.offer(next);
					seen.add(next);
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}

	private boolean isValid(int[][] matrix, int row, int col) {
		return row >= 0 && row < matrix.length & col >= 0 && col < matrix[row].length;
	}

	private boolean isHouse(int[][] matrix, int row, int col) {
		return isValid(matrix, row, col) && matrix[row][col] == 2;
	}

	private boolean isBusStop(int[][] matrix, int row, int col) {
		return isValid(matrix, row, col) && matrix[row][col] == 3;
	}

	private boolean isWall(int[][] matrix, int row, int col) {
		return isValid(matrix, row, col) && matrix[row][col] == 1;
	}

	public static void main(String[] args) {
		System.out.println(new NearestBusStop()
				.solve(new int[][] { { 2, 1, 3, 0 }, { 1, 1, 1, 1 }, { 0, 3, 0, 0 }, { 0, 0, 0, 2 } }));
	}
}
