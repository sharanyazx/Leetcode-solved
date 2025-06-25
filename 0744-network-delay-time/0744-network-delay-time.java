import java.util.Arrays;

class Solution {


    int minDistance(int[] dist, boolean[] visited, int nodes) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 1; v <= nodes; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    int[][] makeAdjMat(int[][] edges, int nodes) {
        int[][] adjMat = new int[nodes + 1][nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            Arrays.fill(adjMat[i], Integer.MAX_VALUE);
        }

        for (int[] edge : edges) {
            adjMat[edge[0]][edge[1]] = edge[2];
        }
        return adjMat;
    }

    public int networkDelayTime(int[][] edges, int nodes, int currNode) {
        int[][] adjMat = makeAdjMat(edges, nodes);
        boolean[] visited = new boolean[nodes + 1];
        int[] distance = new int[nodes + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[currNode] = 0;

        for (int count = 1; count <= nodes; count++) {
            int u = minDistance(distance, visited, nodes);
            if (u == -1) break; 
            visited[u] = true;

     
            for (int v = 1; v <= nodes; v++) {
                if (!visited[v] && adjMat[u][v] != Integer.MAX_VALUE &&
                    distance[u] != Integer.MAX_VALUE &&
                    distance[u] + adjMat[u][v] < distance[v]) {
                    distance[v] = distance[u] + adjMat[u][v];
                }
            }
        }

        int maxDelay = 0;
        for (int i = 1; i <= nodes; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1; 
            maxDelay = Math.max(maxDelay, distance[i]);
        }

        return maxDelay;
    }
}
