package cc.gaurav.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class RemoveSmallestPeaks {
  static class Node {
    int key;
    int val;

    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }

    Node next;
    Node prev;

    static void join(Node ...nodes) {
      for (int i = 0; i < nodes.length - 1; i++) {
        nodes[i].next = nodes[i + 1];
        nodes[i + 1].prev = nodes[i];
      }
    }

    static void join(List<Node> nodes) {
      for (int i = 0; i < nodes.size() - 1; i++) {
        join(nodes.get(i), nodes.get(i + 1));
      }
    }
  }
  public int[] solve(int[] nums) {
    
    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      nodes.add(new Node(i, nums[i]));
    }
    Node.join(nodes);

    Map<Integer, Node> valueToNode = new HashMap<>();
    for (Node n : nodes) {
      valueToNode.put(n.val, n);
    }

    Node marker = new Node(0, 0);
    nodes.get(0).prev = marker;
    nodes.get(nodes.size() - 1).next = marker;

    PriorityQueue<Integer> peeks = new PriorityQueue<>();
    for(int i = 0; i < nums.length; i++) {
      if (( i == 0 || nums[i] > nums[i - 1]) && (
        i == nums.length - 1 || nums[i] > nums[i + 1] 
      )) {
        peeks.offer(nums[i]);
      }
    }

    Set<Integer> seen = new HashSet<>();
    List<Integer> ans = new ArrayList<>();

    Node peekNode;
    int peek;
    while(!peeks.isEmpty()) {
      peek = peeks.poll();
      peekNode = valueToNode.get(peek);
      if (peekNode.prev != null && peekNode.next != null) {
        Node.join(peekNode.prev, peekNode.next);
      } else if (peekNode.prev != null) {
        peekNode.prev.next = null;
      } else if (peekNode.next != null) {
        peekNode.next.prev = null;
      }

      for (Node nei : Arrays.asList(peekNode.prev, peekNode.next)) {
        if (nei == null) continue;

        int nv = nei.val;

        if (!seen.contains(nv) 
            && (nei.prev == null || nei.prev.val < nv)
            && (nei.next == null || nei.next.val < nv)) {
          peeks.offer(nv);
          seen.add(nv);
        }
      }
      ans.add(peek);
    }


    int[] result = new int[ans.size()];
    int i = 0;
    for (int num : ans) {
      result[i++] = num;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new RemoveSmallestPeaks().solve(new int[] {3, 5, 1, 4, 2})));
  }
}
