package org.DoublyLinkedListSentinel;

import java.util.Iterator;

public class DoublyLinkedRingListSentinel implements Iterable<Integer>{
    //节点对象
    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    //哨兵节点
    private Node sentinel = new Node(null,0,null);
    public DoublyLinkedRingListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    //头插
    public void addFirst(int value) {
        Node a=sentinel;
        Node b=sentinel.next;
        Node added=new Node(a,value,b);
        a.next=added;
        b.prev=added;
    }
    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public Integer next() {
                int value=p.value;
                p=p.next;
                return 0;
            }
        };
    }
    //尾插
    public void addLast(int value){
        Node a=sentinel.prev;
        Node b=sentinel;
        Node added=new Node(a,value,b);
        a.next=added;
        b.prev=added;

    }
    //头删
    public void removeFirst(){
        Node removed=sentinel.next;
        if(removed==sentinel){
            throw  new IllegalArgumentException("非法");
        }
        Node a=sentinel;
        Node b=removed.next;
        a.next=b;
        b.prev=a;
    }
    //尾删
    public void removeLast(){
        Node removed=sentinel.prev;
        if(removed==sentinel){
            throw  new IllegalArgumentException("非法");
        }
        Node a=removed.prev;
        Node b=sentinel;
        a.next=b;
        b.prev=a;
    }
    //按值查找
    private Node findByvalue(int value){
        Node p=sentinel.next;
        while(p!=sentinel){
          if(p.value==value){
              return p;
          }
          p=p.next;
        }
        return null;
    }
    //根据值删除
    public void removeByValue(int value){
        Node removed=findByvalue(value);
        if(removed==null){
            return;
        }
        Node a=removed.prev;
        Node b=removed.next;
        a.next=b;
        b.prev=a;
    }
}
