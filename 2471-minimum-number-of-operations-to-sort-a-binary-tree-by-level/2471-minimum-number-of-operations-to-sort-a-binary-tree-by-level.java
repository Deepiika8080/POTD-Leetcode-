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
    public int makeSort(ArrayList<Integer> vec) {
        int n=vec.size();
        ArrayList<Integer> arr = new ArrayList<>(vec);
        Collections.sort(arr);  
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int swaps = 0;
        for(int i=0;i<n;i++) {
            hm.put(vec.get(i), i);
        }
        
        for(int i=0;i<n;i++) {
            if(vec.get(i).equals(arr.get(i))) {
                continue;
            }
               
            int currIdx = hm.get(arr.get(i));
             hm.put(vec.get(i) , currIdx);
             hm.put(vec.get(currIdx) ,i );
             
          Collections.swap(vec, currIdx , i);
           swaps++;    
               
        }
               
       return swaps;
        
    }
    public int minimumOperations(TreeNode root) {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
       
        q.add(root);
        
        while(!q.isEmpty()) {
            int n=q.size();
             ArrayList<Integer> vec = new ArrayList<>();
            while(n-- > 0) {
                TreeNode node = q.poll();
                
                vec.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            result += makeSort(vec);
        }
        
        return result;
    }
}