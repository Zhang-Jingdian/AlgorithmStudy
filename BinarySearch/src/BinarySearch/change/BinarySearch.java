package BinarySearch.change;

public class BinarySearch {
    public static int binarySearchAlternative(int[] a,int target){
        int i=0;
        int j=a.length;//指向不等于target的边界索引

        while(i<j){
            int m=(i+j)>>>1;
            if(target<a[m]){
                j=m;
            }else if(a[m]<target){
                i=m+1;
            }else{
                return m;
            }
        }
        return -1;
    }
    //问题一：为什么不用i<=j
    //答：当数组中不存在时会死循环
}
