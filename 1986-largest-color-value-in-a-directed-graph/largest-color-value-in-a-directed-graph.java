class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] colorCount = new int[n][26]; // Track count of each color (a-z) at each node
        List<List<Integer>> graph = new ArrayList<>(); // Adjacency list for the graph
        int[] indegree = new int[n]; // Track incoming edges for topological sort

        // Initialize graph structure
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and indegree array
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        // Topological Sort using Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i); // Start with nodes having no incoming edges
            colorCount[i][colors.charAt(i) - 'a'] = 1; // Initialize color count for each node
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;

            // Update global max color frequency
            for (int c = 0; c < 26; c++) {
                maxColorValue = Math.max(maxColorValue, colorCount[u][c]);
            }

            // Traverse all neighbors
            for (int v : graph.get(u)) {
                for (int c = 0; c < 26; c++) {
                    int currentColor = colors.charAt(v) - 'a';
                    // Propagate the max count of each color
                    colorCount[v][c] = Math.max(colorCount[v][c], 
                        colorCount[u][c] + (c == currentColor ? 1 : 0));
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // If not all nodes were visited, graph has a cycle
        return visited == n ? maxColorValue : -1;
    }
}
