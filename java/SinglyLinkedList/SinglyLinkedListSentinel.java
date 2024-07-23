package org.SinglyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

//哨兵链表
public class SinglyLinkedListSentinel implements Iterable<Integer>{
    private Node head=new Node(0,null);//头指针
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
        insert(0,value);
    }
    //查找尾节点
    //有哨兵后，不可能为null
    private Node findNode(){
        Node p;
        for(p=head;p.next!=null;p=p.next){

        }
        return p;
    }
    //尾插
    //有哨兵后，不可能为null
    public void addLast(int value){
       Node last=findNode();
       last.next=new Node( value,null);
    }
    //插入
    public void insert(int index,int value)throws IllegalArgumentException{

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
        Node p=head.next;
        while(p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }
    //遍历
    public void loop2 (Consumer<Integer> consumer){
        for(Node p = head.next; p!=null; p=p.next){
            consumer.accept(p.value);
        }
    }
    //遍历
    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new Iterator<Integer>() {
            Node p=head.next;
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
        int i=-1;
        for(Node p = head; p!=null; p=p.next,i++){
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
       remove(0);
    }
    //删除索引的节点
    public void remove(int index) throws IllegalArgumentException{

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
