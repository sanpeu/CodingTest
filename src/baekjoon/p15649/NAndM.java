package baekjoon.p15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM {
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();

    public static void printSequence(int index, int N, int M) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                sb.append(sequence[i]).append(" ");
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            int finalI = i;
            if (Arrays.stream(sequence)
                    .noneMatch(j -> j == finalI)) {
                sequence[index] = i;
                printSequence(index + 1, N, M);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        sequence = new int[M];
        reader.close();
        printSequence(0, N, M);
        System.out.print(sb);
    }
}