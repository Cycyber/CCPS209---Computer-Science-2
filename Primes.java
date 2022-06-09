import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {
    private static ArrayList<Integer> primeList=new ArrayList<>(Arrays.asList(2,3,5,7,11,13));

    public static void expandPrimes(){
        int lastPrime=primeList.get(primeList.size()-1);
        int nextPossiblePrime=lastPrime+2;
        while(true){
            if(isPrime(nextPossiblePrime)){
                primeList.add(nextPossiblePrime);
                break;
            }
            else{
                nextPossiblePrime+=2;
            }
        }
    }

    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    public static int kthPrime(int k) {
        while(k >= primeList.size()) {
            expandPrimes();
        }
        return primeList.get(k);
    }
    public static List<Integer> factorize(int n){
        List<Integer> primeFactors = new ArrayList<>();

        while (n % 2 == 0) {//Divisible by 2
            primeFactors.add(2);
            n /= 2;
        }
        int factor = 3;
        while (factor * factor <= n) {
            if (n % factor == 0) {
                primeFactors.add(factor);
                n /= factor;
            }
            else{
                factor += 2;
            }
        }
        if (n > 1) {
            primeFactors.add(n);
        }
        return primeFactors;
    }

}
