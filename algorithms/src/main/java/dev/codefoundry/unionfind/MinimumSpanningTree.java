package dev.codefoundry.unionfind;

import java.util.HashSet;
import java.util.Set;

public class MinimumSpanningTree {
	class Pair {
		int a;
		int b;
		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null || !Pair.class.isInstance(obj)) return false;
			
			Pair other = Pair.class.cast(obj);
			return this.a == other.a && this.b == other.b;
		}
		
		@Override
		public int hashCode() {
			return a + b;
		}
	}
	public boolean solve(int[][] edges, int a, int b) {
		UnionFindWithPathCompression uf = new UnionFindWithPathCompression(edges.length);
		Set<Pair> connection = new HashSet<>();
		for (int[] edge : edges) {
			if (!uf.connected(edge[0], edge[1])) {
				uf.union(edge[0], edge[1]);
				connection.add(new Pair( Math.min(edge[0], edge[1]), Math.max(edge[0], edge[1]) ));
			}
		}

		return connection.contains(new Pair ( Math.min(a, b), Math.max(a, b) ));
	}
	
	public static void main(String[] args) {
		MinimumSpanningTree mst = new MinimumSpanningTree();
		boolean result = mst.solve(new int[][] {
			{0, 1, 1},
		    {1, 2, 1},
		    {2, 0, 2}
		}, 0, 2);
		System.out.println("Done::: " + result);
	}
}
