public class P2J1 {
    public static long fallingPower(int n, int k){
        long result=1; int base=n;
        for(int x = k;x>0;x--){
            result = result * base;
            base--;
        }
        return result;
    }
    public static int[] everyOther(int[] arr){
        int[] result=new int[arr.length/2+arr.length%2];
        for(int i=0;i<result.length; i++){
            result[i]=arr[2*i];
        }
        return result;
    }
    public static int[][] createZigZag(int rows, int cols, int start){
        int[][] result = new int[rows][cols];
        for(int i=0;i<rows;i++){
            if(i%2==0) {
                int j=0;
                while(j<cols)
                {
                    result[i][j]=start;
                    start+=1;
                    j++;
                }
            } else {
                int j = cols-1;
                while(j>=0)
                {
                    result[i][j]=start;
                    start+=1;
                    j--;
                }
            }
        }
        return result;
    }
    public static int countInversions(int[] arr){
        int inversionCount = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

}
