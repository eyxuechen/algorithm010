//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        preorder2(root,list);
        return list;
    }

    //递归
    public void preorder(Node root,List<Integer> list) {
        if(root!=null){
            list.add(root.val);
            List<Node> children=root.children;
            for(Node child:children){
                preorder(child,list);
            }
        }

    }

    //迭代,本以为根左右和根右左一样都算对，结果不是，被逼用了反转。效率比较低。
    public void preorder2(Node root,List<Integer> list) {
        if(root==null) return;
        Deque<Node> stack=new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            Node current=stack.removeLast();
            list.add(current.val);
            List<Node> children=current.children;
            Collections.reverse(children);
            for(Node child:children){
                if(child!=null)
                stack.addLast(child);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
