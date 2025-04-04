package beakjoon.p5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    AUTOMATA PROBLEM, 5525
    title: IOIOI
 */
public class IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        String str = reader.readLine();

        int stateLength = 2*N + 2;
        final int I = 0, O = 1;
        int[][] automata = new int[2][stateLength];
        for (int i = 0; i < stateLength; ++i) {
            automata[I][i] = 1;
            automata[O][i] = 0;

            if (i%2 == 0)
                automata[I][i] = i + 1;
            else
                automata[O][i] = i + 1;
        }
        automata[O][stateLength-1] = 2*N; // 2*N이 마지막 상태(완성)의 전 상태

        // 밑에는 고정
        int count = 0;
        int state = 0;
        for (int i = 0; i < M; ++i) {
            switch (str.charAt(i)) {
                case 'I': state = automata[I][state]; break;
                case 'O': state = automata[O][state]; break;
            }
            if (state == 2*N + 1) ++count;
        }

        System.out.println(count);
    }
}
