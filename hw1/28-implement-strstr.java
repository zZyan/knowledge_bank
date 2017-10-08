public class Solution {
    public int strStr(String haystack, String needle) {
        //don't understand kmp algorithms Don't need to understand that at all
        //naive method
        int length = haystack.length();
        int sub = needle.length();
        //edge case
        if (sub == 0) return 0;
        if (length == 0 || sub>length) return -1;

        boolean found = false;


        for (int i = 0; i<=length-sub; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                found = true;
                //compare the rest
                for (int j = 1; j<sub; j++){
                    if (haystack.charAt(i+j) != needle.charAt(j)){
                        found = false;
                        break;
                    }
                }
                if (found) return i;
            }
        }

        return -1;

    }
}
