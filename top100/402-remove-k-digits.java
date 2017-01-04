/*
keep the smallest elements
use stack to save
push 
    empty
    all the bigger ones are removes, the remaining
pop

    
*/

public class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (k == num.length()) return "0";
        
        Deque<Character> stack = new ArrayDeque<Character>();
        
        int i = 0;
        while (i<num.length()){
            while (!stack.isEmpty() && k>0 && stack.peekLast() > num.charAt(i)){
                stack.pollLast();
                k--;
            }
            
            stack.offerLast(num.charAt(i));
            i++;
            
        }
        
        while (k>0){
            stack.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c: stack){
            sb.append(c);
        }
        
        String res = sb.toString();
        for (int j = 0; j<res.length(); j++){
            if (res.charAt(j) != '0'){
                return res.substring(j,res.length());
            }
        }
        
        return "0";
    }
}