public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }

        int one = m-1;
        int two = n-1; 
        int i = m+n-1;
        
        while (i >= 0){
            if (one < 0 ||(two>=0 && (nums2[two] > nums1[one]))){
                nums1[i--] = nums2[two--];
            }
            else {
                nums1[i--] = nums1[one--];
            }
        }
        
    }
}