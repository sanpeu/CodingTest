package programmers.p42583;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

public class CrossingBridge {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                2, 10, new int[]{7,4,5,6}));
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge_queue = new ArrayDeque<>();
        Queue<Integer> truck_queue = Arrays.stream(truck_weights)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        int timer = 0;
        int current_bridge_weight = 0;

        while(!truck_queue.isEmpty()) {
            ++timer;
            if (bridge_queue.size() <= bridge_length) {
                if (current_bridge_weight + truck_queue.peek() <= weight) {
                    int current_truck = truck_queue.remove();
                    current_bridge_weight += current_truck;
                    bridge_queue.add(current_truck);
                }
            }
            if (!bridge_queue.isEmpty()) {
                current_bridge_weight -= bridge_queue.remove();
                timer += bridge_length;
            }
        }
        return timer;
    }
}