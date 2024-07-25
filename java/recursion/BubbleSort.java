package recursion;

public class BubbleSort {

    public static void sort(int[] a){
        bubble(a,a.length-1);
    }

    private static void bubble(int[]a,int j){
        if(j==0){
            return;
        }
        int x=0;
        for(int i=0;i<j;i++){
            if(a[i]>a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                x=i;
            }
        }
        bubble(a,x);
    }
}
