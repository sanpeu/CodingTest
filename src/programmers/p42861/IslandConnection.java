package programmers.p42861;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class IslandConnection {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }
}

class Solution {
    List<List<int[]>> edges;

    public Solution() {
        edges = new ArrayList<>();
    }

    public int solution(int n, int[][] costs) {
        for (int i = 0; i < n; ++i)
            edges.add(new ArrayList<>());

        int min = Integer.MAX_VALUE;
        int startNode = 0;

        for (int[] cost: costs) {
            int a = cost[0], b = cost[1];
            int c = cost[2];

            edges.get(a).add(new int[]{b, c});
            edges.get(b).add(new int[]{a, c});

            if (min > c) {
                min = c;
                startNode = a;
            }
        }

//        for (int i = 0; i < edges.size(); ++i) {
//            System.out.print(i + ": ");
//            for (int[] edge: edges.get(i)) {
//                System.out.print(Arrays.toString(edge));
//            }
//            System.out.println();
//        }
        return prim(startNode);
    }

    private int prim(int startNode) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[edges.size()];
        queue.add(new int[]{startNode, 0});

        int totalCost = 0;

        while(!queue.isEmpty()) {
            int[] q = queue.remove();
            int currentNode = q[0];
            int currentCost = q[1];

            if (visited[currentNode]) continue;
            visited[currentNode] = true;
            totalCost += currentCost;

            for (int[] edge: edges.get(currentNode)) {
                int nextNode = edge[0];

                if (!visited[nextNode])
                    queue.add(edge);
            }
        }

        return totalCost;
    }
}