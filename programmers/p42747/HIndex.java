package programmers.p42747;
import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution.solution(new int[]{100, 100}));
        System.out.println(solution.solution(new int[]{4, 4, 4, 5, 5, 5, 5, 6}));
    }
}

class Solution {
    public int solution(int[] citations) {
        int h = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] >= citations.length-i)
                h = Math.max(citations.length - i, h);
        }
        return h;
    }
}
