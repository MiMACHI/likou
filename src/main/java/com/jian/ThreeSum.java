package com.jian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * 15. 三数之和
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = new int[]{-100,-70,-60,110,120,130,160};
//        List<List<Integer>> lists = threeSum(arr);
        List<List<Integer>> lists = threeSum2(arr);
        System.out.println("lists = " + lists);
    }


    /**
     * 最笨的方法
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return null;
        }

        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int numOne =  nums[i];
            int indexOne = i + 1;
            int indexTwo = indexOne + 1;
            while (indexOne <= nums.length - 2) {
                while (indexTwo <= nums.length - 1) {
                    int numTwo = nums[indexOne];
                    int numThree = nums[indexTwo];
                    // 三树之和为0 放入set中
                    if (numOne + numTwo + numThree == 0) {
                        hashSet.add(Stream.of(numOne, numTwo, numThree).sorted().toList());
                    }
                    indexTwo++;
                }
                indexOne++;
                indexTwo = indexOne + 1;
            }
        }

        return new ArrayList<>(hashSet);
    }


    /**
     * 优化版
     */
    public static List<List<Integer>> threeSum2(int[] nums) {

        if (nums.length < 3) {
            return null;
        }
        // 先排序
        Arrays.sort(nums);

        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int first = i + 1;
            int last = nums.length - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (sum == 0) {
                    hashSet.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    // 去重：跳过重复的nums[first]
                    while (first < last && nums[first] == nums[first + 1]) {
                        first++;
                    }
                    // 去重：跳过重复的nums[last]
                    while (first < last && nums[last] == nums[last - 1]) {
                        last--;
                    }

                    first++;
                    last--;
                } else if (sum < 0) {
                    // 和太小，左指针右移增大数值
                    first++;
                } else {
                    // 和太大，右指针左移减小数值
                    last--;
                }
            }
        }

        return new ArrayList<>(hashSet);
    }




}
