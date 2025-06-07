package beakjoon.p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    int[][] map;
    int[][] move;
    int ROW;
    int COLUMN;

    public Tomato(int[][] map) {
        this.map = map;
        move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // 상하좌우
        ROW = map.length;
        COLUMN = map[0].length;
    }

    public int BFS() {
        boolean[][] visited = new boolean[ROW][COLUMN];
        Queue<int[]> queue = new ArrayDeque<>();
        int unripeTomatoes = 0;

        for (int r = 0; r < ROW; ++r) {
            for (int c = 0; c < COLUMN; ++c) {
                if (map[r][c] == 1) {
                    queue.add(new int[]{r, c, 0});
                    visited[r][c] = true;
                } else if (map[r][c] == 0)
                    ++unripeTomatoes;
            }
        }

        if (unripeTomatoes == 0)
            return 0;

        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int r = u[0], c = u[1];
            int day = u[2];

            if(map[r][c] == 0)
                --unripeTomatoes;
            if (unripeTomatoes == 0)
                return day;

            for (int[] m: move) {
                int rMove = r + m[0], cMove = c + m[1];
                if (rMove >= 0 && rMove <= ROW-1 && cMove >= 0 && cMove <= COLUMN-1) {
                    if (!visited[rMove][cMove] && map[rMove][cMove] == 0) {
                        queue.add(new int[]{rMove, cMove, day+1});
                        visited[rMove][cMove] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int COLUMN = Integer.parseInt(tokenizer.nextToken());
        int ROW = Integer.parseInt(tokenizer.nextToken());
        int[][] tomatoFarm = new int[ROW][COLUMN];

        for (int i = 0; i < ROW; ++i) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int col = 0;
            while (tokenizer.hasMoreTokens())
                tomatoFarm[i][col++] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(new Tomato(tomatoFarm).BFS());
//        System.out.println(Arrays.deepToString(tomatoFarm));
    }
}
