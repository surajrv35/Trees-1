// Time Complexity : O(N*N)
// Space Complexity : O(N*H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Bruteforce
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        
        //pre root left right 
        //in left root right
        int rootValue=preorder[0];
        int rootIndex=0;
            
        for (int i=0;i<inorder.length;i++)
        {
            if(inorder[i] == rootValue){
                rootIndex=i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootValue);
        
        int[] inorderLeft=Arrays.copyOfRange(inorder, 0, rootIndex); 
        int[] inorderRight=Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        
        int[] preorderLeft=Arrays.copyOfRange(preorder, 1, 1+rootIndex);
        int[] preorderRight=Arrays.copyOfRange(preorder, 1+rootIndex, preorder.length);
        
        root.left=buildTree(preorderLeft, inorderLeft);
        root.right=buildTree(preorderRight, inorderRight);
        
        return root;
    }
}