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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {

            List<Integer> levelRes = new ArrayList<>();

            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++) {

                TreeNode current = q.remove();

                levelRes.add(current.val);

                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);


            }

            if(levelRes.size() > 0) {
                res.add(levelRes);
            }

        }

        return res;


    }
}
