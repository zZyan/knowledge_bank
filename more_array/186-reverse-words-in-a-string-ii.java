public class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        if (n == 0) {
            return;
        }
        
        //reverse the word one by one
        //reverse the entire string
        int i = 0;
        for (int j = 0; j<n; j++){
            if (s[j] == ' '){
                //reverse the word
                reverse(s, i, j-1);
                i = j+1;
            }
        }
        reverse(s, i, n-1);
        reverse(s, 0, n-1);
    }
    
    public void reverse(char[] s, int i, int j){
        if (i == j){
            return;
        }
        
        while (i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}