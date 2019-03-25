package com.saumya.utils;

public class DoublyLinkListNode<T> {

  public DoublyLinkListNode<T> next;
  public DoublyLinkListNode<T> previous;
  public T data;

  public DoublyLinkListNode(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return " " + data + " --> " + next;
  }
}
