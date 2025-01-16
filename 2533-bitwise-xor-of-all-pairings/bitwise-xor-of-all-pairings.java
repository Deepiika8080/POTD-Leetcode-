class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int Xor = 0;
        int m = nums1.length;
        int n = nums2.length;

        if (m % 2 != 0) {
            for (int num:nums2) {
                Xor ^= num;
            }
        }

        if (n % 2 != 0) {
            for (int num:nums1) {
                Xor ^= num;
            }
        }

        return Xor;
    }
}