/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3

Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/

// Method 1 : Using HASHMAP

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int n : nums) {
            if(!hm.containsKey(n))
                hm.put(n,1);
            else
                hm.put(n,hm.get(n)+1);
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()) {
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }
}
