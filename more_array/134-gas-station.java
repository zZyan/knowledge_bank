public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 0) {
            return -1;
        }
        
        //keep the running sum of gas-cost
        int total = 0;
        //if previously accumulated sum<0; update the starting station
        int subTotal = 0;
        int index = 0;
        for (int i = 0; i<n; i++){
            total += gas[i] - cost[i];
            subTotal += gas[i] - cost[i];
            
            if(subTotal < 0){
                index = i+1;
                subTotal = 0;
            }    
        }
        
        if (total < 0){
            return -1;
        }
        else{
            return index;
        }
    }
}