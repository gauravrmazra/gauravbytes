package cc.gaurav.tries;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 *
 */
public class MorrisInOrderIterator {
	
	private static class MorrisInOrderIteratorInternal implements Iterator<Integer> {
		private TreeNode current;
		public MorrisInOrderIteratorInternal(TreeNode root) {
			this.current = root;
		}
		
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		/**
		 * TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    nodes.add(cur.val);
                    cur = cur.right;
                }
		 */
		
		@Override
		public Integer next() {
			if (hasNext()) {
				Integer returnValue = null;
				do {
					if (current.left() == null) {
						returnValue = current.val();
						current = current.right();
					} else {
						TreeNode prev = current.left();
						while(prev.right() != null && prev.right() != current) {
							prev = prev.right();
						}
						
						if (prev.right() == null) {
							prev.right(current);
							current = current.left();
						} else {
							prev.right(null);
							returnValue = current.val();
							current = current.right();
						}
						
					}
				} while(returnValue == null);
				
				return returnValue;
				
			}
			
			throw new NoSuchElementException("There is no element to retrieve from this iterator");
		}
	}
	public Iterable<Integer> inOrderMorisTraversalIterable(TreeNode root) {
		return new Iterable<Integer>() {
			
			@Override
			public Iterator<Integer> iterator() {
				return new MorrisInOrderIteratorInternal(root);
			}
		};
	}

}
