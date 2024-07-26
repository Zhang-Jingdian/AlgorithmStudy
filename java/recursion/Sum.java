package recursion;

public class Sum {
    public static long sum(long n){
        if(n==1){
            return 1;
        }
        return sum(n-1)+n;
    }
}
