package beakjoon.p1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SpecificShortestPath {
    List<List<Integer>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());

        List<List<int[]>> edges = new ArrayList<>();
        for (int i = 0; i < N; ++i)
            edges.add(new ArrayList<>());

        for (int i = 0; i < E; ++i) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());

            edges.get(a).add(new int[]{b, cost});
            edges.get(b).add(new int[]{a, cost});
        }

        System.out.println(edges);
        reader.close();
    }
}
