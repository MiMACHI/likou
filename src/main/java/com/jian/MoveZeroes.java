package com.jian;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr,0);
    }


    /**
     * 将指定数字移动到数组最后
     * @param arr
     * @param target
     */
    public static void moveZeroes(int[] arr, int target) {
        if (arr.length == 0) {
            return;
        }
        int[] result = new int[arr.length];
        int left = 0, right = arr.length - 1;

        for (int num : arr) {
            if (num == target) {
                result[right--] = num;  // 目标值放右边
            } else {
                result[left++] = num;   // 其他值放左边
            }
        }
        System.out.println("result = " + Arrays.toString(result));


    }



}
