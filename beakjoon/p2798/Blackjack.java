package beakjoon.p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Blackjack {
    public static int getSum(
            int[] cards,
            int index,
            List<Integer> selected,
            int M,
            int maxSum) {
        
        int currentSum = 0;
        if (selected.size() == 3) {
            for (Integer card: selected)
                currentSum += card;
            if (currentSum <= M && currentSum > maxSum)
                return currentSum;
            return maxSum;
        }
        if (selected.size() + cards.length - index < 3) return maxSum;

        selected.add(cards[index]);
        currentSum = getSum(cards, index+1, selected, M, maxSum);
        if (currentSum <= M && currentSum > maxSum) maxSum = currentSum;

        selected.remove(selected.size()-1);
        currentSum = getSum(cards, index+1, selected, M, maxSum);
        if (currentSum <= M && currentSum > maxSum) maxSum = currentSum;

        return maxSum;
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

        System.out.println(getSum(cards, 0, new ArrayList<>(), M, 0));
    }
}
