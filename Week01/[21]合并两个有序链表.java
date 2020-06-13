//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //方法1 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //算法就是找最小的重复单元
        //栈，我看源码它容量的参数类型是int，系统栈的容量肯定不会比这个小，所以用递归也可以
        //递归有个好处，不用自己去找当前的末尾
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        if ( l1.val <= l2.val ) {
            //此时l1是头节点，l1.next是这条链的第二个节点，
            // 让第二个节点和l2的第一个节点去比较，那是下一个递归过程了，直到实力弱的一方先为空
            //等号左边的next是设置新的第二个节点值，参数里面的next是旧的第二个节点，它和l2的头节点中更小的一方将作为新的第二节点
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l2.next,l1);
            return l2;
        }


    }
    //方法2：迭代
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //链表，最小的复杂度也得是O（l1.size+l2.size）吧，因为链表本身有序了，两个链表同时遍历时利用双指针应该可以之间排序
        ListNode headNode=new ListNode();//本来头节点应该是最小值，奈何实在不知道咋弄了，借一个位置吧，我承认我搓了
        ListNode currentTail=null;
        while (l1!=null||l2!=null){
            ListNode newnode=null;
            if(l1!=null&&(l2==null||l1.val<=l2.val)){
                newnode=new ListNode(l1.val);
                l1=l1.next;
            }else{
                newnode=new ListNode(l2.val);
                l2=l2.next;
            }
            if(headNode.next==null){
                headNode.next=newnode;
                currentTail=headNode.next;
            }else {
                currentTail.next=newnode;
                currentTail=currentTail.next;
            }
        }
        return headNode.next;
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)
