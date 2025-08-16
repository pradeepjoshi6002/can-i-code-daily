// https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/

// Given two positive integers n and x.
// Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.
// Since the result can be very large, return it modulo 109 + 7.
// For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

class Solution {
    public int numberOfWays(int n, int x) {
        int mod = 1000000007;

        List<Integer> nums=new ArrayList<>();
        int i=1;
        int pow=(int)Math.pow(i,x);
        while(pow<=n){
            nums.add(pow);
            i++;
            pow=(int)Math.pow(i,x);
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;  

        for (int power : nums) {
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power])%mod;
            }
        }
        return dp[n];
    }
}