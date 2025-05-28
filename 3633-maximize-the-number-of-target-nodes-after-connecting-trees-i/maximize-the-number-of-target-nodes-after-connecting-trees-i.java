import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        // Precompute the maximum number of nodes reachable within k - 1 in Tree 2
        int maxReachTree2 = 0;
        if (k > 0) {
            for (int i = 0; i < m; i++) {
                int reach = bfs(tree2, i, k - 1);
                maxReachTree2 = Math.max(maxReachTree2, reach);
            }
        }

        // For each node in Tree 1, compute the number of nodes reachable within k
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int reach = bfs(tree1, i, k);
            result[i] = reach + maxReachTree2;
        }

        return result;
    }

    private List<List<Integer>> buildTree(int size, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    private int bfs(List<List<Integer>> graph, int start, int maxDepth) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.add(start);
        visited[start] = true;
        int depth = 0;
        int count = 0;

        while (!queue.isEmpty() && depth <= maxDepth) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            depth++;
        }

        return count;
    }
}
