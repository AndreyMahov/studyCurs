package org.mahov.leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void twoSum() {
        Main main = new Main();
        int[] arr = new int[]{2,7,11,15};
        int target = 9;

        int[] result = main.twoSum(arr, target);
        assertEquals(result[0], 0);
        assertEquals(result[1], 1);
    }
}