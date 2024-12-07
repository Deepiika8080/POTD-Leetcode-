class Solution {
    public boolean check(int mid,int maxOperations,int[] nums) {      
        int totOprs = 0;
        for(int num:nums) {
           int opers = num/mid;
           if(num % mid == 0) {
             opers -= 1;  
           }
            totOprs += opers;
        }
        return totOprs <= maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        
        int result = high;
        while(low<=high) {
           int mid = low + (high - low) / 2;
           if(check(mid,maxOperations,nums)) {
               result= mid;
               high = mid-1;
           }else {
               low = mid+1;
           }
        }
        return result;
    }
}