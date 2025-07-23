package baekjoon.p2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoyoungsDeliciousFood {
    int N;
    int minDiff;
    int[][] data;

    public DoyoungsDeliciousFood(int N, int[][] data) {
        this.N = N;
        this.minDiff = Integer.MAX_VALUE;
        this.data = data;

        DFS(0, 1, 0, false);
        System.out.println(minDiff);
    }

    private void DFS(int depth, int sour, int bitter, boolean checker) {
        if (depth == N) {
            if (checker) {
                int correctDiff = Math.abs(sour - bitter);
                minDiff = Math.min(correctDiff, minDiff);
            }
            return;
        }

        int correctSour = data[depth][0];
        int correctBitter = data[depth][1];
        DFS(depth+1, sour*correctSour, bitter+correctBitter, true);
        DFS(depth+1, sour, bitter, checker);
    }

    public static void main(String[] args) throws IOException {
//        new DoyoungsDeliciousFood(1, new int[][]{{3, 10}});
//        new DoyoungsDeliciousFood(2, new int[][]{{3, 8}, {5, 8}});
//        new DoyoungsDeliciousFood(4, new int[][]{{1, 7}, {2, 6}, {3, 8}, {4, 9}});
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int data[][] = new int[N][2];
        for (int i = 0; i < N; ++i) {
            String[] strings = reader.readLine().split(" ");
            data[i][0] = Integer.parseInt(strings[0]);
            data[i][1] = Integer.parseInt(strings[1]);
        }

        new DoyoungsDeliciousFood(N, data);
        reader.close();
    }
}
