public class Solution {
    public String minWindow(String s, String t) {
        // scan s
        // match with counter for each char in t, array 
        // track the total count 
        
        int sLen = s.length();
        int tLen = t.length();
        
        if (sLen == 0 ||tLen == 0 || tLen > sLen) return new String();
        
        int [] dict = new int [128];
        
        for (char c: t.toCharArray()){
            dict[c]++;
        }
        
        int head = 0, tail = 0, count = tLen, minLen = Integer.MAX_VALUE, start = 0; 
        
        char[] sChar = s.toCharArray();
        
        while (tail<sLen){
            //move the tail pointer, until first total match
            if (dict[sChar[tail++]]-- > 0) count--;
            
            while (count == 0){
                //record the min length move the head pointer
                if (tail - head <= minLen){
                    System.out.println(minLen);
                    minLen = tail-head;
                    start = head;
                }
                
                if (dict[sChar[head++]]++ == 0) count++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? new String(): new String(sChar, start, minLen);
        
    }
}