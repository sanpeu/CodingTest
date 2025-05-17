package test;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static int sum(int from, int to) {
        if (from == to) return to;
        return from + sum(from+1, to);
    }
    public static void main(String[] args) {
//        System.out.println(sum(1, 5));
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(list);
    }

}
