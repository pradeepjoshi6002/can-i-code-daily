// https://leetcode.com/problems/range-product-queries-of-powers/description/

// Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.
// You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.
// Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;

        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) {
                powers.add(i);
            }
        }

        int[] prefix = new int[powers.size()];
        prefix[0] = powers.get(0);
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = prefix[i - 1] + powers.get(i);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int total_pow = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
            result[i] = modPow(2, total_pow, mod);
        }

        return result;
    }

    private int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
