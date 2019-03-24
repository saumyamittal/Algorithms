package com.saumya.bt;

import com.saumya.utils.Node;
import com.saumya.utils.TreeUtils;
import java.util.Stack;

public class SpriralTraversal {

  public static void main(String args[]) {

    Node<Integer> rootNode = TreeUtils.createRandonTree_1();
    TreeUtils.print(rootNode);

    // Output should be
    // 12, 27, 45, 16, 23, 46, 32, 35, 58, 54, 85, 68, 894, 55, 28

    Stack<Node<Integer>> s1 = new Stack();
    Stack<Node<Integer>> s2 = new Stack();

    if(rootNode != null) {
      Node<Integer> tempNode = rootNode;
      s1.push(tempNode);
      while (! s1.empty() || !s2.empty() ) {
        while (!s1.empty()) {
          tempNode = s1.pop();
          System.out.print(" " + tempNode.data);
          if (tempNode.left != null) {
            s2.push(tempNode.left);
          }
          if (tempNode.right != null) {
            s2.push(tempNode.right);
          }
        }
        while (!s2.empty()) {
          Node<Integer> secondStackNode = s2.pop();
          System.out.print(" " + secondStackNode.data);
          if (secondStackNode.right != null) {
            s1.push(secondStackNode.right);
          }
          if (secondStackNode.left != null) {
            s1.push(secondStackNode.left);
          }
        }
      }
    }
  }

}
