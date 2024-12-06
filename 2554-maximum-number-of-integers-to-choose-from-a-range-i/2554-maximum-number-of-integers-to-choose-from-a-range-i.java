class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Set<Integer> set = new HashSet<Integer>();
        
        // stored the elements in set
        int m = banned.length;
        for(int i=0;i<m;i++) {
            set.add(banned[i]);
        }
        int sum = 0;
        int count = 0;
        for(int i=1;i<=n;i++) {
            if(!set.contains(i) && sum + i <= maxSum ) {
                sum += i; 
                count++; 
            }      
        }
        return count;
    }
}