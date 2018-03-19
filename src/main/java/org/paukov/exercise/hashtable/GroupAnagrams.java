package org.paukov.exercise.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dpaukov on 3/18/18.
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return: [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * <p>
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {

    static class Anagram {
        String string;

        Anagram(String string) {
            this.string = string;
        }

        int getCode() {
            int code = 1;
            for (char c : string.toCharArray()) {
                if (code > Integer.MAX_VALUE / c) {
                    // overflow, will use sorting
                    char[] sorted = string.toCharArray();
                    Arrays.sort(sorted);
                    return Arrays.hashCode(sorted);
                } else {
                    // TODO: probably should use the prime numbers here
                    // instead if the char codes.
                    code *= c;
                }
            }
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Anagram anagram = (Anagram) o;
            return getCode() == anagram.getCode();
        }

        @Override
        public int hashCode() {
            return getCode();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Anagram, List<String>> groups = new HashMap<Anagram, List<String>>();
        for (String str : strs) {
            Anagram anagram = new Anagram(str);
            if (groups.containsKey(anagram)) {
                groups.get(anagram).add(str);
            } else {
                groups.put(anagram, new ArrayList<String>(Arrays.asList(str)));
            }
        }
        List<List<String>> result = new ArrayList<List<String>>(groups.values());
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Groups: " + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
