package programmers.p42577;
import java.util.Arrays;

public class TelephoneDirectoryBook2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] phone_book = new String[]{"123","456","789"};
        System.out.println(solution.solution(phone_book));
    }
}

class Solution2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i=0; i < phone_book.length - 1; ++i) { // 마지막은 할 필요가 없음
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}