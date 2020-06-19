//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal2(root, list);
        return list;

    }

    //递归
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, list);
            }
        }
    }

    //栈模拟
    public void inorderTraversal2(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.addLast(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.removeLast();
            list.add(currentNode.val);
            currentNode = currentNode.right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
