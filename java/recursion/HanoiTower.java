package recursion;

import java.util.LinkedList;

public class HanoiTower {
    static LinkedList<Integer> a=new LinkedList<>();
    static LinkedList<Integer> b=new LinkedList<>();
    static LinkedList<Integer> c=new LinkedList<>();
    //初始化汉诺塔
    static void init(int n){
        for(int i=n;i>=1;i--){
            a.add(i);
        }
    }
    //打印汉诺塔
    private static void print() {
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        System.out.println("c:"+c);
        System.out.println("---------------------------------");
    }
    //移动

    /**
     *
     * @param n-圆盘个数
     * @param a-源
     * @param b-借
     * @param c-目
     */
    static void move(int n,LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c){
        if(n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());//中间
        print();
        move(n-1,b,a,c);
    }
    //主函数
    public static void main(String[]args){
        init(3);
        print();
       move(3,a,b,c);
    }


}
