package programmers.p42583;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.stream.Collectors;

public class CrossingBridge {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                2, 10, new int[]{7,4,5,6}));
        System.out.println(solution.solution(
                100, 100, new int[]{100}));
        System.out.println(solution.solution(
                100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge_queue = new ArrayDeque<>(Collections.nCopies(bridge_length, 0));
        Queue<Integer> truck_queue = Arrays.stream(truck_weights)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        int timer = 0;
        int current_bridge_weight = 0;

        while (!bridge_queue.isEmpty()) {
            ++timer;
            int out_truck = bridge_queue.remove();
            current_bridge_weight -= out_truck;

            if (!truck_queue.isEmpty()) {
                if (current_bridge_weight + truck_queue.peek() <= weight) {
                    int truck = truck_queue.remove();
                    bridge_queue.add(truck);
                    current_bridge_weight += truck;
                } else {
                    bridge_queue.add(0); // 0을 활용해 시간 순서를 지킴
                }
            }
        }
        return timer;
    }
}