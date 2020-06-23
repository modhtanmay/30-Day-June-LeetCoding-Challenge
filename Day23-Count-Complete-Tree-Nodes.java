/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // Method 1 - Using recursion
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        return 1+ countNodes(root.left) + countNodes(root.right);
    }
}

// Method 2 - It skips some steps from above given

public int countNodes(TreeNode root) {
    if(root==null)
        return 0;
 
    int left = getLeftHeight(root)+1;    
    int right = getRightHeight(root)+1;
 
    if(left==right){
        return (2<<(left-1))-1;
    }else{
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}
 
public int getLeftHeight(TreeNode n){
    if(n==null) return 0;
 
    int height=0;
    while(n.left!=null){
        height++;
        n = n.left;
    }
    return height;
}
 
public int getRightHeight(TreeNode n){
    if(n==null) return 0;
 
    int height=0;
    while(n.right!=null){
        height++;
        n = n.right;
    }
    return height;
}
