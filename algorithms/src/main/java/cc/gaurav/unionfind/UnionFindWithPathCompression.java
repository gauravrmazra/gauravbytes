package cc.gaurav.unionfind;

public class UnionFindWithPathCompression {
	private int size;
	private int[] sz;
	private int[] id;
	private int uniqueGroups;

	public UnionFindWithPathCompression(int size) {
            this.size = uniqueGroups = size;
            sz = new int[size];
            id = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

	public int find(int p) {
		int root = p;
		while (root != id[root])
			root = id[root];

		while (p != root) {
			int next = id[p];
			id[p] = root;
			p = next;
		}

		return root;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int componentSize(int p) {
		return sz[find(p)];
	}

	public int size() {
		return size;
	}

	public int uniqueGroups() {
		return uniqueGroups;
	}

	public void union(int p, int q) {

		if (connected(p, q))
			return;

		int root1 = find(p);
		int root2 = find(q);

		if (sz[root1] < sz[root2]) {
			sz[root2] += sz[root1];
			id[root1] = root2;
		} else {
			sz[root1] += sz[root2];
			id[root2] = root1;
		}
		uniqueGroups--;
	}
}
