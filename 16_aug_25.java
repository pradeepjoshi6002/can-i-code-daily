// https://leetcode.com/problems/maximum-69-number/description/?envType=daily-question&envId=2025-08-16
// You are given a positive integer num consisting only of digits 6 and 9.
// Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

class Solution {
    public int maximum69Number (int num) {
        int n=(int)Math.floor(Math.log10(num) + 1);
        int[]nums=new int[n];
        for(int i=n-1;i>=0;i--){
            nums[i]=num%10;
            num=num/10;
        }
        int res=0;
        boolean flag=true;
        for(int i=0;i<n;i++){
            if(flag && nums[i]==6){
                res=res*10+9;
                flag=false;
            }
            else{
                res=res*10+nums[i];
            }
        }
        return res;
    }
}