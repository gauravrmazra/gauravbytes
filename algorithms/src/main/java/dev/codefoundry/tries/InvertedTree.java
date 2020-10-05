package dev.codefoundry.tries;

public class InvertedTree {
	class Tree {
		int val;
		Tree left;
		Tree right;
	}

	public boolean solve(Tree source, Tree target) {
        return solveInternal(source, target, true);
    }
    
    public boolean solveInternal(Tree source, Tree target, boolean sourceIsRoot) {
        if (source == null && target == null) {
			return true;
		}

		if ((source == null && target != null) || (source != null && target == null)) {
			return false;
		}

		if (source.val == target.val 
				&& ((solveInternal(source.left, target.left, false) && solveInternal(source.right, target.right, false))
				|| (solveInternal(source.left, target.right, false) && solveInternal(source.right, target.left, false)))
		) {
			return true;		
		} else {
            return sourceIsRoot ? (solveInternal(source, target.left, sourceIsRoot) || solveInternal(source, target.right, sourceIsRoot)) : false;
		}
    }
	
	public static void main(String[] args) {
		InvertedTree it = new InvertedTree();
		Tree source = it.tree(1, it.tree(0, null, null), null);
		Tree target = it.tree(1, it.tree(0, null, null), null);
		
		System.out.println(it.solve(source, target));
	}
	
	public Tree tree(int val, Tree left, Tree right) {
		Tree t = new Tree();
		t.val = val;
		t.left = left;
		t.right = right;
		return t;
	}
}
