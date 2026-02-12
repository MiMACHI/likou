package com.jian;


import java.util.Arrays;
import java.util.HashMap;

/***
 * 1.两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */

public class TwoSum {

    public static void main(String[] args) {

        int target = 9;
        int[] nums = new int[]{1,2,3,4,5};
        int[] res1 = twoSum1(nums, target);
        int[] res2 = twoSum2(nums, target);
        System.out.println("res1 = " + Arrays.toString(res1));
        System.out.println("res2 = " + Arrays.toString(res2));
    }

    /**
     * 方法一：使用双重for循环
     * @param nums 数组
     * @param target 目标数字
     * @return 返回数组中元素之和等于目标数字的下标
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 方法二：使用hashmap,目标数 - 当前nums元素数值，差值在map中返回map中所存入的索引和当前索引；不存在保存当前值和索引
     * @param nums 数组
     * @param target 目标数字
     * @return 返回数组中元素之和等于目标数字的下标
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>() {};
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
























