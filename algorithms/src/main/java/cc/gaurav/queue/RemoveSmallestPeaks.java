package cc.gaurav.queue;
import java.util.*;

public class RemoveSmallestPeaks {
  static class Node {
    int idx;
    int val;

    Node prev;
    Node next;

    Node(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }

    @Override
    public String toString() {
      return "[val: " + this.val + ", idx: " + this.idx + ", prev: " + (prev == null ? null : prev.toString())
          + ", next: " + (next == null ? null : next.toString()) + "]";
    }

    static void join(Node a, Node b) {
      a.next = b;
      b.prev = a;
    }
  }

  static class DLQ {
    Node head;
    Node tail;

    DLQ() {
      head = tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
    }

    void addLast(Node n) {
      Node prev = tail.prev;
      prev.next = n;
      n.prev = prev;
      n.next = tail;
      tail.prev = n;
    }
  }

  private boolean isPeek(Node n) {
    if (n.prev.val == -1 && n.next.val == -1) {
      return n.val != -1;
    } else if (n.prev.val == -1) {
      return n.val > n.next.val;
    } else if (n.next.val == -1) {
      return n.prev.val < n.val;
    } else {
      return n.prev.val < n.val && n.val > n.next.val;
    }
  }

  public int[] solve(int[] nums) {
    Map<Integer, Node> idxToNodes = new HashMap<>();

    DLQ dlq = new DLQ();
    for (int i = 0; i < nums.length; i++) {
      Node curr = new Node(i, nums[i]);
      dlq.addLast(curr);
      idxToNodes.put(i, curr);
    }

    PriorityQueue<Node> q = new PriorityQueue<>((Node a, Node b) -> Integer.compare(a.val, b.val));

    for (int i = 0; i < nums.length; i++) {
      if (i == 0 && i + 1 < nums.length && nums[i] > nums[i + 1])
        q.offer(idxToNodes.get(i));
      else if (i + 1 == nums.length && i > 0 && nums[i - 1] < nums[i])
        q.offer(idxToNodes.get(i));
      else if (i > 0 && i + 1 < nums.length && nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
        q.offer(idxToNodes.get(i));
      }
    }

    List<Integer> results = new ArrayList<>();
    Node peek;
    Node prev;
    Node next;
    while (!q.isEmpty()) {
      peek = q.poll();
      prev = peek.prev;
      next = peek.next;
      results.add(peek.val);
      Node.join(prev, next);

      if (isPeek(prev)) {
        q.offer(prev);
      }

      if (isPeek(next)) {
        q.offer(next);
      }
    }

    int[] result = new int[results.size()];
    int i = 0;
    for (Integer r : results) {
      result[i++] = r;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new RemoveSmallestPeaks().solve(new int[] {3, 5, 1, 4, 2})));
  }
}
