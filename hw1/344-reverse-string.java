public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        
        int length = s.length();
        if (length == 0 || length == 1) return s;
        // time limit exceed
        // for (int i = 0; i < length; i++){
        //     result = s.charAt(i) + result;
        // }
        
        for (int i = length - 1; i>=0; i--){
            //append
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}