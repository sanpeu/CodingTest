package programmers.p49993;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (var skill_tree: skill_trees) {
            ++answer;
            for (int i = skill.length()-1; i > 0; --i)  {
                int currentIndex = skill_tree.indexOf(skill.charAt(i));
                int preIndex = skill_tree.indexOf(skill.charAt(i - 1));

                if (currentIndex == -1) continue;
                if (currentIndex < preIndex || preIndex == -1) {
                    --answer;
                    break;
                }
            }
        }
        return answer;
    }
}

public class SkillTrees {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD",
                new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}

