class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] colorCount = new int[n][26]; // n = total nodes, 26 : color(a,b,---z)
        // Creating Adjacency list for the graph, to store the directed graph
        List<List<Integer>> graph = new ArrayList<>();

        // Track incoming edges for topological sort, tp store the number of incoming edges to each node
        int[] indegree = new int[n];

        //Initialze graph structure
        for(int i =0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        // Build graph and indegree array
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        // Topological Sort using Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0) queue.offer(i);
            colorCount[i][colors.charAt(i) - 'a'] =1;
        }
        int visited =0;
        int maxColorValue = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            visited++;
            // update golbal max color frequency
            for(int c =0; c< 26; c++){
                maxColorValue = Math.max(maxColorValue, colorCount[u][c]);
            }

            for(int v : graph.get(u)){
                for(int c =0; c<26; c++){
                    int currentColor = colors.charAt(v)-'a';
                    colorCount[v][c] = Math.max(colorCount[v][c], colorCount[u][c]+ (c== currentColor ?1:0));
                }
                indegree[v]--;
                if(indegree[v] ==0){
                    queue.offer(v);
                }
            }
        }
        return visited == n ? maxColorValue : -1;



    }
}