//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> dispatcher=new ArrayDeque<>();
        for(int num:nums)dispatcher.addLast(num);
        _permute(nums,nums.length,0,new ArrayDeque<Integer>(),dispatcher);
        return list;
    }

    private void _permute(int[] nums, int len, int i, Deque<Integer> oneKindResult, Deque<Integer> dispatcher) {
        if(oneKindResult.size()>=len){
            list.add(new ArrayList<>(oneKindResult));
            return;
        }
        for(int pos=i;pos<len;pos++){
            oneKindResult.addLast(dispatcher.removeFirst());
            _permute(nums,len,oneKindResult.size(),oneKindResult,dispatcher);
            dispatcher.addLast(oneKindResult.removeLast());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
