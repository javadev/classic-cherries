package org.paukov.exercise.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpaukov on 4/25/18.
 *
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static int lengthOfLongestSubstring(String s) {

    Set<Character> set = new HashSet<>();
    int maxSize = 0;

    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        Character c = s.charAt(j);
        if (set.contains(c)) {
          set.clear();
          break;
        } else {
          set.add(c);
        }
        if (set.size() > maxSize) {
          maxSize = set.size();
        }
      }
    }
    return maxSize;
  }

  public static void main(String[] args) {
    int len = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb");
    System.out.println("Len: " + len);
  }

}
