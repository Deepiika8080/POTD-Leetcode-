class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxSoFar = 0;
        int chunksCount = 0;
        
        for(int i=0;i<n;i++) {
           maxSoFar = Math.max(maxSoFar, arr[i]);
         
            if(i == maxSoFar) {
                chunksCount++;
            }
        }
        return chunksCount;
    }
}