package programmers.p12929;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int count = 0;
    public void solution(int n, List<Integer> list) {
        if (n == 0) {
            ++count;
            return;
        }

        int pre = list.isEmpty() ? 0 : list.getLast();
        for (int i = pre+1; i >= 1; --i) {
            list.add(i);
            solution(n-1, list);
            list.removeLast();
        }
    }

    public int solution(int n) {
        solution(n, new ArrayList<>());
        return 0;
    }
}

public class CorrectBrackets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }
}
