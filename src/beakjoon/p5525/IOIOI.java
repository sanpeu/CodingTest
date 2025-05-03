package beakjoon.p5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    KMP PROBLEM, 5525
    title: IOIOI
 */
public class IOIOI {
    public static String makePattern(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i)
            sb.append("IO");
        sb.append("I");
        return sb.toString();
    }

    public static int[] preprocessing(String pattern) {
        int j = 0, k = -1;
        int[] pi = new int[pattern.length() + 1]; // 아예 틀린 경우 포함
        pi[0] = -1;

        while (j < pattern.length()) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k))
                pi[++j] = ++k;
            else k = pi[k];
        }

        return pi;
    }

    public static int findCount(String str, String pattern) {
        int count = 0;
        int[] pi = preprocessing(pattern);

        int j = 0, k = 0;
        while (j < str.length()) {
            if (k == -1 || str.charAt(j) == pattern.charAt(k)) {
                ++j;
                ++k;
            } else k = pi[k];

            if (k == pattern.length()) {
                ++count;
                k = pi[k];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        String str = reader.readLine();

        String pattern = makePattern(N);

        System.out.println(findCount(str, pattern));
        reader.close();
    }
}
