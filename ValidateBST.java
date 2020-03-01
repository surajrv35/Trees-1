// Time Complexity : O(N)
// Space Complexity : O(H) being the height
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
//Recursive Implementation of bound solution
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return validate(root, null, null);
//     }
//     private boolean validate(TreeNode root, Integer low, Integer high)
//     {
//         if (root == null)
//             return true;
        
//         if((low != null && root.val <= low) || (high != null && root.val >= high))
//             return false;
        
//         return validate(root.left, low, root.val) && validate(root.right, root.val, high);
//     }
// }

//Iterative Implementation with stack --- inorder solution
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null)
//             return true;
        
//         Stack<TreeNode> st = new Stack<>();
//         TreeNode prev = null;
//         while(root != null || !st.isEmpty()){
//         while(root != null){
//             st.push(root);
//             root=root.left;
//         }
//         root=st.pop();
//         if(prev != null && root.val <= prev.val)
//             return false;
//         prev=root;
//         root=root.right;
//         }
//         return true;
//     }
// } 

//Iterative solution into Recursion
 class Solution {
     TreeNode prev = null;
     public boolean isValidBST(TreeNode root) {
         return inorder(root);
     }
     private boolean inorder(TreeNode root)
     {
         if(root == null)
             return true;
         
         if(inorder(root.left) == false)
             return false;
         
         if(prev != null && root.val <= prev.val)
             return false;
         
         prev = root;
         return inorder(root.right);  
     }
 }