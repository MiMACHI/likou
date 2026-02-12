package com.jian;

import java.util.*;

/**
 * 49.字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 解释：
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        System.out.println("res1 = " + groupAnagrams(strs));
        System.out.println("res1 = " + groupAnagrams2(strs));
        String[] strs2 = {""};
        System.out.println("res2 = " + groupAnagrams(strs2));
        String[] strs3 = {"a"};
        System.out.println("res3 = " + groupAnagrams(strs3));

    }

    /**
     * 方法一：先排序字符，再put到map中，如果有则add到map的value中(类型为list)
     * @param strs 字符串数组
     * @return 字母异位词分组
     * 注意：
     *  1.List.of为不可变列表
     *  2.Arrays.asList(...)固定大小，可set不可add/remove
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortStr = str.chars().sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            if (map.containsKey(sortStr)){
                List<String> strings = map.get(sortStr);
                strings.add(str);
                map.put(sortStr, strings);
            } else {
                map.put(sortStr, new ArrayList<>(List.of(str)));
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 方法二：运算速度第一名代码
     * @param strs 字符串数组
     * @return 字母异位词分组
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        return new java.util.AbstractList<List<String>>() {
            List<List<String>> res = null;

            @Override
            public int size() {
                init();
                return res.size();
            }

            @Override
            public List<String> get(int index) {
                init();
                return res.get(index);
            }

            private void init() {
                if (res != null) {
                    return;
                }
                res = new ArrayList<>();
                Map<Integer, List<String>> map = new HashMap<>();
                for (String str : strs) {
                    if (str == null) {
                        continue;
                    }
                    char[] chars = str.toCharArray();
                    // 题中全是小写英文字母,所以为26
                    int[] count = new int[26];
                    for (char c : chars) {
                        // asic中'a'对应值97,需要减去'a'找到对应索引位置
                        count[c - 'a']++;
                    }
                    // 将count数组转换为hash,可作为map的key
                    int hash = Arrays.hashCode(count);
                    // key 不存在时创建 ArrayList，然后添加 str
                    map.computeIfAbsent(hash, k -> new ArrayList<>()).add(str);
                }
                res.addAll(map.values());
            }
        };
    }
}























