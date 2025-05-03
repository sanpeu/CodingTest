package beakjoon.p1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    beakjoon p1655
    min heap, max heap
 */

public class MedianFinder {
    public static void balanceQueue(
            PriorityQueue<Integer> smallerHeap,
            PriorityQueue<Integer> biggerHeap
    ) {
        // smaller만 너무 커지는 것 조절
        while (smallerHeap.size() - biggerHeap.size() > 1)
            biggerHeap.offer(smallerHeap.poll());

        // 항상 smallerHeap이 bigger보다 1개 크거나 같아야함.
        while (biggerHeap.size() - smallerHeap.size() >= 1)
            smallerHeap.offer(biggerHeap.poll());
    }

    public static void findMedian(
            StringBuilder sb,
            int number,
            PriorityQueue<Integer> smallerHeap,
            PriorityQueue<Integer> biggerHeap
    ) {
        if (!smallerHeap.isEmpty() && number > smallerHeap.peek())
            biggerHeap.offer(number);
        else
            smallerHeap.offer(number);

        balanceQueue(smallerHeap, biggerHeap);
        sb.append(smallerHeap.peek()).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> smallerHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> biggerHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            int number = Integer.parseInt(reader.readLine());
            findMedian(sb, number, smallerHeap, biggerHeap);
        }
        reader.close();

        System.out.println(sb);
    }
}
