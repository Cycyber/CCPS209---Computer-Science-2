import java.util.*;

public class P2J4 {
    public static List<Integer> runningMedianOfThree(List<Integer> items)
    {
        if ((items.size()<=2))
            return items;
        else {
            List<Integer> myList = new ArrayList<>();
            myList.add(items.get(0));
            myList.add(items.get(1));

            for (int i = 2; i < items.size(); i++) {
                List<Integer> test = new ArrayList<>();
                test.add(items.get(i));
                test.add(items.get(i-1));
                test.add(items.get(i-2));
                Collections.sort(test);
                myList.add(test.get(1));
            }
            return myList;
        }
    }
    public static int firstMissingPositive(List<Integer> items){
        if (items.size() == 0) {
            return 1;
        }

        for(int i = 0; i < items.size(); i++) {
            int startValue = items.get(i);
            while(startValue > 0 && startValue <= items.size() && startValue != items.get(startValue - 1)) {
                int tmp = items.get(startValue - 1);
                items.set(startValue - 1, startValue);
                startValue = tmp;
            }
        }

        int result = 1;
        for (Integer item : items) {
            if (item > 0 && item == result) {
                result++;
            }
        }
        return result;
    }
    public static void sortByElementFrequency(List<Integer> items){
        TreeMap<Integer,Integer> myMap = new TreeMap<>();
        for(int i : items)
        {
            if(myMap.containsKey(i))
            {myMap.put(i,myMap.get(i)+1);}
            else  {myMap.put(i,1);}
        }
        ArrayList<Integer> theList = new ArrayList<>();
        var toSort = new ArrayList<Map.Entry<Integer, Integer>>(myMap.entrySet());
        toSort.sort((k1, k2) -> -k1.getValue().compareTo(k2.getValue()));
        for (Map.Entry<Integer, Integer> e : toSort) {
            for (int i = 0; i < e.getValue(); i++) {
                theList.add(e.getKey());
            }
        }
        for(int a=0;a<theList.size();a++){
            items.set(a, theList.get(a));
        }
    }
    public static List<Integer> factorFactorial(int n){
        List<Integer> factorList = new ArrayList<Integer>();
        for(int i=2;i<=n;i++){
            addFactors(i,factorList);
        }
        Collections.sort(factorList);
        return factorList;
    }
    public static void addFactors(int x, List<Integer> list){
        while((x % 2) == 0){
            list.add(2);
            x/=2;
        }
        for(int i=3;i<=x;i+=2){
            while(x%i==0){
                list.add(i);
                x/=i;
            }
        }
        if(x>1)
            list.add(x);
    }
}
