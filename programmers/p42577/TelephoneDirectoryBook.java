package programmers.p42577;
import java.util.Arrays;

public class TelephoneDirectoryBook {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] phone_book = new String[]{"12","123","1235","567","88"};
        System.out.println(solution.solution(phone_book));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int checker=0; checker < phone_book.length - 1; ++checker) { // 마지막은 할 필요가 없음
            for (int target=checker+1; target < phone_book.length; ++target) {
                if (phone_book[target].startsWith(phone_book[checker])) {
                    answer = false;
                    return answer;
                } else {
                    break; // 만약 안 겹치면 다음 순서로
                }

            }
        }
        return answer;
    }
}