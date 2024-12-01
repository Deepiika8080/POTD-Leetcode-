class Solution {
      private boolean binarySearch(int[] arr, int target, int excludeIndex) {
        int l = 0, h = arr.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] == target && mid != excludeIndex) {
                return true;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return false;
    }
    public boolean checkIfExist(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int target = 2 * arr[i];

            if (binarySearch(arr, target, i)) {
                return true;
            }
        }
        return false;
    }
}