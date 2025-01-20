class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> mp = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], i);
        }

        int minIndex = Integer.MAX_VALUE;

        for (int row = 0; row < m; row++) {
            int lastIdx = Integer.MIN_VALUE;
            for (int col = 0; col < n; col++) {
                int key = mat[row][col];
                int index = mp.get(key);
                lastIdx = Math.max(lastIdx,index);
            }
            minIndex = Math.min(minIndex,lastIdx);
        }

        for (int col = 0; col < n; col++) {
            int lastIdx = Integer.MIN_VALUE;
            for (int row = 0; row < m; row++) {
                int key = mat[row][col];
                int index = mp.get(key);
                lastIdx = Math.max(lastIdx,index);
            }
            minIndex = Math.min(minIndex,lastIdx);
        }

        return minIndex;
    }
}