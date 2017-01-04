public class Solution {
    //split the string, append reversely, connect back

    public String reverseWords(String s) {
        String result = "";
        if (s.length() == 0) return result;
        for (String word: s.split(" "){
            result = word + " " + result;
        }
        
        return result;
    }
}