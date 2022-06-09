import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P2J6 {
    public static List<Integer> sumOfDistinctCubes(int n){
        int c=1;
        while(c*c*c < n){
            c++;
        }
        LinkedList<Integer> soFar = new LinkedList<>();
        sumOfDistinctCubes(n, c, soFar);
        return soFar;
    }
    private static boolean sumOfDistinctCubes(int n, int c, LinkedList<Integer> soFar){
        if (n==0){
            return true;
        }
        if (c==0) {
            return false;
        }
        int cubeOfC=c*c*c;
        if (cubeOfC <=n ){
            soFar.addLast(c);
            if(sumOfDistinctCubes(n-cubeOfC, c-1, soFar)){
                return true;
            }
            soFar.removeLast();
        }
        return sumOfDistinctCubes(n,c-1,soFar);
    }
    public static List<String> forbiddenSubstrings(String alphabet, int n,List<String> tabu){
        String soFar="";
        List<String> result = new ArrayList<>();
        forbiddenSubstrings(alphabet, n, tabu,soFar, result);
        Collections.sort(result);
        return result;
    }
    private static void forbiddenSubstrings(String alphabet, int n, List<String> tabu, String soFar, List<String> result){
        if (soFar.length()==n){
            result.add(soFar);
        }
        else {
            labelOutOfLoop:
            for(char x:alphabet.toCharArray()){
                String nextCandidate = soFar + x;
                for(String str:tabu){
                    if (nextCandidate.endsWith(str)){
                        continue labelOutOfLoop;
                    }
                }
                forbiddenSubstrings(alphabet, n, tabu, nextCandidate, result);
            }
        }
    }
}
