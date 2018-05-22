package org.paukov.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dpaukov on 3/31/18.
 * <p>
 * Solution for Subdomain Visit Count Problem.
 * <p>
 * A website domain like "discuss.leetcode.com" consists of various subdomains.
 * At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level,
 * "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains
 * "leetcode.com" and "com" implicitly.
 * <p>
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received),
 * followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * <p>
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains,
 * (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 * <p>
 * Example:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation:
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
 * For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * <p>
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */
public class SubdomainVisitCount {

  public static void main(String[] args) {
    SubdomainVisitCount v = new SubdomainVisitCount();
    System.out.println(v.subdomainVisits(
        new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
  }

  public List<String> subdomainVisits(String[] cpdomains) {
    List<CountPaired> list = new ArrayList<>();
    for (String s : cpdomains) {
      list.add(new CountPaired(s));
    }
    HashMap<String, Integer> map = new HashMap<>();
    for (CountPaired p : list) {
      for (String s : p.domains) {
        if (map.containsKey(s)) {
          map.put(s, map.get(s) + p.value);
        } else {
          map.put(s, p.value);
        }
      }
    }
    List<String> result = new ArrayList<>();
    for (String s : map.keySet()) {
      result.add("" + map.get(s) + " " + s);
    }
    return result;
  }

  class CountPaired {

    final Integer value;
    List<String> domains = new ArrayList<>();

    CountPaired(String s) {
      int separator = s.indexOf(" ");
      value = Integer.parseInt(s.substring(0, separator));
      String domain = s.substring(separator + 1);
      String[] array = domain.split("\\.");
      for (int i = 0; i < array.length; i++) {
        String d = "";
        for (int j = i; j < array.length; j++) {
          d += array[j];
          if (j != array.length - 1) {
            d += ".";
          }
        }
        domains.add(d);
      }

    }
  }
}
