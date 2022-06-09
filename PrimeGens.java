import java.util.Iterator;

public class PrimeGens {

    public static class TwinPrimes implements Iterator<Integer> {
        private int k = 0;
        @Override
        public boolean hasNext() {
            return true;
        }
        @Override
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k++);
                if (Primes.isPrime(p + 2)) {
                    return p;
                }
            }
        }
    }

    public static class SafePrimes implements Iterator<Integer> {
        private int k = 0;
        @Override
        public boolean hasNext() {
            return true;
        }
        @Override
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k++);
                if (Primes.isPrime((p - 1) / 2)) {
                    return p;
                }
            }
        }
    }

    public static class StrongPrimes implements Iterator<Integer> {
        private int k = 1;
        @Override
        public boolean hasNext() {
            return true;
        }
        @Override
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k++);
                if ((p > (Primes.kthPrime(k) + Primes.kthPrime(k - 2)) / 2)) {
                    return p;
                }
            }
        }
    }
}