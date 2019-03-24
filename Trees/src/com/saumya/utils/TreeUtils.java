package com.saumya.utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Binary tree printer
 *
 * @author saiteja
 */
public class TreeUtils {

  /**
   * Print a tree
   *
   * @param root tree root node
   */
  public static void print(PrintableNode root) {
    List<List<String>> lines = new ArrayList<List<String>>();

    List<PrintableNode> level = new ArrayList<PrintableNode>();
    List<PrintableNode> next = new ArrayList<PrintableNode>();

    level.add(root);
    int nn = 1;

    int widest = 0;

    while (nn != 0) {
      List<String> line = new ArrayList<String>();

      nn = 0;

      for (PrintableNode n : level) {
        if (n == null) {
          line.add(null);

          next.add(null);
          next.add(null);
        } else {
          String aa = n.getText();
          line.add(aa);
          if (aa.length() > widest) {
            widest = aa.length();
          }

          next.add(n.getLeft());
          next.add(n.getRight());

          if (n.getLeft() != null) {
            nn++;
          }
          if (n.getRight() != null) {
            nn++;
          }
        }
      }

      if (widest % 2 == 1) {
        widest++;
      }

      lines.add(line);

      List<PrintableNode> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i);
      int hpw = (int) Math.floor(perpiece / 2f) - 1;

      if (i > 0) {
        for (int j = 0; j < line.size(); j++) {

          // split node
          char c = ' ';
          if (j % 2 == 1) {
            if (line.get(j - 1) != null) {
              c = (line.get(j) != null) ? '┴' : '┘';
            } else {
              if (j < line.size() && line.get(j) != null) {
                c = '└';
              }
            }
          }
          System.out.print(c);

          // lines and spaces
          if (line.get(j) == null) {
            for (int k = 0; k < perpiece - 1; k++) {
              System.out.print(" ");
            }
          } else {

            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? " " : "─");
            }
            System.out.print(j % 2 == 0 ? "┌" : "┐");
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? "─" : " ");
            }
          }
        }
        System.out.println();
      }

      // print line of numbers
      for (int j = 0; j < line.size(); j++) {

        String f = line.get(j);
        if (f == null) {
          f = "";
        }
        int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
        int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

        // a number
        for (int k = 0; k < gap1; k++) {
          System.out.print(" ");
        }
        System.out.print(f);
        for (int k = 0; k < gap2; k++) {
          System.out.print(" ");
        }
      }
      System.out.println();

      perpiece /= 2;
    }
  }

  public static Node addNodeInBST(Node root, int data) {
    Node temp = root;
    Node node = new Node(data);
    if (root == null) {
      return node;
    } else {
      if (data > (int) temp.data) {
        temp.left = addNodeInBST(temp.left, data);
        ;
      } else {
        temp.right = addNodeInBST(temp.right, data);
      }
    }
    return root;
  }

  public static Node<Integer> createRandonTree_1() {
    Node<Integer> root = new Node<Integer>(12);
    Node<Integer> n11 = new Node<Integer>(27);
    Node<Integer> n12 = new Node<Integer>(45);
    Node<Integer> n21 = new Node<Integer>(32);
    Node<Integer> n22 = new Node<Integer>(46);
    Node<Integer> n23 = new Node<Integer>(23);
    Node<Integer> n24 = new Node<Integer>(16);
    Node<Integer> n31 = new Node<Integer>(35);
    Node<Integer> n32 = new Node<Integer>(58);
    Node<Integer> n33 = new Node<Integer>(54);
    Node<Integer> n34 = new Node<Integer>(85);
    Node<Integer> n35 = new Node<Integer>(68);
    Node<Integer> n36 = new Node<Integer>(894);
    Node<Integer> n37 = new Node<Integer>(55);
    Node<Integer> n38 = new Node<Integer>(28);

    root.left = n11;
    root.right = n12;

    n11.left = n21;
    n11.right = n22;
    n12.left = n23;
    n12.right = n24;

    n21.left = n31;
    n21.right = n32;
    n22.left = n33;
    n22.right = n34;
    n23.left = n35;
    n23.right = n36;
    n24.left = n37;
    n24.right = n38;

    return root;
  }

  public static Node<Integer> createRandonTree_2() {
    Node<Integer> root = new Node<Integer>(2);
    Node<Integer> n11 = new Node<Integer>(7);
    Node<Integer> n12 = new Node<Integer>(5);
    Node<Integer> n21 = new Node<Integer>(2);
    Node<Integer> n22 = new Node<Integer>(6);
    Node<Integer> n23 = new Node<Integer>(9);
    Node<Integer> n31 = new Node<Integer>(5);
    Node<Integer> n32 = new Node<Integer>(8);
    Node<Integer> n33 = new Node<Integer>(4);

    root.left = n11;
    root.right = n12;

    n11.left = n21;
    n11.right = n22;

    n12.right = n23;
    n22.left = n31;
    n22.right = n32;

    n23.left = n33;

    return root;
  }

  private Node addNode(Node root, int data) {
    Node temp = root;
    Node node = new Node(data);
    if(root == null) {
      return node;
    }
    else {
      if(data > (int)temp.data) {
        temp.left = addNode(temp.left, data);;
      }
      else {
        temp.right = addNode(temp.right, data);
      }
    }
    return root;
  }
  public Node removeNode(Node root, int data) {
    return root;
  }

  public Node searchNode(Node root, int data) {
    Node temp = root;
    if(temp == null) {
      return null;
    }
    else {
      if(data > (int)temp.data) {
        return searchNode(temp.left, data);
      }
      else {
        return searchNode(temp.right, data);
      }
    }

  }

  public Node deleteNode(Node root, int data) {
    Node parentNode;
    Node targetNode = searchNode(root, data);
    if(targetNode != null) {
      if(targetNode.left == null) {

      }
      Node minimumNode = findMinimum(targetNode.right);
      targetNode.data = minimumNode.data;
    }
    return root;
  }

  private Node findMinimum(Node root) {
    Node temp = root;
    if(temp == null) {
      return null;
    }
    else {
      while (temp.left != null) {
        temp = temp.left;
      }
    }
    return temp;
  }
}