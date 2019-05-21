package com.lpy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/25/
 * @author lipengyu
 * @date 2019/5/21 14:23
 */
public class SingleNumber {


    //@Test
    public void test() {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }


    /**
     * 思路：先对数组进行排序，然后对 nums[i] 和 nums[i + 1]进行比较，如相等，i += 2，继续下一组比较，直到取到不相等的一组。
     *
     * 注意：首先这个数组的长度肯定是奇数（目标数字只出现一次，其他所有数字出现两次），
     *      所以如果上述步骤没有找到不相等的一组数，那么肯定是数组的最后一个数字是单独出现的。
     * @param nums
     * @return
     */
    private int singleNumber(int[] nums) {
        Arrays.sort(nums);  // 排序数组
        for (int i = 0; i < nums.length - 1; i += 2) {
            // 找到不相等的一组，直接返回
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        // 如果没有找到不相等的一组数据，直接返回数组的最后一个数字
        return nums[nums.length - 1];
    }

    /**
     * 思路：利用HashSet的特性，删除重复的数组元素，最后剩下一个单独的元素，返回即可。
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums)  {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) { // add成功返回true，如果set中已有相同数字，则add方法会返回false
                set.remove(nums[i]); // 删除重复出现的数字
            }
        }
        return set.iterator().next();
    }

    /**
     * 思路：先对数组排序，显而易见的，单独出现一次的数据必然是出现在数组下标为偶数的位置（下标从0开始），
     *      那么所有偶数下标的元素之和减去奇数下标的元素之和，就是需要求得的结果。
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int num = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 偶数下标位置 num += nums[i]，奇数下标位置 num -= nums[i]
            num = i % 2 == 0 ? num + nums[i] : num - nums[i];
        }
        return num;
    }

}
