// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int a = 0, d =0, count =0, maxPlatforms=0; 
        Arrays.sort(arr); Arrays.sort(dep);
        while(a<arr.length && d<arr.length){
            if(arr[a]<=dep[d]){
                a++;
                count++;
                maxPlatforms = Math.max(maxPlatforms, count);
            }else{
                d++;
                count--;
            }
        }
        return maxPlatforms;
    }
}
