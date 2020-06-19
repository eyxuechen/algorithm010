//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList=new ArrayList<>();
        levelOrder(root,resultList);
        return resultList;
    }

    //还是双边队列实现，虽然效率低，总算是被逼的一次性写对了
    public void levelOrder(Node root,List<List<Integer>> resultList){
        if(root==null) return;
        Deque<Node> stack=new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            List<Integer> currentLevelResult=new ArrayList<>();
            List<Node> nextLevelNodes=new ArrayList<>();//用size在队列中判定是否上层结束也可。
            while (!stack.isEmpty()) {
                Node current = stack.removeFirst();
                if(current!=null) currentLevelResult.add(current.val);
                List<Node> children = current.children;
                nextLevelNodes.addAll(children);
            }
            resultList.add(currentLevelResult);
            for(Node child:nextLevelNodes){
                stack.addLast(child);
            }
         }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
