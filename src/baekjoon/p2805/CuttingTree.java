package baekjoon.p2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuttingTree {
    int[] trees;
    int M;

    public CuttingTree() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(tokenizer.nextToken());
        this.M = Integer.parseInt(tokenizer.nextToken());
        this.trees = new int[N];

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; ++i)
            this.trees[i] = Integer.parseInt(tokenizer.nextToken());

        reader.close();
    }

    public long compare(long middle) {
        long 가져가는나무 = 0;
        for (int tree: this.trees) {
            if (tree - middle > 0)
                가져가는나무 += tree - middle;
        }

        return (long) M - 가져가는나무;
    }

    public int parametricSearch_max(int left, int right) {
        while (left <= right) {
            int middle = left + (right - left)/2;
            long h = compare(middle);
            if (h <= 0)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        CuttingTree cuttingTree = new CuttingTree();
        System.out.println(cuttingTree.parametricSearch_max(0, 2000000000));
    }
}
