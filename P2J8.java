import java.math.BigInteger;

public class P2J8
{
    public static void hittingIntegerPowers(int a, int b, int t, int[] out){
        BigInteger intA = BigInteger.valueOf(a);
        BigInteger intA2 = BigInteger.valueOf(a);
        BigInteger intB = BigInteger.valueOf(b);
        BigInteger intB2 = BigInteger.valueOf(b);
        BigInteger tolerance = BigInteger.valueOf(t);
        int pa = 1;
        int pb = 1;

        while(true){
            BigInteger dif = intA2.subtract(intB2).abs().multiply(tolerance);
            if(dif.compareTo(intA2) < 1 || dif.compareTo(intB2) < 1){
                out[0] = pa;
                out[1] = pb;
                break;
            }
            if(intA2.compareTo(intB2) < 1){
                intA2 = intA2.multiply(intA);
                pa++;
            }else{
                intB2 = intB2.multiply(intB);
                pb++;
            }
        }
    }
    static BigInteger s_Gonal(BigInteger i, int s){
        //From wikipedia Polygonal Number   ((s - 2) i2 - (s - 4) i) / 2.
        BigInteger first = BigInteger.valueOf(s-2).multiply(i.multiply(i));
        BigInteger second = BigInteger.valueOf(s-4).multiply(i);
        BigInteger answer = first.subtract(second).divide(BigInteger.valueOf(2));
        return answer;
    }
    public static BigInteger nearestPolygonalNumber(BigInteger n, int s){
        BigInteger i = BigInteger.valueOf(1);
        BigInteger int1 = BigInteger.valueOf(1);
        BigInteger int2 = BigInteger.valueOf(2);
        BigInteger int10 = BigInteger.valueOf(10);

        while(s_Gonal(i,s).compareTo(n)==-1){
            i = i.multiply(int10);
        }

        BigInteger x = i.divide(int10);
        while(x.compareTo(i)==-1){
            BigInteger mid = x.add(i).divide(int2);
            BigInteger val = s_Gonal(mid, s);

            if(val.compareTo(n)==0){
                return val;
            }
            if(val.compareTo(n)==-1){
                x = mid.add(int1);
            }else{
                i = mid;
            }
        }
        if(x.compareTo(i)==0){
            x = x.subtract(int1);
        }

        BigInteger a = n.subtract(s_Gonal(x, s)).abs();
        BigInteger b = n.subtract(s_Gonal(i, s)).abs();
        if(a.compareTo(b) < 1){
            return s_Gonal(x, s);
        }else{
            return s_Gonal(i, s);
        }
    }
}