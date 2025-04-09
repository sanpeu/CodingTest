package beakjoon.p1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MedianFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            int k = Integer.parseInt(reader.readLine());
            list.add(k);

            if (list.size() == 3) {
                list.remove(Collections.min(list));
                list.remove(Collections.max(list));
                System.out.println(list.get(0));
            } else {
                System.out.println(Collections.min(list));
            }
        }
    }
}
