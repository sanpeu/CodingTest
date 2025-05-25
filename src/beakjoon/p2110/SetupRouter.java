package beakjoon.p2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SetupRouter {
    int[] houseLocation;
    int C;

    public SetupRouter(int[] houseLocation, int C) {
        Arrays.sort(houseLocation);
        this.houseLocation = houseLocation;
        this.C = C;

        System.out.println(parametricSearch_max(1, houseLocation[houseLocation.length-1] - houseLocation[0]));
    }

    public int compare(int middle) {
        int count = 1; // 0번은 무조건 설치라고 가정
        int preRouter = this.houseLocation[0];

        for (int i = 1; i < this.houseLocation.length; ++i) {
            int current = this.houseLocation[i];

            if (current - preRouter >= middle) {
                ++count;
                preRouter = this.houseLocation[i];
            }
        }

        return C - count;
    }

    public int parametricSearch_max(int left, int right) {
        while (left <= right) {
            int middle = left + (right - left)/2;
            int g_x = compare(middle); // x가 정답보다 작으면 음수
            if (g_x <= 0) // g_x의 결과를 0과 비교하여 작거나 같으면 오른쪽을 본다.
                left = middle + 1;
            else
                right = middle - 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        int[] houseLocation = new int[N];
        for (int i = 0; i < N; ++i)
            houseLocation[i] = Integer.parseInt(reader.readLine());
        reader.close();

        SetupRouter setupRouter = new SetupRouter(houseLocation, C);
    }
}
