//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //只会这一种方法啊：）
    public int nthUglyNumber(int k) {
        int[] base={2,3,5};
        int len=base.length;
        int[] dp=new int[k];//存放产生的丑数
        int[] p =new int[len];//存放基础质数与dp中对应位置
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        dp[0]=1;

        int cnt=1;

        while (cnt<k){
            for(int j=0;j<len;j++){
                int temp=base[j]*dp[p[j]];
                if(!pq.contains(temp)){
                    pq.offer(base[j]*dp[p[j]]);
                }
            }
            int min=pq.poll();
            for(int x=0;x<len;x++){
                if(min==base[x]*dp[p[x]]){
                    p[x]=p[x]+1;
                    //break;
                }
            }
            dp[cnt++]=min;
        }
        return dp[k-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
