public class Solution {
    public String addBinary(String a, String b) {
        //edge case
        if (a.length()==0) return b;
        if (b.length()==0) return a;

        List<Integer> result = new ArrayList<Integer>();
        int aPt = a.length()-1;
        int bPt = b.length()-1;

        boolean carry = false; // better to use int carry = 0
        int aAdd;
        int bAdd;
        int temp;

        //loop through a and b, if one is zero, add with zero
        while (aPt>=0 || bPt>=0){
            if (aPt<0) aAdd = 0;
            else aAdd = binAt(aPt, a);

            if (bPt<0) bAdd = 0;
            else bAdd = binAt(bPt, b);

            temp = aAdd + bAdd;

            if (carry) {
                carry = false;
                temp+=1;
            }

            if (temp == 2){
                carry = true;
                temp = 0;
            }
            else if (temp == 3) {
                carry = true;
                temp = 1;
            }

            result.add(temp);
            aPt--;
            bPt--;

        }

        if (carry) result.add(1);

        //convert ArrayList to String
        String sResult ="";

        for (Integer i: result){
            sResult = Integer.toString(i) + sResult;
        }

        return sResult;
    }

    public Integer binAt(int index, String s){
        if (s.charAt(index)=='0') return 0;
        else return 1;
    }
}
