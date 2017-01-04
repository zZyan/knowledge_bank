public class Solution {
    public int myAtoi(String str) {
        
        //edge case
        if (str.length()==0) return 0;
        
        boolean pos = true;
        
        //trim the whitespace
        str = str.trim();
        double result = 0;
        
        //sign
        for (int i = 0; i<str.length(); i++){
            if (str.charAt(i) == '-' && i == 0){
                
                pos = false; 
                continue; 
            }
            
            else if(str.charAt(i) == '+' && i == 0) continue;

            int num = indAtoi(str.charAt(i));
            System.out.println(num);
            if (num == -1) break;
            
            //calculate the number
            result = result*10+num;
            System.out.println(result);
        }
        
        if (!pos) {
            result = -result;
        }
        
        //edge case, range of integer
        if (result>Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        else if (result<Integer.MIN_VALUE) result = Integer.MIN_VALUE;
        
        return (int)result;
    }
    
    //from Char in ASCii, get corresponding integer
    public int indAtoi(char c){
        if (c >='0' && c<='9'){
            return c-48;
        }
        return -1; 
    } 
}