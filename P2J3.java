import java.util.*;

public class P2J3 {
    public static void reverseAscendingSubarrays(int[] items){
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int a=0;a<items.length;a++){
            if (temp.size()==0){
                temp.add(items[a]);
            }
            else
            {
                if (items[a]>items[a-1]){
                    temp.add(0,items[a]);  //Add bigger number to beginning of list, already reverse sorted
                } else {
                        result.addAll(temp);
                        temp.clear();
                        temp.add(items[a]);
                }
            }
        }
        result.addAll(temp);
        for(int x=0;x<items.length;x++){ // put them all back in the original array
            items[x]=result.get(x);
        }
    }
    public static String pancakeScramble(String text){
        //str = new StringBuilder(str).reverse().toString();
        String first = "";
        String second = "";
        int endIndex = 2;
        for(int i=0;i<text.length()-1;i++) {
            first = new StringBuilder(text.substring(0,endIndex)).reverse().toString(); //reverse substring
            second = text.substring(endIndex);
            text = first+second;
            endIndex++;
        }
        return text;
    }
    public static String reverseVowels(String text){
        char[] originalText = text.toCharArray();
        char[] newText = text.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>();

        if (originalText.length==0)
                return text;
        for (char c : originalText) {
            if (isaVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.reverse(vowels);
        for(int x=0;x<=originalText.length-1;x++){
            newText[x]=originalText[x];
            if(isaVowel(newText[x])) {
                newText[x] = vowels.get(0);
                vowels.remove(0);

                if(Character.isUpperCase(originalText[x])) {
                    newText[x] = Character.toUpperCase(newText[x]);
                }
                else{
                    newText[x] = Character.toLowerCase(newText[x]);
                }
            }
        }

        return new String(newText);
    }
    public static boolean isaVowel(char ch){
        return ((ch =='a')|| (ch =='e')|| (ch =='i')|| (ch =='o')|| (ch =='u')||(ch =='A')||(ch =='E')||(ch =='I')||(ch =='O')||(ch =='U'));
    }
}
