package com.botforever.ds;

public class MyLinkedList {
    public MyNode head;

    public MyLinkedList() {
        this.head = null;
    }

    public MyLinkedList(MyNode node) {
        this.head = node;
    }

    public MyLinkedList(MyNode[] array) {
        this.head = array[0];
        for (int i = 1; i < array.length; i++) {
            this.append(array[i]);
        }
    }

    public void append(MyNode end) {
        MyNode node = head;
        if (head == null) {
            this.head = end;
            return;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    public  void delete(MyNode n) {
        MyNode node = head;
        if (node.data.equalsIgnoreCase(n.data)) {
            this.head = this.head.next;
            return;
        }

        while (node.next != null) {
            if (node.next.data.equalsIgnoreCase(n.data)) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public int length() {
        int l = 0;
        MyNode node = head;
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }

    public  void print() {
        MyNode node = head;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

}
