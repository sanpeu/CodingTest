package programmers.p1845;
import java.util.Set;
import java.util.HashSet;

public class Ponkemon {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3,3,3,2,2,4};
        System.out.println(s.solution(arr));
    }
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (var num: nums) set.add(num);
        answer = (nums.length/2 < set.size()) ? nums.length/2 : set.size();

        return answer;
    }
}