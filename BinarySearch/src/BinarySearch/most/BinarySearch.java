package BinarySearch.most;

public class BinarySearch {
    public static int binarySearchLeftmost1(int[] a,int target){
        int i=0;
        int j=a.length-1;
        int candidate=-1;
        while(i<=j){
            int m=(i+j)>>>1;
            if(target<a[m]){
                j=m-1;
            }else if(a[m]<target){
                i=m+1;
            }else{
                candidate=m;
                j=m-1;
            }
        }
        return candidate;
    }

    public static int binarySearchRightmost1(int[]a,int target){
        int i=0;
        int j=a.length-1;
        int candidate=-1;
        while(i<=j){
            int m=(i+j)>>>1;
            if(target<a[m]){
                j=m-1;
            }else if(a[m]<target){
                i=m+1;
            }else{
                candidate=m;
                i=m+1;
            }
        }
        return candidate;
    }

    public static int binarySearchLeftmost2(int[] a,int target){
        int i=0;
        int j=a.length-1;
        while(i<=j){
            int m=(i+j)>>>1;
            if(target<a[m]){
                j=m-1;
            }else if(a[m]<target){
                i=m+1;
            }else{
                j=m-1;
            }
        }
        return i;
    }

    public static int binarySearchRightmost2(int[]a,int target){
        int i=0;
        int j=a.length-1;
        while(i<=j){
            int m=(i+j)>>>1;
            if(target<a[m]){
                j=m-1;
            }else if(a[m]<target){
                i=m+1;
            }else{
                i=m+1;
            }
        }
        return i-1;//j也行
    }
}
