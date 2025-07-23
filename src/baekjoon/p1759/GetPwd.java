package baekjoon.p1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GetPwd {
    int L, C;
    String[] data;
    List<String> selected;
    StringBuilder sb;
    String[] vowels;

    public GetPwd(int L, int C, String[] data) {
        this.L = L;
        this.C = C;
        this.data = data;
        this.vowels = new String[]{"a", "e", "i", "o", "u"};

        Arrays.sort(this.data);

        selected = new ArrayList<>();
        sb = new StringBuilder();

        DFS(0, this.data.length - C);
        System.out.print(sb);
    }

    private void DFS(int start, int to) {
        if (selected.size() == C) {
            int countOfVowels = countVowels(selected);
            if (countOfVowels >= 1 && selected.size() - countOfVowels >= 2) {
                for (String s: selected)
                    sb.append(s);
                sb.append("\n");
            }

            return;
        }

        for (int i = start; i <= to; ++i) {
            selected.add(data[i]);
            DFS(i+1, to+1);
            selected.remove(selected.size() - 1);
        }
    }

    private int countVowels(List<String> array) {
        int count = 0;

        for (int i = 0; i < array.size(); ++i) {
            for (String v: vowels) {
                if (array.get(i).equals(v))
                    ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int C = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());
//        int L = 6, C = 4;
//        String[] data = new String[]{"a", "t", "c", "i", "s", "w"};
        String[] data = new String[L];
        tokenizer = new StringTokenizer(reader.readLine(), " ");

        for (int i = 0; tokenizer.hasMoreTokens(); ++i)
            data[i] = tokenizer.nextToken();

        new GetPwd(L, C, data);
    }
}
