package programmers.p42626;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
    Hotter Programmers 42626
    title: 더 맵게
 */
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                Arrays.stream(scoville)
                .boxed()
                .collect(Collectors.toList()));

        try {
            while (heap.peek() < K) {
                int mixed = heap.remove() + heap.remove()*2;
                heap.offer(mixed);
                ++answer;
            }
        } catch(Exception e) {
            answer = -1;
        }

        return answer;
    }
}

public class Hotter {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution.solution(new int[]{10, 15, 20}, 7));
        System.out.println(solution.solution(new int[]{1, 1, 1, 1}, 10));
        System.out.println(solution.solution(new int[]{0, 0, 0, 0}, 7));
        System.out.println(solution.solution(new int[]{1, 2}, 10));
    }
}
