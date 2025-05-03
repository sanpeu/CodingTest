package programmers.p42584;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        int count;

        for (int i = 0; i < prices.length-1; ++i) { // 마지막은 무조건 0
            count = 0;
            for (int j = i+1; j < prices.length; ++j) {
                ++count;
                if (prices[i] > prices[j]) break;
            }
            list.add(count);
        }
        list.add(0);

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
