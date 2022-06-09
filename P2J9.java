public class P2J9 {
    public static boolean[] sumOfTwoDistinctSquares(int n) {
        boolean[] result = new boolean[n];
        int a=1;
        int b=a+1;
        while((a*a + b*b) < n) {
            result[(a*a + b*b)] = true;
            b++;
            if((a*a + b*b) >= n) {
                a++;
                b = a+1;
            }
        }
        return result;
    }

    public static boolean[] subtractSquare(int n) {
        boolean[] truths = new boolean[n];
        int move=0;
        for (int i = 1; i < n; i++) {
            move = 1;
            while ((i - move * move) >= 0) {
                if (!truths[(i - move * move)]) {
                    truths[i] = true;
                    break;
                }
                move++;
            }
        }
        return truths;
    }
}
