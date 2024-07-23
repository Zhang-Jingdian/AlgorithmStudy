package org.SinglyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {
    private Node head=null;//头指针
    //如果所用变量局限于外部类中，内部类加static
    //节点
    private static class Node {//内部类，类与类是组合关系
        int value;//值
        Node next;//下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    //头插
    public void addFirst(int value){
        //  //链表为空
        //  head=new Node(value,null);
        //链表非空
        head=new Node(value,head);
    }
    //查找尾节点
    private Node findNode(){
        if (head == null) {
            return null;
        }
        Node p;
        for(p=head;p.next!=null;p=p.next){

        }
        return p;
    }
    //尾插
    public void addLast(int value){
        Node last=findNode();
        if (last == null) {
            addFirst(value);;
            return;
        }
        last.next=new Node( value,null);
    }
    //插入
    public void insert(int index,int value)throws IllegalArgumentException{
        if(index==0){
            addFirst(value);
            return;
        }
        Node prev=findNode(index-1);//找到上一个节点
        if (prev == null) {//没找到
            throw illegalIndex(index);//%n是换行
        }
        prev.next=new Node(value,prev.next);
    }
    //判断index的合法性
    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }
    //遍历
    public void loop1 (Consumer<Integer> consumer){
        Node p=head;
        while(p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }
    //遍历
    public void loop2 (Consumer<Integer> consumer){
        for(Node p=head;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }
    //遍历
    public void loop3(Consumer<Integer> before,Consumer<Integer> after){
        recursion(head,before,after);
    }
    //递归
    private void recursion(Node curr,Consumer<Integer> before,Consumer<Integer> after){//针对某个节点要进行的操作
        if(curr==null){
            return;
        }
        before.accept(curr.value);
        recursion(curr.next,before,after);
        after.accept(curr.value);
    }
    //遍历
    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new Iterator<Integer>() {
            Node p=head;
            @Override
            public boolean hasNext() {//是否有下一个元素
                return p!=null;
            }

            @Override
            public Integer next() {//返回当前值，并指向下一个元素
                int v = p.value;
                p=p.next;
                return v;
            }
        };
    }
    //    public void test(){
    //        int i=0;
    //        for(Node p=head;p!=null;p=p.next,i++){
    //            System.out.println(p.value+"索引是："+i);
    //        }
    //    }
    //查找节点
    private Node findNode(int index){
        int i=0;
        for(Node p=head;p!=null;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }
    //获取节点的值
    public int get(int index) throws IllegalArgumentException{
        Node node = findNode(index);
        if(node==null){
            throw illegalIndex(index);//%n是换行
        }
        return node.value;
    }
    //删除第一个节点
    public void removeFirst() throws IllegalArgumentException{
        if (head == null) {
            throw illegalIndex(0);
        }
        head=head.next;
    }
    //删除索引的节点
    public void remove(int index) throws IllegalArgumentException{
        if(index==0){
            removeFirst();
        }
        Node prev=findNode(index-1);//上一个节点
        if(prev==null){
            throw illegalIndex(index);
        }
        Node removed=prev.next;//被删除的节点
        if(removed==null){
            throw illegalIndex(index);
        }
        prev.next=removed.next;
    }
}

