/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Hide Hint #1  
The entire logic for reversing a string is based on using the opposite directional two-pointer approach!

*/

// Method 1

class Solution {
    public void reverseString(char[] s) {
        List<Character> al = new ArrayList<Character>();
        
        for(int i=s.length-1;i>=0;i--)
            al.add(s[i]);
        
        for(int i=0;i<s.length;i++)
            s[i] = al.get(i);
    }
}

// Method 2 - Two Pointers, Iteration, O(1) Space

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}

// Method 3 - Recursion, In-Place, O(N) Space

class Solution {
  public void helper(char[] s, int left, int right) {
    if (left >= right) return;
    char tmp = s[left];
    s[left++] = s[right];
    s[right--] = tmp;
    helper(s, left, right);
  }

  public void reverseString(char[] s) {
    helper(s, 0, s.length - 1);
  }
}
