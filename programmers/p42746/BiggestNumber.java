package programmers.p42746;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{3, 32, 34, 803, 89,8}; // 89 8 803 34 3 32
        // 8이나 88이나 똑같다. 2번째 자리가
        // 8보다 큰수는 앞에 8보다 작은 수는 뒤에
        // 8과 같거나 없으면 중간
        System.out.println(solution.solution(numbers));
    }
}

class Solution {
    public String solution(int[] numbers) {
        
        // 한줄로 만들기
        StringBuilder answer = new StringBuilder();

        String[] strings = Arrays.stream(numbers)
                .mapToObj(n -> String.valueOf(n))
                .toArray(size -> new String[size]);

        for (var str: strings)
            answer.append(str);

        return answer.toString();
    }
}
