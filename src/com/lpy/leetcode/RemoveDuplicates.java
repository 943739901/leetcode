package com.lpy.leetcode;

/**
 * 从排序数组中删除重复项
 * 原题：https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * 参考：https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC26%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E5%88%A0%E9%99%A4%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E9%87%8D%E5%A4%8D%E9%A1%B9.md
 * @author lipengyu
 * @date 2019/5/5 16:14
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(nums));
    }


    /**
     * 使用快慢指针来记录遍历的坐标。
     *
     *    开始时这两个指针都指向第一个数字
     *    如果两个指针指的数字相同，则快指针向前走一步
     *    如果不同，则两个指针都向前走一步
     *    当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数
     * @param nums
     * @return
     */
    private static int removeDuplicates1(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    private static int removeDuplicates2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int pre = 0, cur = 0, n = nums.length;
        while(cur < n) {
            if(nums[pre] == nums[cur]) {
                cur++;
            } else {
                pre++;
                nums[pre] = nums[cur];
                cur++;
            }
        }
        return pre + 1;
    }
}
