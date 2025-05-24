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

        System.out.println(compare(1));
        System.out.println(compare(2));
        System.out.println(compare(3));
        System.out.println(compare(5));
        System.out.println(compare(9));
    }

    public int compare(int middle) {
        int count = 1; // 0번은 무조건 설치라고 가정
        int stride = this.houseLocation.length % C;

        for (int i = 0; i < this.houseLocation.length - stride; i += stride) {
            int postRouter = this.houseLocation[i + stride];
            int preRouter = this.houseLocation[i];

            if (postRouter - preRouter >= middle)
                ++count;
        }

        return C - count; // middle 이하는 0만 나옴.
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
//        int N = Integer.parseInt(tokenizer.nextToken());
//        int C = Integer.parseInt(tokenizer.nextToken());
//
//        int[] houseLocation = new int[N];
//        for (int i = 0; i < N; ++i)
//            houseLocation[i] = Integer.parseInt(reader.readLine());
//        reader.close();

        int[] houseLocation = new int[]{1, 2, 8, 4, 9};
        int C = 3;
        new SetupRouter(houseLocation, C);
    }
}
