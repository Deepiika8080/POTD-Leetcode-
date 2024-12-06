class Solution {
    public boolean b_Search(int key,int[] banned) {
        int low = 0;
        int m = banned.length;
        int high = m-1;
        
        int mid;
        while(low<=high) {
            mid = (low + high)/2;
            if(banned[mid] == key) {
                return true;
            }else if(key > banned[mid]) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return false;
    }
    public int maxCount(int[] banned, int n, int maxSum) {
        
         Arrays.sort(banned);
         int sum = 0;
         int count = 0;
        for(int i=1;i<=n;i++) {
            boolean exists = b_Search(i,banned);
            if(!exists && sum + i <= maxSum) {
                sum += i;
                count++;
            }
        }
        return count;
    }
}