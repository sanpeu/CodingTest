package programmers.p49993;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        Pattern pattern = Pattern.compile(toRegex(skill));
        Matcher matcher;

        for (var skill_tree: skill_trees) {
            matcher = pattern.matcher(skill_tree);
            if (matcher.find()) ++answer;
        }
        return answer;
    }

    public String toRegex(String string) {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            regex.append(string.charAt(i));
            regex.append("[A-Z]*");
        }

        return regex.toString();
    }
}

public class SkillTrees {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD",
                new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}

