//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0,len=inorder.length;i<len;i++){
            map.put(inorder[i],i);
        }

        TreeNode root=_buildTree(preorder,map,0,preorder.length-1,0,inorder.length-1);
        return root;
    }

    public TreeNode  _buildTree(int[] preorder,Map<Integer,Integer> map,int preL,int preR,int inL,int inR){
        if(preL>preR){
            return null;
        }
        int rootValue=preorder[preL];
        int rootInx=map.get(rootValue);
        TreeNode root=new TreeNode(rootValue);
        root.left=_buildTree(preorder,map,preL+1,rootInx-inL+preL,inL,rootInx-1);
        root.right=_buildTree(preorder,map,rootInx-inL+preL+1,preR,rootInx+1,inR);
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
