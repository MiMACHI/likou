package com.jian;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 示例 3：
 * 输入：nums = [1,0,1,2]
 * 输出：3
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        int max = longestConsecutive(nums);
        System.out.println("max = " + max);
    }


    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> tempList = list.stream().distinct().toList();
        List<Integer> sourtList = tempList.stream().sorted().toList();
        int max = 1;
        int tmpMax = 1;
        for (int i = 1; i < sourtList.size(); i++) {
            Integer item = sourtList.get(i);
            Integer lastItem = sourtList.get(i-1);

            if (item - lastItem == 1) {
                max += 1;
            }else {
                tmpMax = Math.max(max, tmpMax);
                max = 1;
            }
        }

        return Math.max(max, tmpMax);
    }



}
