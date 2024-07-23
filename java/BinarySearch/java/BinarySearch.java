package BinarySearch.java;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

public class BinarySearch {
    /*
         /
      {2,5,8}     a
      {2,0,0,0}   b
      {2,4,0,0}   b
      {2,4,5,8}   b
    */
    @Test
    @DisplayName("binarySearch java版")
    public void test(){
        int[]a={2,5,8};
        int target=4;

        int i = Arrays.binarySearch(a,target);
        System.out.println(i);

        if(i<0){
            int insertIndex=Math.abs(i+1);
            int[]b=new int[a.length+1];
            System.arraycopy(a,0,b,0,insertIndex);
            b[insertIndex]=target;
            System.arraycopy(a,insertIndex,b,insertIndex+1,a.length-insertIndex);
            System.out.println(Arrays.toString(b));


        }

    }
}
