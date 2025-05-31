package programmers.p49189;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    List<List<Integer>> neighbor;

    public Solution() {
        neighbor = new ArrayList<>();
    }

    public int solution(int n, int[][] edges) {
        this.n = n;
        for (int i = 0; i <= n; ++i)
            neighbor.add(new ArrayList<>()); // 0은 안씀, 1부터 n까지 사용

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            neighbor.get(a).add(b);
            neighbor.get(b).add(a);
        }

        System.out.println(neighbor);
        return 0;
    }
}

public class maxDistanceNode {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}

