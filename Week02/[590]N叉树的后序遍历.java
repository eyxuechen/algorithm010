//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
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
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        postorder3(root,list);
        //LinkedList<Integer> list=new LinkedList<>();
        //postorder2(root,list);
        return list;
    }

    //递归
    public void postorder(Node root,List<Integer> list) {
        if(root!=null){
            List<Node> children=root.children;
            for(Node node:children){
                postorder(node,list);
            }
            list.add(root.val);
        }
    }
    //这个按照双循环那样不好写，不能确定要嵌套多少层循环
    //栈实现，这个可以按照广序优先使用队列那个思路使用栈。只是一个先进先出，一个后进先出，
    //只是再拿出这个node时直接处理了就成了前序，这里是后序，这里使用了LinkedList把结果依次前插这样结果的顺序和后序出来的结果一样
    //也可以按照这个思路在使用一个栈，把这个node先保存在栈底，linkedlist本质和stack有相似之处
    public void postorder2(Node root,LinkedList<Integer> list) {
        if(root==null)return;
        Deque<Node> stack=new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node current=stack.removeLast();
            list.addFirst(current.val);
            List<Node> children = current.children;
            for(Node node:children){
                if(node!=null)
                stack.addLast(node);
            }
        }

    }

    //双栈在性能上测试结果比上述要浪费不少，因为它相当于把中间过程都先存储了起来，递归最高效
    public void postorder3(Node root,List<Integer> list) {
        if (root == null) return;
        Deque<Node> stack = new ArrayDeque<>();
        Deque<Node> stack2 = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node transfer = stack.removeLast();
            stack2.addLast(transfer);
            List<Node> children = transfer.children;
            for (Node node : children) {
                if (node != null)
                    stack.addLast(node);
            }
        }
        while (!stack2.isEmpty()) {
            Node current = stack2.removeLast();
            if (current != null)
                list.add(current.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
