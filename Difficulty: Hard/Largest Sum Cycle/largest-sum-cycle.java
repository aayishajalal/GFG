//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        
out.println("~");
}
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    Stack<Integer> st; // Stack to store nodes in reverse order of their finishing times
    boolean visited[]; // Array to track visited nodes
    ArrayList<Integer> l[], l_[]; // Adjacency lists for the graph and its transpose

    void dfs1(int node){
        visited[node] = true;
        // Traverse all adjacent nodes and recursively call dfs1 for unvisited nodes
        for(int kid : l[node]){
            if(visited[kid])
                continue;
            dfs1(kid);
        }
        // Add the node to the stack after finishing all its children
        st.add(node);
    }
    
    void dfs2(int node, ArrayList<Integer> li){
        visited[node] = true;
        // Traverse all adjacent nodes in the transpose graph and recursively call dfs2 for unvisited nodes
        for(int kid : l_[node]){
            if(visited[kid])
                continue;
            dfs2(kid, li);
        }
        // Add the node to the result list after finishing all its children
        li.add(node);
    }
    
    public long largesSumCycle(int N, int Edge[]){
        long res = -1l;
        st = new Stack<>(); // Initialize the stack to store nodes
        visited = new boolean[N]; // Initialize the visited array

        l = new ArrayList[N]; l_ = new ArrayList[N]; // Create adjacency lists for the graph and its transpose
        for(int i = 0; i < N; i++){
            l[i] = new ArrayList<>();
            l_[i] = new ArrayList<>();
        } 

        // Build the adjacency lists for the graph and its transpose
        for(int i = 0; i < N; i++){
            int u = i, v = Edge[i];
            if(v == -1)
                continue;
            l[u].add(v);
            l_[v].add(u);
        }

        // Perform the first DFS to get the finishing times of all nodes
        for(int i = 0; i < N; i++){
            if(visited[i])
                continue;
            dfs1(i);
        }

        Arrays.fill(visited, false); // Reset the visited array

        // Process the nodes in reverse order of their finishing times
        while(!st.isEmpty()){
            int node = st.pop();
            if(visited[node])
                continue;
            ArrayList<Integer> li = new ArrayList<>(); // List to store nodes in the strongly connected component
            dfs2(node, li);

            if(li.size() <= 1) // Skip components with size 0 or 1, as they cannot form a cycle
                continue;

            long sum = 0l;
            // Calculate the sum of the nodes in the strongly connected component
            for(int x : li)
                sum += (x * 1l);
            res = Math.max(sum, res); // Update the result if the sum is larger
        }
        
        return res;
    }
}