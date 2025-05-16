package beakjoon.p9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOf123Counter {
    private int count;
    private int currentSum;
    private int[] numbers;

    public SumOf123Counter() {
        this.count = 0;
        this.currentSum = 0;
        this.numbers = new int[]{1, 2, 3};
    }

    public void DFS(int n) {
        if (this.currentSum >= n) {
            if (this.currentSum == n) ++this.count;
            return;
        }

        for (int number: this.numbers) { // 중복순열
            this.currentSum += number;
            DFS(n);
            this.currentSum -= number;
        }
    }

    public int getSumOf123Count(int n) {
        this.count = 0;
        this.currentSum = 0;
        DFS(n);
        return this.count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());

        SumOf123Counter sumOf123Counter = new SumOf123Counter();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; ++i) {
            int n = Integer.parseInt(reader.readLine());
            int count = sumOf123Counter.getSumOf123Count(n);
            sb.append(count).append("\n");
        }

        System.out.print(sb);
        reader.close();
    }
}
