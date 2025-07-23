package baekjoon.p1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WallBreaking {
    char[][] map;
    int ROW;
    int COLUMN;
    int[][] MOVE;

    public WallBreaking(char[][] map, int ROW, int COLUMN) {
        this.map = map;
        this.ROW = ROW;
        this.COLUMN = COLUMN;
        MOVE = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        System.out.println(BFS());
    }

    private int BFS() {
        boolean[][] visited = new boolean[ROW][COLUMN];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.add(new int[]{0, 0, 0}); // 0,0은 무조건 빈 방
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] u = queue.remove();
            int row = u[0], column = u[1];
            int wallBreakingCount = u[2];

            if (row == ROW-1 && column == COLUMN-1)
                return wallBreakingCount;

            for(int[] move : MOVE) {
                int nextRow = row + move[0];
                int nextColumn = column + move[1];
                if (nextRow >= 0 && nextColumn >= 0 && nextRow < ROW && nextColumn < COLUMN) {
                    if (!visited[nextRow][nextColumn]) {
                        int breaking = map[nextRow][nextColumn] == '0' ? 0 : 1;
                        queue.add(new int[]{nextRow, nextColumn,
                                wallBreakingCount+breaking});
                        visited[nextRow][nextColumn] = true;
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
        char[][] map = new char[ROW][];

        for (int i = 0; i < ROW; ++i) {
            String line = reader.readLine();
            map[i] = line.toCharArray();
        }

        new WallBreaking(map, ROW, COLUMN);
    }
}
