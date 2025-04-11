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
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
       private int sumNumbers(TreeNode root,int sum){
            if(root==null) return 0;
            sum=sum*10+root.val;
            if(root.right== null && root.left==null){
                return sum;
            }
            return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);


        }
        
    }
