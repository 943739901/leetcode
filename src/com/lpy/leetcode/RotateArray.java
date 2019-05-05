package com.lpy.leetcode;

import java.util.Arrays;

/**
 * 旋转数组
 * 原题：https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 * 参考：https://www.cnblogs.com/grandyang/p/4298711.html
 * @author lipengyu
 * @date 2019/5/5 14:52
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate3(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 通过复制数组，对nums[(i+k)%nums.length]赋值
     * @param nums
     * @param k
     */
    private static void rotate1(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return;
        }
        int[] t = Arrays.copyOf(nums, nums.length);
        for(int i=0;i<nums.length;i++) {
            nums[(i+k)%nums.length] = t[i];
        }

    }

    /**
     * 主要思路：
     * 由于提示中要求我们空间复杂度为O(1)，所以我们不能用辅助数组，
     * 但是目的依然是将 nums[idx] 赋值到 nums[(idx+k) % n] ，为了防止数据覆盖丢失，我们需要用额外的变量来保存，
     * 在每次更新后，将已保存的数据再次赋值到 nums[(idx+k) % n]
     *
     * 这里用了pre和cur，其中cur初始化为了数组的第一个数字，
     * 以及变量 idx 标明当前在交换的位置，
     *
     * 还需要变量 start，目的是为了防止陷入死循环，
     * 初始化为0，一旦当 idx 变到了 strat 的位置，则 start 自增1，再赋值给 idx，这样 idx 的位置也改变了，就可以继续进行交换了。
     *
     * 举个例子，假如 [1, 2, 3, 4], K=2 的话，那么 idx=0，
     * 下一次变为 idx = (idx+k) % n = 2，
     * 再下一次又变成了 idx = (idx+k) % n = 0，
     * 此时明显 1 和 3 的位置还没有处理过，
     * 所以当我们发现 idx 和 start 相等，则二者均自增1，那么此时 idx=1，
     * 下一次变为 idx = (idx+k) % n = 3，就可以交换完所有的数字了。
     *
     * 因为长度为n的数组只需要更新n次，所以我们用一个for循环来处理n次。
     * 首先 pre 更新为 cur，然后计算新的 idx 的位置，
     * 然后将 nums[idx] 上的值先存到 cur 上，然后把 pre 赋值给 nums[idx]，
     * 这相当于把上一轮的 nums[idx] 赋给了新的一轮，完成了数字的交换，然后 if 语句判断是否会变到处理过的数字，
     * 参见上面一段的解释，我们用题目中的例子1来展示下面这种算法的nums的变化过程：
     *
     * 1 2 3 4 5 6 7
     * 1 2 3 [1] 5 6 7
     * 1 2 3 1 5 6 [4]
     * 1 2 [7] 1 5 6 4
     * 1 2 7 1 5 [3] 4
     * 1 [6] 7 1 5 3 4
     * 1 6 7 1 [2] 3 4
     * [5] 6 7 1 2 3 4
     * @param nums
     * @param k
     */
    private static void rotate2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return;
        }
        int start = 0, idx = 0, pre = 0, cur = nums[0], n = nums.length;
        for (int i = 0; i < n; ++i) {
            pre = cur;
            idx = (idx + k) % n;
            cur = nums[idx];
            nums[idx] = pre;
            if (idx == start) {
                idx = ++start;
                cur = nums[idx];
            }
        }

    }

    /**
     * 三次翻转
     * 1 2 3 4 5 6 7
     * 7 6 5 4 3 2 1
     * 5 6 7 4 3 2 1
     * 5 6 7 1 2 3 4
     *
     * @param nums
     * @param k
     */
    private static void rotate3(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return;
        }
        reverseArray(nums, 0, nums.length);
        reverseArray(nums, 0, k);
        reverseArray(nums, k, nums.length);
    }

    /**
     * 反转数组
     * @param array
     * @return
     */
    private static void reverseArray(int[] array, int begin, int end){
        int mid = (end + begin - 1) / 2;
        int i = begin;
        int j = end - 1;
        while(i <= mid) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
