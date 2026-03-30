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

    private int preIdx = 0;
    
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, preorder.length - 1);

    }

    private TreeNode buildSubtree(int[] preorder, int l, int r) {

        if(l > r) return null;
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int mid = map.get(root.val);
        root.left = buildSubtree(preorder, l, mid - 1);
        root.right = buildSubtree(preorder, mid + 1, r);
        return root;

    }
}
