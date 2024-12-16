class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int valueComparision = Integer.compare(a[0] , b[0]);
            if(valueComparision == 0) {
                return Integer.compare(a[1] , b[1]);
            }
            return valueComparision;
        });
        
        for(int i = 0 ;i<n;i++) {
            pq.offer(new int[] {nums[i],i});
        }
        
        for(int opers = 0;opers < k;opers++) {
            int element[] = pq.poll();
            int num = element[0];
            int idx = element[1];
            int newNum = num * multiplier;
            pq.offer( new int[] {newNum,idx});
            nums[idx] = newNum;
        }
        
        return nums;
    }
}