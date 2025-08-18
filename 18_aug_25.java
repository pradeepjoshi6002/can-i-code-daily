// https://leetcode.com/problems/24-game/?envType=daily-question&envId=2025-08-18

//You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange //the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get //the value 24.

//You are restricted with the following rules:

//The division operator '/' represents real division, not integer division.
//For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
//Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
//For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
//You cannot concatenate numbers together
//For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
//Return true if you can get such expression that evaluates to 24, and false otherwise.

class Solution {

    public boolean solve(List<Double> cards_){
      if(cards_.size()==1){
        return Math.abs(cards_.get(0)-24.0)<1e-6;
      }
       for(int i=0;i<cards_.size();i++){
          for(int j=0;j<cards_.size();j++){
            if(i==j){
              continue;
            }
            List<Double>next=new ArrayList<>();

            for(int k=0;k<cards_.size();k++){
              if(k!=i && k!=j){
                next.add(cards_.get(k));
              }
            }

            double a=cards_.get(i),b=cards_.get(j);
            for(double result : computeAll(a,b)){
              next.add(result);
              if(solve(next)){
                return true;
              }
              next.remove(next.size()-1);
            }
          }
        }
        return false;
    }
    public boolean judgePoint24(int[] cards) {
      List<List<Integer>> permutations=new ArrayList<>();
      permute(cards,0,permutations);
      for(List<Integer> perm : permutations){
        List<Double> cards_=new ArrayList<>();
        for(int card : cards){
          cards_.add((double)card);
        }
        if(solve(cards_)){
          return true;
        }
      }
      return false;
    }
    private List<Double> computeAll(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > 1e-6) results.add(a / b);
        if (Math.abs(a) > 1e-6) results.add(b / a);
        return results;
    }

    private void permute(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) perm.add(n);
            result.add(perm);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, result);
                swap(nums, start, i);
            }
        }
    }
  private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }   

}