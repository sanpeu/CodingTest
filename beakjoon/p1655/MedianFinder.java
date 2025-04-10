package beakjoon.p1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; ++i)
            numbers.add(Integer.parseInt(reader.readLine()));
        reader.close();

        Integer median = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(numbers.subList(0, i+1));
            double iterationCount = heap.size()/2.0;

            for (int j = 0; j < iterationCount; ++j)
                median = heap.poll();
            sb.append(median).append("\n");
        }

        System.out.println(sb);
    }
}
