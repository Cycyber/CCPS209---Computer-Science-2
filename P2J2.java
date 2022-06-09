import java.util.LinkedHashSet;
import java.util.Set;

public class P2J2 {
    //   throw new UnsupportedOperationException();
    public static String removeDuplicates(String text) {
        char[] textarr=text.toCharArray();
        String result = "";
        char temp='\0';
        for (var c: textarr) {
            if (c !=temp){
                result=result + c;
                temp=c;
            }
        }
        return result;
    }
    public static String uniqueCharacters(String text) {
        Set<String> mylinkedhashset= new LinkedHashSet<>();
        for (char c: text.toCharArray()){
            mylinkedhashset.add((Character.toString(c)));
        }
        Object[] arr=mylinkedhashset.toArray();
        StringBuilder result=new StringBuilder();
        for (int a=0; a<arr.length;a++){
            result.append(arr[a]);
        }
        return result.toString();
    }
    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {
        int[] rows = new int[n];
        int[] cols = new int[n];
        int safeRows = 0;
        int safeCols = 0;
        int result;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rooks[i][j]) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (rows[i] == 0) {
                safeRows++;
            }
            if (cols[i] == 0) {
                safeCols++;
            }
        }
        result = safeRows * safeCols;
        return result;
    }
    public static int recaman(int n) {
        int[] sequence = new int[n+1];
        boolean[] completed = new boolean[10 * n];
        completed[0] = true;
        for (int i = 1; i <=n; i++){
            int negative = sequence[i - 1] - i;
            int positive = sequence[i - 1] + i;
            if ((negative > 0) && (!completed[negative])){
                sequence[i] = negative;
                completed[negative] = true;
            } else{
                sequence[i] = positive;
                completed[positive] = true;
            }
        }
        return sequence[n];
    }
}
