//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从后往前
        int i=m-1,j=n-1,len=m+n;
        while (i>=0&&j>=0) {
            nums1[--len] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        //这个犯了错才意识到，批评自己一次
        System.arraycopy(nums2,0,nums1,0,j+1);






        //以下方法只能用于第一个数组比第二个数组长，如果短，交换一下也能用，那样就弄巧成拙了
/*
        int i=0,j=0;
        while (i<m&&j<n){
            while (nums1[i]<=nums2[j]){
                i++;
            }
            while (nums1[i]>nums2[j]){
                int temp=nums2[j];
                nums2[j]=nums1[i];
                nums1[i]=temp;
                i++;
                j++;
            }
        }

        System.arraycopy(nums2,0,nums1,m,n);*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
