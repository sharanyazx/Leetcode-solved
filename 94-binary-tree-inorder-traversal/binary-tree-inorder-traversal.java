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
    public List<Integer> inorder(TreeNode root, List<Integer>list) {
        if(root==null)  return list;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return list;

    }
        public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<Integer>();
        return inorder(root,list);
        
    }
}