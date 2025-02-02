//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int exits[] = new int[n];
            for (int i = 0; i < n; i++) exits[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            System.out.println(sln.maxWeightCell(exits));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxWeightCell(int[] exits) {
        int result=0;
        int ans=Integer.MIN_VALUE;
        int[] temp=new int[exits.length];
        Arrays.fill(temp,0);
        for(int i=0;i<exits.length;i++){
            int source=i;
            int dest=exits[i];
            if(dest !=-1){
                temp[dest]+=source;
                if(ans<=temp[dest]){
                    ans=Math.max(ans,temp[dest]);
                    result=dest;
                }
            }
       }
       return ans !=Integer.MIN_VALUE? result:0;
    }
}