package recursion;

public class PascalTriangle3 {

    private static void createRow(int[] row,int i){
        if(i==0){
            row[0]=1;
            return;
        }
        for(int j=i;j>0;j--){
            row[j]=row[j]+row[j-1];
        }
    }

    private static void printSpace(int n,int i){
        int num = (n-1-i)*2;
        for(int j=0;j<num;j++){
            System.out.print(" ");
        }
    }

    public static void print(int n){
        int[] row = new int[n];
        for(int i=0;i<n;i++){//行
            createRow(row,i);
            printSpace(n,i);
            for(int j=0;j<=i;j++){
                System.out.printf("%-4d",row[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(10);
    }
}
