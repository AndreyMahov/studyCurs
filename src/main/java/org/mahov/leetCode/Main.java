package org.mahov.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int offset = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[offset] = map.get(temp);
                result[++offset] = i;
            } else {
                map.put(nums[i], i);
            }
            if (offset == 1) {
                return result;
            }
        }

        return result;
    }
}
