// https://leetcode.com/problems/new-21-game/description/?envType=daily-question&envId=2025-08-17

//Alice plays the following game, loosely based on the card game "21".
//Alice starts with 0 points and draws numbers while she has less than k points. During each draw, she gains an integer number of points //randomly from the range [1, maxPts], where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.
//Alice stops drawing numbers when she gets k or more points.
//Return the probability that Alice has n or fewer points.
//Answers within 10-5 of the actual answer are considered accepted.

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0 || n>=(k+maxPts)){
            return 1.0;
        }
        double[]dp=new double[n+1];
        dp[0]=1.0;
        
        double ws=1;
        double result=0;

        for(int i=1;i<=n;i++){
            dp[i]=ws/maxPts;
            if(i<k){
                ws+=dp[i];
            }else{
                result+=dp[i];
            }

            if(i-maxPts>=0){
                ws-=dp[i-maxPts];
            }
        }

        return result;
    }
}