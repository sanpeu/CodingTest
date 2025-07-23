package baekjoon.p2981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/*
    Beakjoon, p2981
    GCD
 */

public class CommonRemainderFinder {
    public static int greatestCommonDivisor(int a, int b) {
        while(b != 0) { // d가 a와 b의 최대공약수일 때,
            int t = a % b; // a = b*x + (a%b)
            a = b; // a%b = a - b*x >> d(x_1 - x_2)로 묶임
            b = t; // a%b도 d로 나눠짐, b도 d로 나눠짐
        }
        return a;
    }

    public static StringBuilder commonDivisor(int a) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i <= Math.sqrt(a); ++i) {
            if (a % i == 0) {
                set.add(i);
                set.add(a/i);
            }
        }
        set.add(a);

        StringBuilder sb = new StringBuilder();
        for (var s : set)
            sb.append(s).append(" ");

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int point1 = Integer.parseInt(reader.readLine());
        int point2 = Integer.parseInt(reader.readLine());
        int gcd = Math.abs(point1 - point2);

        for (int i = 2; i < N; ++i) {
            int num = Integer.parseInt(reader.readLine());
            gcd = greatestCommonDivisor(gcd, Math.abs(num - point1));
        }
        reader.close();

        System.out.println(commonDivisor(gcd));
    }
}
