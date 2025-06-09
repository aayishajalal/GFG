class Solution {
     public int maxSubarraySum(int[] arr) {
        // Your code here
        int res = arr[0], curr = arr[0];
        for(int i=1; i<arr.length; i++){
            curr = Math.max(curr+arr[i], arr[i]);
            res = Math.max(res, curr);
        }
        return res;
    }

}
