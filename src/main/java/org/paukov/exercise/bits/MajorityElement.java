package org.paukov.exercise.bits;

/**
 * Created by dpaukov on 3/18/18.
 * Given an array of size n, find the majority element. The majority element
 * is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element
 * always exist in the array.
 * <p>
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    // Solution based on Boyer–Moore majority vote algorithm
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int c : nums) {
            if (candidate == c) {
                count++;
            } else {
                if (count == 0) {
                    candidate = c;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
