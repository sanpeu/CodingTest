package programmers.p1835;

import java.util.ArrayList;
import java.util.List;

public class GroupPhoto {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, new String[] {"N~F=0", "R~T>2"}));
        System.out.println(solution.solution(2, new String[] {"M~C<2", "C~M>1"}));
    }
}

class Solution {
    final Character[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    List<Character> lines;
    String[] data;
    int count;

    public int solution(int n, String[] data) {
        this.lines = new ArrayList<>();
        this.data = data;
        this.count = 0;

        DFS();
        return count;
    }

    private boolean isEnabled() {
        boolean enabled = true;
        // 0 2 프렌즈, 3 조건, 4 거리
        for (String d : data) {
            int friends1 = lines.indexOf(d.charAt(0));
            int friends2 = lines.indexOf(d.charAt(2));
            int distance = Character.getNumericValue(d.charAt(4)) + 1; // 바로 옆은 1칸임

            switch (d.charAt(3)) {
                case '=' :
                    if (!(Math.abs(friends1 - friends2) == distance))
                        enabled = false;
                    break;
                case '>' :
                    if (!(Math.abs(friends1 - friends2) > distance)) // 2 - 3 > 1
                        enabled = false;
                    break;
                case '<' :
                    if (!(Math.abs(friends1 - friends2) < distance)) // 2 - 0 < 3
                        enabled = false;
                    break;
            }

            if (!enabled) break;
        }
        return enabled;
    }

    private void DFS() {
        if (lines.size() == 8) {
            if (isEnabled())
                ++count;
            return;
        }

        for (int i = 0; i < FRIENDS.length; ++i) {
            if (!lines.contains(FRIENDS[i])) {
                lines.add(FRIENDS[i]);
                DFS();
                lines.remove(lines.size()-1);
            }
        }
    }
}
