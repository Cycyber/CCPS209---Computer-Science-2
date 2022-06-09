import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P2J5 {
    private static final List<BigInteger> fibs = new ArrayList<>();
    static {fibs.add(BigInteger.ONE);fibs.add(BigInteger.ONE);}

    public static List<BigInteger> fibonacciSum(BigInteger n){
        List<BigInteger> resultList = new ArrayList<BigInteger>();
        int size = fibs.size();
        BigInteger number = fibs.get(size - 2).add(fibs.get(size - 1));
        while(n.compareTo(number) >= 0) {
            fibs.add(number);
            size = fibs.size();
            number = fibs.get(size - 2).add(fibs.get(size - 1));
        }
        BigInteger tempNumber = n;
            for (int a = size - 1; a >= 0; a--) {
                if (tempNumber.equals(BigInteger.ZERO))
                    break;

                BigInteger num = fibs.get(a);
                if (num.compareTo(tempNumber) <= 0) {
                    resultList.add(num);
                    tempNumber = tempNumber.subtract(num);
                }
            }
            return resultList;

    }
    public static BigInteger sevenZero(int n){
        StringBuilder zero = new StringBuilder();
        while (n%10==0){
            zero.append("0");
            n/=10;
        }
        while (n%2==0){
            zero.append("0");
            n/=2;
        }
        while (n%5==0){
            zero.append("0");
            n/=5;
        }

        BigInteger result = new BigInteger("7"+zero);
        BigInteger divisor = new BigInteger(String.valueOf(n));
        while (result.mod(divisor).compareTo(BigInteger.ZERO)!=0){
            result = new BigInteger("7"+result);
        }
        return result;
    }
}
