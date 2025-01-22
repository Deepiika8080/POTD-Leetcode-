class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> q = new LinkedList<>();
        int heights[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    heights[i][j] = 0;
                    q.offer(new int[] {i,j});
                } else {
                    heights[i][j] = -1;
                } 
            }
        }
        int dirs[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
              int curr[] = q.poll();
              int row = curr[0];
              int col = curr[1];

              for(int dir[]:dirs) {
                int newRow = row+dir[0];
                int newCol = col+dir[1];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] == -1) {
                     heights[newRow][newCol] = heights[row][col]+1;
                      q.offer(new int[] {newRow,newCol});
                }
              }
            }        
        }

        return heights;
    }
}