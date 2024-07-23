package org.DoublyLinkedListSentinel;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer>{
    //点对象
    static class Node{
        Node prev;//上一个节点指针
        int value;//值
        Node next;//下一个节点指针

        public Node(Node prev,int value,Node next){
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    //点对象实例化
    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel(){
        head=new Node(null,0,null);
        tail=new Node(null,0,null);
        head.next=tail;
        tail.prev=head;
    }
    //查找节点
    private Node findNode(int index){
        int i=-1;
        for(Node p=head;p!=tail;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }
    //插入节点
    public void insert(int index,int value){
        Node prev=findNode(index-1);
        if(prev==null){
            throw illegalIndex(index);
        }
        Node next=prev.next;
        Node inserted=new Node(prev,value,next);
        prev.next=inserted;
        next.prev=inserted;
    }
    //判断索引合法性
    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index)
        );
    }
    //删除节点
    public void remove(int index){
       Node prev =findNode(index-1);
       if(prev==null){
           throw illegalIndex(index);
       }
       Node removed=prev.next;
       if(removed==tail){
           tail=prev;
       }
       Node next=removed.next;
       prev.next=next;
       next.prev=prev;
    }
    //尾插
    public void addLast(int value){
        Node last=tail.prev;
        Node added=new Node(last,value,tail);
        last.next=added;
        tail.prev=added;
    }
    //尾删
    public void removeLast(){
        Node removed=tail.prev;
        if(removed==head){
            throw illegalIndex(0);
        }
        Node prev=removed.prev;
        prev.next=tail;
        tail.prev=prev;
    }
    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Integer next() {
                int value=p.value;
                p=p.next;
                return value;
            }
        };
    }
}
