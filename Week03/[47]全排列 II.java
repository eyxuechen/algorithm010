//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used=new int[nums.length];
        Arrays.sort(nums);
        _permuteUnique(nums,nums.length,0,new ArrayDeque<Integer>(),used);
        return list;
    }

    private void _permuteUnique(int[] nums, int len, int i, Deque<Integer> oneKindResult, int[] used) {
        if(oneKindResult.size()>=len){
            list.add(new ArrayList<>(oneKindResult));
            return;
        }
        for(int pos=0;pos<len;pos++){
            if(used[pos]==1) continue;
            if (pos > 0 && nums[pos] == nums[pos - 1] && used[pos - 1]==0) {
                continue;
            }
            oneKindResult.addLast(nums[pos]);
            used[pos] = 1;
            _permuteUnique(nums,len,i+1,oneKindResult,used);
            used[pos] = 0;
            oneKindResult.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
