class Solution {
    public long gridGame(int[][] grid) {
        long firstRwRemSum = 0;
        long secondRowRemSum = 0;

        for(int num:grid[0]) {
          firstRwRemSum += num;                                                                
        }
        
        long minismisedRobot2Sum = Long.MAX_VALUE;
        for(int col=0;col<grid[0].length;col++) {
            // robot1 tooks points
            firstRwRemSum -= grid[0][col];

            long bestOfRobot2 = Math.max(firstRwRemSum, secondRowRemSum);

            minismisedRobot2Sum = Math.min(minismisedRobot2Sum , bestOfRobot2);

            secondRowRemSum += grid[1][col];
        }

        return minismisedRobot2Sum;
    }
}