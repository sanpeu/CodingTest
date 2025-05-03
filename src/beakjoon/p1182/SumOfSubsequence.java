package beakjoon.p1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSubsequence {
    static int count = 0;
    public static void findNumberInSubsequence(int[] numbers, int index, int targetSum, int currentSum, boolean isContains) {
//        if (isContains && currentSum == targetSum)
//            ++count;
        if (index == numbers.length) {
            if (isContains && currentSum == targetSum)
                ++count;
            return;
            }

        findNumberInSubsequence(numbers, index+1, targetSum, currentSum + numbers[index], true);
        findNumberInSubsequence(numbers, index+1, targetSum, currentSum, isContains);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        reader.close();

        int[] numbers = new int[N];
        for (int i = 0; i < N; ++i)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());

        findNumberInSubsequence(numbers, 0, S, 0, false);
        System.out.println(count);
    }
}
