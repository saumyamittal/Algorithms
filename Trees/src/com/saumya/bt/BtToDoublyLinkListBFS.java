package com.saumya.bt;

import com.saumya.utils.DoublyLinkListNode;
import com.saumya.utils.Node;
import com.saumya.utils.TreeUtils;
import java.util.LinkedList;
import java.util.Queue;

public class BtToDoublyLinkListBFS {

  public static void main(String args[]) {
    Node<Integer> rootNode = TreeUtils.createRandonTree_1();
    TreeUtils.print(rootNode);

    Queue<Node<Integer>> queue = new LinkedList<>();
    DoublyLinkListNode<Integer> head = null;
    DoublyLinkListNode<Integer> previous = null;

    if(rootNode != null) {
      Node<Integer> tempNode = rootNode;
      queue.add(tempNode);

      while(!queue.isEmpty()) {
        tempNode = queue.poll();
        DoublyLinkListNode<Integer> currentNode = new DoublyLinkListNode<>(tempNode.data);
        currentNode.previous = previous;

        if(head == null) {
          head = currentNode;
        }
        else {
          previous.next = currentNode;
        }
        if(tempNode.left != null) {
          queue.add(tempNode.left);
        }
        if(tempNode.right != null) {
          queue.add(tempNode.right);
        }
        previous = currentNode;
      }
    }

    System.out.print(head);

  }

}
