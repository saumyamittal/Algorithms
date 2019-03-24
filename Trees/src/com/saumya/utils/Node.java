package com.saumya.utils;

public class Node<T extends Comparable<?>> implements PrintableNode {

  public Node<T> left, right;
  public T data;

  public Node(T data) {
    this.data = data;
  }

  @Override
  public PrintableNode getLeft() {
    return left;
  }

  @Override
  public PrintableNode getRight() {
    return right;
  }

  @Override
  public String getText() {
    return "" + data;
  }
}