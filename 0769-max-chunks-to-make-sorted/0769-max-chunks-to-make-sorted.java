class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int currSum = 0;
        int sum = 0;
        int chunksCount = 0;
        
        for(int i=0;i<n;i++) {
            currSum += arr[i];
             sum += i;
            if(currSum == sum) {
                chunksCount++;
            }
        }
        return chunksCount;
    }
}