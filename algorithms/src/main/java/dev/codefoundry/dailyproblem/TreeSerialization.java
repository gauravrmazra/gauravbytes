package dev.codefoundry.dailyproblem;

import java.util.concurrent.atomic.AtomicInteger;

public class TreeSerialization {
  static class Tree {
    final int val;
    Tree left;
    Tree right;
    Tree(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return "[val: " + this.val + ", left: " 
      + (left == null ? "null" : left.toString()) + ", right: " 
      + (right == null ? "null" : right.toString()) + "]";
    }
  }

  public String serialize(Tree node) {
    if (node == null) return null;

    return node.toString();
  }

  public Tree deserialize(String s) {
    if (s == null) return null;

    return serializeInternal(s, new AtomicInteger(0));
  }

  private Tree serializeInternal(String s, AtomicInteger idx) {
    if (s.charAt(idx.get()) == '[') {
      idx.set(idx.get() + 6);
      
      int start = idx.get();
      while(Character.isDigit(s.charAt(idx.get()))) idx.incrementAndGet();

      int end = idx.get();

      Tree node = new Tree(Integer.parseInt(s.substring(start, end)));
      idx.set(idx.get() + 8);
      node.left = serializeInternal(s, idx);

      
      idx.set(idx.get() + 9);

      node.right = serializeInternal(s, idx);
      idx.incrementAndGet();

      return node;
    } else {
      idx.set(idx.get() + 5);
      return null;
    }
  }

  public static void main(String[] args) {
    TreeSerialization ts = new TreeSerialization();

    Tree t = new Tree(5);
    t.left = new Tree(1);
    t.right = new Tree(10);
    //String s = ts.serialize(t);
    //System.out.println(s);

    Tree ds = ts.deserialize("[val: 1, left: [val: 2, left: null, right: null], right: [val: 3, left: [val: 4, left: null, right: null], right: [val: 5, left: null, right: null]]]");
    System.out.println(ds);
  }
}
