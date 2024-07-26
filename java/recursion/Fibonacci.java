package recursion;

import java.util.Arrays;

public class Fibonacci {
    public static int fibonacci1(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci1(n-1)+fibonacci1(n-2);
    }
//备忘录
    public static int fibonacci2(int n){
        int []cache=new int[n+1];
        Arrays.fill(cache,-1);
        cache[0]=0;
        cache[1]=1;
        return f(n,cache);
    }

    public static int f(int n,int []cache){
     if(cache[n]!=-1){
         return cache[n];
     }
        return cache[n]=f(n-1,cache)+f(n-2,cache);
    }
}
