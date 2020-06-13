//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //暴力解法，以当前i向两边扫描，遇到比这个高的就停下，把这个小坑计算进来，以此类推，相当于按行计算
    /*class Solution {
        public int trap(int[] nums) {
            int n=nums.length;
            if(n<=2)return 0;//围成一个装雨水的封闭空间至少需要三个数，否则为0
            int v=0;
            for(int i=0;i<n-1;i++){
                int l=i,r=i;
                //从当前柱子出发，向两边扫描，分别找到左右当前比自己高的，计算部分雨水，如果某一侧没有找到比当前柱子高的，说明这个柱子这侧存不了水，进入下一次循环
                while (l>0  && nums[--l]<nums[i]);
                if(nums[l]<nums[i]) continue;
                while (r<n-1&& nums[++r]<=nums[i]);
                if(nums[r]<nums[i]) continue;
                v+=(Math.min(nums[l],nums[r])-nums[i])*(r-l-1);
            }
            return v;
        }
    }*/
    //栈，还是按行计算，还没上面的快
    public int trap(int[] height) {
        int n=heights.length;
        if(n<=2)return 0;//围成一个装雨水的封闭空间至少需要三个数，否则为0
        int v=0;
        Deque<Integer> stack=new ArrayDeque<>(n);
        stack.addLast(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty()&&heights[i]>heights[stack.peekLast()]){
                int lowH=heights[stack.removeLast()];
                if(!stack.isEmpty())
                    v+=(Math.min(heights[stack.peekLast()],heights[i])-lowH)*(i-stack.peekLast()-1);

            }
            stack.addLast(i);
        }


        return v;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
