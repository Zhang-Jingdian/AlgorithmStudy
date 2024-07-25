package recursion;

public class InsertionSort {
    public static void sort(int[]a){
        insertion(a,1);
    }
    private static void insertion(int[] a,int low){
        if(low==a.length){
            return;
        }

        int t=a[low];
        int i=low-1;//已排序区域的指针
        while (i>=0&&a[i]>t) {//如果没有找到插入位置
            a[i+1]=a[i];//空出插入位置
            i--;
        }
        //找到插入位置
        if(i+1!=low){//进循环的
            a[i+1]=t;
        }

        insertion(a,low+1);
    }
    private static void insertion2(int[]a,int low){
        if(low==a.length){
            return;
        }
        int i=low-1;
        while(i>=0&&a[i]>a[i+1]){
            int t=a[i];
            a[i]=a[i+1];
            a[i+1]=t;
            i--;
        }
        insertion(a,low+1);
    }
}
