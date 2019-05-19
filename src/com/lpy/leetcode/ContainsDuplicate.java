package com.lpy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 买卖股票的最佳时机 II
 * 原题：https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 *
 * @author lipengyu
 * @date 2019/5/5 16:20
 */
public class ContainsDuplicate {


    @Test
    public void test() {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate1(nums));
    }


    /**
     * 两数组相比较
     * @param nums
     * @return
     */
    private boolean containsDuplicate(int[] nums) {
        int[] noDuipacate = new int[nums.length];
        int point = 0;
        for (int num : nums) {
            for (int i=0; i<point; i++) {
                if (noDuipacate[i] == num) {
                    return true;
                }
            }
            noDuipacate[point] = num;
            point++;
        }
        return false;
    }

    /**
     * 先排序，后在遍历数组时每次与下一个做比较，若存在相等则存在重复
     * @param nums
     * @return
     */
    private boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 利用HashSet的唯一性，在每次添加的时候检查返回值来进行判断
     * @param nums
     * @return
     */
    private boolean containsDuplicate2(int[] nums) {
        Set save = new HashSet();
        for (int a : nums) {
            //Set.add(Object)添加失败会返回false
            if (!save.add(a)) return true;
        }
        return false;
    }

}
