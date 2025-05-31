package programmers.p49189;

import java.util.*;

class Solution {
    int n;
    List<List<Integer>> neighbors;

    public Solution() {
        neighbors = new ArrayList<>();
    }

    public int solution(int n, int[][] edges) {
        this.n = n;
        for (int i = 0; i <= n; ++i)
            neighbors.add(new ArrayList<>()); // 0은 안씀, 1부터 n까지 사용

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            neighbors.get(a).add(b);
            neighbors.get(b).add(a);
        }

        return getMaxCount(BFS(1));
    }

    private int[] BFS(int start) {
        int[] distances = new int[n+1]; // n까지포함
        Arrays.fill(distances, -1);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int node = u[0], distance = u[1];

            if (distances[node] > -1) continue;
            distances[node] = distance;

            for (Integer neighbor : neighbors.get(node))
                queue.add(new int[]{neighbor, distance+1});
        }
        return distances;
    }

    private int getMaxCount(int[] array) {
        int max = array[0];
        int count = 1; // 0인덱스가 가장 크다고 생각
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
                count = 1;
            } else if (array[i] == max)
                ++count;
        }
        return count;
    }
}

public class maxDistanceNode {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}

