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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        
        while(!q.isEmpty()) {

            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++) {
                
                TreeNode remove = q.remove();

                if(i == levelSize - 1) {
                    res.add(remove.val);
                }

                if(remove.left != null) q.add(remove.left);
                if(remove.right != null) q.add(remove.right);

            }

        }

        return res;
    }
}
