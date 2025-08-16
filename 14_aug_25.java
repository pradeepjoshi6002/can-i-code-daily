// https://leetcode.com/problems/largest-3-same-digit-number-in-string/

// You are given a string num representing a large integer. An integer is good if it meets the following conditions:
// It is a substring of num with length 3.
// It consists of only one unique digit.
// Return the maximum good integer as a string or an empty string "" if no such integer exists.

class Solution {
    public String largestGoodInteger(String num) {
        int maxNum=-1;
        for(int i=0;i<num.length()-1;i++){
            if(num.charAt(i)==num.charAt(i+1)){
                i++;
                if(i<num.length()-1 && num.charAt(i)==num.charAt(i+1)){
                    int number=(num.charAt(i-1)-'0')*100+(num.charAt(i)-'0')*10+(num.charAt(i+1)-'0');
                    if(number>maxNum){
                        maxNum=number;
                    }
                }
            }
        }
        if(maxNum==0){
            return "000";
        }
        return maxNum==-1?"":maxNum+"";
    }
}