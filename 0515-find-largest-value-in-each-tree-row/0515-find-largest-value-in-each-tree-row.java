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
    public List<Integer> largestValues(TreeNode root) {
     
         List<Integer> ans = new ArrayList<>();
         if (root == null) {
            return ans; // Return empty list if the tree is empty
        }
           Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
        
        while(!q.isEmpty()) {
            int n=q.size();
            int maxi = Integer.MIN_VALUE;
            
            while(n-- > 0) {
                TreeNode node = q.poll();
                
                maxi = Math.max(maxi, node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(maxi);
        }
        return ans;
    }
}