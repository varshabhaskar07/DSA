class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        // Fill distances from node1 and node2
        fillDistances(edges, node1, dist1);
        fillDistances(edges, node2, dist2);
        
        int minDistance = Integer.MAX_VALUE;
        int result = -1;

        // Find the node with the smallest maximum distance
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }

    private void fillDistances(int[] edges, int start, int[] dist) {
        Arrays.fill(dist, -1);
        int current = start;
        int distance = 0;
        while (current != -1 && dist[current] == -1) {
            dist[current] = distance;
            current = edges[current];
            distance++;
        }
    }
}
