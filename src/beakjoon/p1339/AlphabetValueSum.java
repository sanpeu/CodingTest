package beakjoon.p1339;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AlphabetValueSum {
    List<Integer> alphabet;
    String[] inputs;
    int maxSum;
    int num;

    public AlphabetValueSum(String[] inputs) {
        this.alphabet = new ArrayList<>();
        this.inputs = inputs;
        this.maxSum = 0;
        this.num = 'J' - 'A' + 1; // 10개

        DFS();
    }

    public int changeAlphabetToInt(String str){
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); ++i) {
            char c = Character.forDigit(alphabet.get(sb.charAt(i) - 'A'), 10);
            sb.setCharAt(i, c);
        }

        return Integer.parseInt(sb.toString());
    }

    public void DFS() {
        if (alphabet.size() == num) {
            int currentSum = 0;
            for (String input: inputs)
                currentSum += changeAlphabetToInt(input);

            if (currentSum > maxSum) maxSum = currentSum;
            return;
        }

        for (int i = 0; i < num; ++i) {
            if (!alphabet.contains(i)) {
                alphabet.add(i);
                DFS();
                alphabet.remove(alphabet.size()-1);
            }
        }
    }

    public int getMaxSum() { return maxSum; }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] inputs = new String[n];

        for (int i = 0; i < n; ++i)
            inputs[i] = reader.readLine();

        AlphabetValueSum alphabetValueSum = new AlphabetValueSum(inputs);
        System.out.println(alphabetValueSum.getMaxSum());
        reader.close();
    }
}
