package beakjoon.p1339;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class AlphabetValueSum {
    Map<Character, Integer> alphabet;
    List<Character> alphabetList; // map에 넣을 key
    String[] inputs; // 입력 받은 배열
    int maxSum;

    public AlphabetValueSum(String[] inputs) {
        this.alphabet = new HashMap<>();
        this.inputs = inputs; // 입력 받은 배열
        this.maxSum = 0;

        setAlphabetList(); // alphabet 리스트 설정
        DFS(0);
    }

    // 입력 받은 배열에서 알파벳을 중복제거 후 가져옴
    private void setAlphabetList() {
        Set<Character> set = new HashSet<>();
        for (String input: this.inputs) {
            for (char c: input.toCharArray())
                set.add(c);
        }

        this.alphabetList =  new ArrayList<>(set);
    }

    // 문자열을 정수로 변환
    private int changeAlphabetToInt(String str){
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); ++i) {
            char c = Character.forDigit(alphabet.get(sb.charAt(i)), 10);
            sb.setCharAt(i, c);
        }

        return Integer.parseInt(sb.toString());
    }

    private void DFS(int count) {
        if (count == alphabetList.size()) {
            int currentSum = 0;
            for (String input: inputs)
                currentSum += changeAlphabetToInt(input);

            if (currentSum > maxSum) maxSum = currentSum;
            return;
        }

        for (int i = 0; i < alphabetList.size(); ++i) { // size가 10보다 작으면 조기 종료
            if (!alphabet.containsValue(9 - i)) { // 큰값부터 넣기
                alphabet.put(alphabetList.get(count), 9 - i); // 큰값부터 넣기
                // alphabetList.get에 count를 넣어야함. i를 넣으면 key값에 따른 value값이 고정됨
                DFS(count + 1);
                alphabet.remove(alphabetList.get(count));
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
