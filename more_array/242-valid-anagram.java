public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        if (s.length() == 0 || s.equals(t)){
            return true;
        }
        
        //use 128 int arrays to count
        int[] counts = new int[128];
        
        for (int i = 0; i< s.length(); i++){
            counts[s.charAt(i)]++;
        }
        
        for (int i = 0; i< t.length(); i++){
            counts[t.charAt(i)]--;
        }
        
        for (int i: counts){
            if (i != 0){
                return false;
            }
        }
        
        return true;
    }
}