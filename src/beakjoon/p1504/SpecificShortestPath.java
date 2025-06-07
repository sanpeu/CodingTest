package beakjoon.p1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecificShortestPath {
    List<List<int[]>> edges;

    public SpecificShortestPath(List<List<int[]>> edges) {
        this.edges = edges;

        System.out.println(BFS(1, 4));
    }

    private int BFS(int start, int goal) {
        boolean[] visited = new boolean[edges.size()];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int node = u[0];
            int cost = u[1];

            if (node == goal) return cost;

            for (int[] edge : edges.get(node)) {
                int nextNode = edge[0];
                int nextCost = edge[1];
                if (!visited[nextNode]) {
                    queue.add(new int[]{nextNode, cost + nextCost});
                    visited[nextNode] = true;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());

        List<List<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
            edges.add(new ArrayList<>());

        for (int i = 0; i < E; ++i) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());

            edges.get(a).add(new int[]{b, cost});
            edges.get(b).add(new int[]{a, cost});
        }

//        for (int i = 0; i < edges.size(); ++i) {
//            System.out.print(i + " -> ");
//            for (int[] edge : edges.get(i))
//                System.out.print(Arrays.toString(edge) + " ");
//            System.out.println();
//        }
        reader.close();

        new SpecificShortestPath(edges);
    }
}
