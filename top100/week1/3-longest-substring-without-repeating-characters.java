public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //corner case
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        // check for repetition
        int[] charMap = new int[128];
        int start = 0;
        int end = 0;
        int max = -1;
        char[] cArray = s.toCharArray();
        while (end < cArray.length){
            while (charMap[cArray[end]]>0){
                charMap[cArray[start++]]--;
            }
            
            charMap[cArray[end++]]++;
            max = Math.max(max, end-start);
        }
        
        return max;
        
    }
}