package BinarySearch.balance;

public class BinarySearch {
    public static int binarySearch(int[] a,int target){
        int i=0;
        int j=a.length;

        while(1<j-i){
            int m=(i+j)>>>1;
            if(target<a[m]){
                j=m;
            }else if(a[m]<target){
                i=m;
            }
        }

        if(a[i]==target){
            return i;
        }
        else{
            return -1;
        }
    }
}
