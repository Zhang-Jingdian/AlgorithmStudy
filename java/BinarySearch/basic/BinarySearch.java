package BinarySearch.basic;

public class BinarySearch {
//    二分查找基础版
//
//    Params:a-待查找的升序数组
//           target-待查找的目标值
//    Returns:找到则返回索引
//            找不到则返回-1


    public static int binarySearch(int[] a,int target){ //a为一个数组，target为待查找值

        int i=0;//设置指针初值，i指向数组的0号索引，最小索引
        int j=a.length-1;//设置指针初值，j指向数组的a.length-1索引，最大索引

        while(i<=j){//范围内有值

            int m =(i+j)>>>1;//取中间索引，向下取整，即a[m]为中间值

            if(target<a[m]){//待查找值小于中间值，即待查找值在中间值的左边，即a[i]与a[m]之间
                j=m-1;//缩小范围，将m-1的索引给j，即将中间索引变为最大索引
            }
            else if(target>a[m]){//待查找值大于中间值，即待查找值在中间值的右边，即a[m]与a[j]之间
                i=m+1;//缩小范围，将m+i的索引给i,即将中间索引变为最小索引
            }else{//找到待查找值
                return m;//返回索引
            }
        }

        return -1;
    }
    //问题一：为什么i<=j
    //答：可能i=j,若i<j，会漏掉一次比较
    //问题二： (i+j)/2有问题吗
    //答：有，如果i或j很大，结果会变成负数，故可用>>>
    //问题三：为什么都写成了小于号
    //答：升序排列，增加可读性
    //问题三：循环内两次条件语句的执行次数是否相等
    //答：否，设if执行次数为l，则当在待查目标在最右边时，if执行L次，else执行2L次
}
