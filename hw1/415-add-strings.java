public class Solution {
    // cannot use integer sum convert back; because of limit of integer
    
    public String addStrings(String numOne, String numTwo) {
        if (numOne.length() == 0) return numTwo;
        if (numTwo.length() == 0) return numOne;
        
        int i = numOne.length()-1;
        int j = numTwo.length()-1;
        int carry = 0;
        String result = "";
        while(i>=0 && j>=0) {
            //index of two pointers both greater than zero
            int temp = numOne.charAt(i)-48+numTwo.charAt(j)-48 + carry;
            carry = temp/10;
            result = Integer.toString(temp%10) + result;
            i--;
            j--;
        }
        
        while (i>=0){
            int temp = numOne.charAt(i)-48 + carry;
            carry = temp/10;
            result = Integer.toString(temp%10) + result;
            i--;
        }
        
        while (j>=0){
            int temp = numTwo.charAt(j)-48 + carry;
            carry = temp/10;
            result = Integer.toString(temp%10) + result;
            j--;
        }
        
        if (carry == 1) result = "1" + result;
        
        return result;
    }

}