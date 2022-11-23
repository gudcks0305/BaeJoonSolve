class Solution {
    public  int solution(String skill, String[] skill_trees) {
      int result = 0;
      for (int i = 0; i < skill_trees.length; i++){
         if(check(skill,skill_trees[i])) {
            System.out.println(skill_trees[i]);
            result++;
         }
      }
      return result;
   }
   public  boolean check(String skill , String skill_set){
      if(skill.length() == 1) return true;
      int before_skill_index = findSkill(skill.charAt(0) , skill_set);
      for (int i = 1; i < skill.length(); i++){
         int skillTreeIndex = findSkill(skill.charAt(i) , skill_set);
         if(before_skill_index == -1 && skillTreeIndex != -1) {
            return false;
         }
         else if(before_skill_index > skillTreeIndex && skillTreeIndex != -1) {
            return false;
         }
         before_skill_index = skillTreeIndex;
      }
      return true;
   }
   public  int findSkill(char skill , String skill_set){
      // -1 이면 미포함
      return skill_set.indexOf(skill);
   }
}