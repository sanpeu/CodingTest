package beakjoon.p1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    public static void balanceQueue(PriorityQueue smallerHeap, PriorityQueue biggerHeap) {
        // smaller만 너무 커지는 것 조절
        while (smallerHeap.size() - biggerHeap.size() > 1)
            biggerHeap.offer(smallerHeap.poll());

        // 항상 smallerHeap이 bigger보다 1개 크거나 같아야함.
        while (biggerHeap.size() - smallerHeap.size() >= 1)
            smallerHeap.offer(biggerHeap.poll());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Integer[] numbers = new Integer[N];

        PriorityQueue<Integer> biggerHeap = new PriorityQueue<>();
        PriorityQueue<Integer> smallerHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; ++i)
            numbers[i] = Integer.parseInt(reader.readLine());
        reader.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            if (!smallerHeap.isEmpty() && numbers[i] > smallerHeap.peek())
                biggerHeap.offer(numbers[i]);
            else
                smallerHeap.offer(numbers[i]);

            balanceQueue(smallerHeap, biggerHeap);
            sb.append(smallerHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
