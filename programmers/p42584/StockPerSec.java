package programmers.p42584;

import java.util.Arrays;

public class StockPerSec {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]
                {1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution.solution(new int[]
                {3, 4, 1})));
        System.out.println(Arrays.toString(solution.solution(new int[]
                {3, 1, 1})));
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length-1; ++i) { // 마지막은 무조건 0
            for (int j = i+1; j < prices.length; ++j) {
                answer[i] += 1;
                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}
