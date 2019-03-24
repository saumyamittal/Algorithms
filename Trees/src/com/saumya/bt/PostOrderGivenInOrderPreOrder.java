package com.saumya.bt;

import java.util.Arrays;
import java.util.Stack;

public class PostOrderGivenInOrderPreOrder {

  public static void main(String [] args) {
    int in[] = {4, 2, 5, 1, 3, 6};
    int pre[] = {1, 2, 4, 5, 3, 6};
    int n = in.length;
    System.out.println("Postorder traversal " );
    printPostOrder(in, pre, n);

    // printPostOrder();
  }

  private static void printPostOrder(int [] in, int [] pre) {

    int root = pre[0];
    int rootIndexInInOrder = getRootIndex(in, root);

    // Print post order for left tree
    if(rootIndexInInOrder > 0) {
      printPostOrder(Arrays.copyOfRange(in, 0, rootIndexInInOrder), Arrays.copyOfRange(pre, 1, pre.length));
    }

    // Print post order for right tree
    if(in.length > 1)
    {
      printPostOrder(Arrays.copyOfRange(in, rootIndexInInOrder+1, in.length), Arrays.copyOfRange(pre, 1, pre.length));
    }
    System.out.print(" " + root);

  }



  private static int getRootIndex(int array[], int x) {
    for(int i = 0; i<array.length ; i++) {
      if(array[i] == x) {
        return  i;
      }
    }
    return -1;
  }


  static int search(int arr[], int x, int n)
  {
    for (int i = 0; i < n; i++)
      if (arr[i] == x)
        return i;
    return -1;
  }

  // Prints postorder traversal from
// given inorder and preorder traversals
  static void printPostOrder(int in1[],
      int pre[], int n)
  {
    // The first element in pre[] is
    // always root, search it in in[]
    // to find left and right subtrees
    int root = search(in1, pre[0], n);

    // If left subtree is not empty,
    // print left subtree
    if (root != 0)
      printPostOrder(in1, Arrays.copyOfRange(pre, 1, n), root);

    // If right subtree is not empty,
    // print right subtree
    if (root != n - 1)
      printPostOrder(Arrays.copyOfRange(in1, root+1, n),
          Arrays.copyOfRange(pre, 1+root, n), n - root - 1);

    // Print root
    System.out.print( pre[0] + " ");
  }

}
