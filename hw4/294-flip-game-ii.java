/*
count number of consecutive ++, 
*/

public class Solution {
    public boolean canWin(String s) {
        int len = s.length();
        
        if (len < 2){
            return false;
        }
        
        //simulate the game;
        return canWinHelper(s.toCharArray());
    }
    
    public boolean canWinHelper(char[] array){
        for (int i = 1; i<array.length; i++){
            if (array[i] == '+' && array[i-1] == '+'){
                array[i] = '-';
                array[i-1] = '-';
                
                boolean win = canWinHelper(array);
                
                array[i] = '+';
                array[i-1] = '+';
                //any combination that make the other mover lose, win
                if (!win){
                    return true;
                }
            }
            
        }
        
        return false;
    }
}