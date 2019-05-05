package com.lpy.leetcode;

/**
 * 买卖股票的最佳时机 II
 * 原题：https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 * @author lipengyu
 * @date 2019/5/5 16:20
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 当明天的价格比今天的价格贵的时候我们今天买，明天卖，这样能够获取最大利润
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i+1] > prices[i]) {
                max += prices[i+1] - prices[i];
            }
        }
        return max;
    }
}
