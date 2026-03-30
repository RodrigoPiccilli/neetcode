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

                TreeNode current = q.remove();

                if(i == levelSize - 1) {
                    res.add(current.val);
                }

                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);

            }

        }

        return res;

        
    }
}
