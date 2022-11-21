package dev.codefoundry.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://codefoundry.dev}
 *
 */
public class CloneGraph {
	static class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	    
	    @Override
	    public String toString() {
	    	return "[Node: val:" + this.val + ", neigh: " + this.neighbors.toString() + "]";
	    }
	}
	
	public Node cloneGraph(Node node) {
		if (node == null) return null;
        
        
        Map<Integer, Node> cache = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Set<Integer> visited = new HashSet<>();
        
        Node current;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                current = q.poll();
                cache.computeIfAbsent(current.val, Node::new);
                if (!visited.contains(current.val)) {
                    Node copied = cache.get(current.val);
                    for (Node neigh : current.neighbors) {
                        q.offer(neigh);
                        copied.neighbors.add(cache.computeIfAbsent(neigh.val, Node::new));
                    }
                }
                
                visited.add(current.val); 
            }
        }
        
        Node clonedGraph = cache.get(node.val);
        
        return clonedGraph;
    }
	
	public static void main(String[] args) {
		
	}

}
