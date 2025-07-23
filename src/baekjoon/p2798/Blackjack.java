package baekjoon.p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blackjack {
    public static int findMaxSum(int[] cards, int M, int startIndex, int count, int currentSum) {
        int N = cards.length; // N은 배열 길이로 얻음

        if (currentSum > M)
            return 0;
        if (count == 3)
            return currentSum;
        if (N - startIndex < 3 - count)
            return 0;

        int maxFound = 0; // 현재 재귀 호출 레벨에서 찾은 최대 합
        for (int i = startIndex; i < N; i++) {
            int resultFromBranch = findMaxSum(cards, M, i + 1, count + 1, currentSum + cards[i]);
            maxFound = Math.max(maxFound, resultFromBranch);
        }

        return maxFound;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        String cardLines = reader.readLine();
        tokenizer = new StringTokenizer(cardLines, " ");
        int[] cards = new int[N];
        for (int i = 0; i < N; ++i)
            cards[i] = Integer.parseInt(tokenizer.nextToken());
        reader.close();

        System.out.println(findMaxSum(cards, M, 0, 0, 0));
    }
}
