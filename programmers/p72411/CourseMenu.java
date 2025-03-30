package programmers.p72411;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] temp(String[] orders, int course) {
        Map<String, Integer> map = new HashMap<>();

        for (var order: orders) {
            // 예제에서 내부 정렬안된 상태로 주기도 함
            // 정렬이 안되면 map에 넣을 때 같은 것을 다르게 인식할 수도 있음
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            order = new String(charArr);

            for (int i = 0; i < order.length()-1; ++i) {
                for (int j = i+1; j < order.length(); ++j) {
                    String key = String.valueOf(order.charAt(i)) + order.charAt(j);
                    map.put(key, 1+map.getOrDefault(key, 0));
                }
            }
        }

        int maxValue = 0;
        for (var key: map.keySet())
            maxValue = maxValue < map.get(key) ? map.get(key) : maxValue;

        List<String> maxKeys = new ArrayList<>();
        for (var key: map.keySet())
            if (map.get(key) == maxValue) maxKeys.add(key);

        return maxKeys.toArray(new String[maxKeys.size()]);
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (var c: course)
            for (var str: temp(orders, c)) answerList.add(str);

        String[] answer = answerList.toArray(new String[answerList.size()]);
        Arrays.sort(answer);
        return answer;
    }
}

public class CourseMenu {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2})));
        System.out.println(Arrays.toString(solution.solution(
                new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[]{2})));
        System.out.println(Arrays.toString(solution.solution(
                new String[]{"XYZ", "XWY", "WXA"},
                new int[]{2})));
    }
}