//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
       //calc -> curLen, maxLen, sum
       int sum = 0, curLen=0, maxLen=0;
       //prefix Map
       Map<Integer, Integer> prefixMap = new HashMap<>();
       //compute sum for entire array say x
       for(int i=0; i<arr.length; i++){
           sum +=arr[i];
           
           if(sum==k){
               maxLen = Math.max(maxLen, i+1);
           }

       //compute x-k
       int rem = sum-k;
       //find whether contains rem value
       if(prefixMap.containsKey(rem)){
           curLen = i-prefixMap.get(rem);
           maxLen = Math.max(maxLen, curLen);
       }
       //not contains inkey then add sum,i to map
       if(!prefixMap.containsKey(sum)){
           prefixMap.put(sum,i);
       }
       }
       return maxLen;
    }
}
