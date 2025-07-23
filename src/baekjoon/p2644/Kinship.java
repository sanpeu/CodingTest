package baekjoon.p2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Kinship {
    List<List<Integer>> kinship;

    public Kinship(int N, int[][] edges, int start, int goal) {
        kinship = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
            kinship.add(new ArrayList<Integer>()); // 1부터 시작

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            kinship.get(a).add(b);
            kinship.get(b).add(a);
        }

        System.out.println(BFS(start, goal));
    }

    private int BFS(int start, int goal) {
        boolean[] visited = new boolean[kinship.size()];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()) {
            int[] u = queue.remove();
            int node = u[0], distance = u[1];

            if (visited[node]) continue;
            visited[node] = true;

            if (node == goal) return distance;
            for (Integer v : kinship.get(node))
                queue.add(new int[] {v, distance+1});
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int start = Integer.parseInt(tokenizer.nextToken());
        int goal = Integer.parseInt(tokenizer.nextToken());

        int numberOfEdges = Integer.parseInt(reader.readLine());
        int[][] edges = new int[numberOfEdges][];

        for (int i = 0; i < numberOfEdges; ++i) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int c = Integer.parseInt(tokenizer.nextToken());
            int p = Integer.parseInt(tokenizer.nextToken());
            edges[i] = new int[]{c, p};
        }
        reader.close();

//        int N = 7;
//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {2, 4},
//                {2, 5}, {3, 6}, {4, 5}, {4, 6}, {6, 7}};
        new Kinship(N, edges, start, goal);
    }
}
