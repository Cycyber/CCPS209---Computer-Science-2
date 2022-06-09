import java.util.Arrays;


public class Polynomial implements Comparable<Polynomial> {
    private int[] myPolynomialArray;

    public Polynomial (int[] coeffecients) {
        int[] empty = {0};
        int emptySpot = -1;
        //Get coeffecients from end to beginning.
        for(int x = coeffecients.length -1; x > -1; x--) {
            if (coeffecients[x] == 0) {
                emptySpot = x;
                if (x == 0) {
                    this.myPolynomialArray = empty;
                    return;
                }
            }else {
                break;
            }
        }

        int[] testArray;
        if (emptySpot < 0) {
            emptySpot = coeffecients.length;
        }
        testArray = new int[emptySpot];

        System.arraycopy(coeffecients, 0, testArray, 0, emptySpot);
        this.myPolynomialArray = testArray;
    }

    public int getDegree() {
        for (int a = myPolynomialArray.length - 1; a > 0; a--) {
            int coeffecient = myPolynomialArray[a];
            if (coeffecient != 0) return a;
        }
        return 0;
    }

    public int getCoefficient(int k) {
        if ((k < 0) || (k > myPolynomialArray.length -1)) {
            return 0;
        }
        return myPolynomialArray[k];
    }

    public long evaluate(int x) {
        // Put x in for x in polynomial and add each term to result.
        int result = myPolynomialArray[0];
        for (int a = 1; a < myPolynomialArray.length ; a++) {
            result += myPolynomialArray[a] * Math.pow(x, a);
        }
        return result;
    }

    public Polynomial add(Polynomial other) {
        int[] newCoeffecientArray;
        int compareArrays = Integer.compare(myPolynomialArray.length, other.myPolynomialArray.length);

        // Return 0 if spots are the same.
        if (compareArrays == 0) {
            newCoeffecientArray = new int[myPolynomialArray.length];
            for (int x =0 ; x < myPolynomialArray.length; x++) {
                newCoeffecientArray[x] = other.myPolynomialArray[x] + myPolynomialArray[x];
            }
        } else if (compareArrays > 0) {
            newCoeffecientArray = new int[myPolynomialArray.length];
            for (int x =0 ; x < other.myPolynomialArray.length; x++) {
                newCoeffecientArray[x] = other.myPolynomialArray[x] + myPolynomialArray[x];
            }
            int count = 0;
            for (int x = other.myPolynomialArray.length ; x < myPolynomialArray.length; x++) {
                newCoeffecientArray[other.myPolynomialArray.length + count] = myPolynomialArray[x];
                count++;
            }
        }else {
            newCoeffecientArray = new int[other.myPolynomialArray.length];
            for (int x =0 ; x < myPolynomialArray.length; x++) {
                newCoeffecientArray[x] = other.myPolynomialArray[x] + myPolynomialArray[x];
            }
            int count = 0;
            for (int x = myPolynomialArray.length; x < other.myPolynomialArray.length; x++) {
                newCoeffecientArray[myPolynomialArray.length + count] = other.myPolynomialArray[x];
                count++;
            }
        }
        return new Polynomial(newCoeffecientArray);
    }

    public Polynomial multiply (Polynomial other) {
        int compare = Integer.compare(myPolynomialArray.length, other.myPolynomialArray.length);
        if (compare > 0) {
            return new Polynomial(testMultiply(myPolynomialArray, other.myPolynomialArray));
        }else {
            return new Polynomial(testMultiply(other.myPolynomialArray, myPolynomialArray));
        }
    }

    public int[] testMultiply(int[] big, int[] small) {
        int[] newMultiplcationList = new int[big.length + small.length];
        for (int smallX = 0; smallX < small.length; smallX++) {
            for (int bigX = 0; bigX < big.length; bigX++) {
                newMultiplcationList[smallX + bigX] = (small[smallX] * big[bigX]) + (newMultiplcationList[smallX + bigX]);
            }
        }
        return newMultiplcationList;
    }


    @Override public boolean equals(Object other) {
        if (other instanceof Polynomial) {
            Polynomial otherPoly = (Polynomial) other;
            if (this.compareTo(otherPoly) == 0) {
                return true;
            }
        }
        return false;
    }
    @Override public int hashCode() {
        return Arrays.hashCode(myPolynomialArray);
    }
    public int compareTo(Polynomial other) {
        int[] big, small;
        int isThisLarger = Integer.valueOf(myPolynomialArray.length).compareTo(other.myPolynomialArray.length);
        if (isThisLarger >= 0) {
            big = myPolynomialArray;
            small = other.myPolynomialArray;
        } else {
            big = other.myPolynomialArray;
            small = myPolynomialArray;
        }
        for (int a = big.length -1 ; a > -1; a--) {
            if (a <= small.length -1) {
                if (big[a] > small[a]) {
                    return 1;
                } else {
                    if (big[a] != small[a]) {
                        return -1;
                    }
                }
            } else {
                if (big[a] != 0) {
                    if (big == myPolynomialArray) return 1;
                    return -1;
                } else {
                    if (big == myPolynomialArray) return -1;
                    return 1;
                }
            }
        }
        return 0;
    }
}