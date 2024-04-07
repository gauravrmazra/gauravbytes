package cc.gaurav.unionfind;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendGroups {
	class UnionFind {
		Map<Integer, Set<Integer>> unions;
		private int[] ids;
		private int[] size;

		public List<Integer> asList(final int[] is) {
			return new AbstractList<Integer>() {
				public Integer get(int i) {
					return is[i];
				}

				public int size() {
					return is.length;
				}
			};
		}

		UnionFind(int[][] friends) {
			ids = new int[friends.length];
			this.size = new int[friends.length];
			this.unions = new HashMap<>();
			for (int i = 0; i < friends.length; i++) {
				this.unions.put(i, new HashSet<>(asList(friends[i])));
				this.ids[i] = i;
				this.size[i] = 1;
			}
		}

		private boolean isVisited(int i) {
			return !(this.ids[i] == i);
		}

		private int root(int i) {
			while (i != ids[i])
				i = ids[i];

			return i;
		}

		boolean find(int i, int friend) {
			return unions.get(i) != null && unions.get(i).contains(friend);
		}

		void union(int i, int j) {
			int rootI = root(i);
			int rootJ = root(j);
			// if (size[rootI] < size[rootJ]) {
			ids[rootI] = rootJ;
			// size[rootJ] += size[rootI];
			// } else {
			// ids[rootJ] = rootI;
			// size[rootI] += size[rootJ];
			// }
		}

		private int unique() {
			return (int) Arrays.stream(this.ids).map(this::root).distinct().count();
		}
	}

	public int solve(int[][] friends) {
		UnionFind uf = new UnionFind(friends);
		for (int i = 0; i < friends.length; i++) {
			if (!uf.isVisited(i)) {
				for (int friend : friends[i]) {
					if (uf.find(i, friend)) {
						uf.union(i, friend);
					}
				}
			}
		}

		return uf.unique();
	}
}
