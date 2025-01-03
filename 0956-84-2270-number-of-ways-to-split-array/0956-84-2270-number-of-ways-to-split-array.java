class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int count = 0;
        long left_sum = 0;
        long right_sum = 0;
        for (int i = 0; i < n-1; i++) {
            left_sum += nums[i];
            right_sum = sum-left_sum;

            if(left_sum >= right_sum) {
                count++;
            }
        }
        return count;
    }
}