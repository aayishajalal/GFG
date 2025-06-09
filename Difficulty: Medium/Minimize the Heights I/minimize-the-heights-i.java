class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];  // initial difference
        int minElem = 0;
        int maxElem = 0;
    
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            minElem = Math.min(smallest, arr[i + 1] - k);
            maxElem = Math.max(largest, arr[i] + k);

            // if (minElem < 0) continue; // skip if negative height
         
            ans = Math.min(ans, maxElem - minElem);
            
        }
        // int ans = maxElem - minElem;
        return ans;
    }
}