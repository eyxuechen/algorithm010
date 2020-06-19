//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorder2(root,list);
        return list;
    }

    public void preorder(TreeNode root,List<Integer> list) {
        if(root!=null){
            list.add(root.val);
            preorder(root.left,list);
            preorder(root.right,list);
        }
    }

    //栈实现
    public void preorder2(TreeNode root,List<Integer> list) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode current=root;
        while (current!=null||!stack.isEmpty()){
            while (current!=null){
                list.add(current.val);
                stack.addLast(current);
                current=current.left;
            }
            current=stack.removeLast();
            current=current.right;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
