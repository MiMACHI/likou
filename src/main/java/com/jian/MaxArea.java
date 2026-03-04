package com.jian;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class MaxArea {


    public static void main(String[] args) {
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea2(heights);
        System.out.println("maxArea = " + maxArea);
    }

    /**
     * 双重for循环 时间复杂度不符合条件O(n²)
     */
    public static int maxArea(int[] heights) {
        if (heights.length == 0) return 0;

        int max = 0; // 记录最大容量
        for (int i = 0; i < heights.length; i++) {
            int high = heights[i]; // 高度1

            for (int j = 0; j < heights.length; j++) {
                int highJ = heights[j]; // 高度2
                int minHigh = Math.min(high, highJ); // 最小高度
                int area = minHigh * (j - i); // 当前容量
                max = Math.max(area, max);
            }
        }

        return max;
    }

    /**
     * 双指针方法
     * @param heights
     * @return
     */
    public static int maxArea2(int[] heights) {

        int index1 = 0; int index2 = heights.length - 1; int max = 0;

        while (index1 < index2) {
            int high1 = heights[index1]; // 高度1
            int high2 = heights[index2]; // 高度2
            int minHigh = Math.min(high1, high2); // 最高高度
            int maxArea = minHigh * (index2 - index1);
            max = Math.max(maxArea, max);
            if (high1 > high2) index2--;
            else index1++;
        }
        return max;
    }
}
