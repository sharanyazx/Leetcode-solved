// Last updated: 9/3/2025, 10:48:23 AM
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            boolean foundX=false;
            boolean foundY=false;
        for(int i=0;i<size;i++){
            TreeNode cur=q.poll();
            if(cur.left!=null && cur.right!=null){
                if(cur.left.val==x && cur.right.val==y ||cur.left.val==y && cur.right.val==x ){
                    return false;
                }
            }
            if(cur.val==x){
                foundX=true;
            }
            if(cur.val==y){
                foundY=true;
            }
            if(cur.left!=null){
                q.offer(cur.left);
            }
            if(cur.right!=null){
                q.offer(cur.right);
            }
            
        }
        if(foundX && foundY){
                return true;
            }
            if(foundX || foundY){
                return false;
            }
        }
        return false;
    }
}