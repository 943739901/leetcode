package com.lpy.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 两个数组的交集 II
 * 原题：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/26/
 *
 * @author lipengyu
 * @date 2019/5/21 14:22
 */
public class Intersect {


    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }


    /**
     * 先用Hashmap记录第一个数组中的元素【放在key】，和出现的次数【放在value】。
     * 然后再遍历第二个数组，如果找到对用元素&&对应HashMap中的value不为0，则添加这个元素到list中等下放到数组中，
     * 同时，HashMap中的value值减一，表示已经找到一个相同的了。最后的话，将list中的值取出来，放到数组中返回
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1 > len2 ? len1 : len2;
        int[] res = new int[len3];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                res[k] = nums1[i];
                k++;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums2[j];
                k++;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[k];
        for (int x = 0; x < k; x++) {
            res[x] = nums1[x];
        }
        return res;
    }
}
