package org.paukov.exercise;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.paukov.exercise.math.PalindromeNumber;

/**
 * Created by dima on 2/19/18.
 */
public class PalindromeNumberTest {

  @Test
  public void test_palindrom_number_0() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(4)).isTrue();
  }

  @Test
  public void test_palindrom_number_00() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(22)).isTrue();
  }

  @Test
  public void test_palindrom_number_01() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(121)).isTrue();
  }

  @Test
  public void test_palindrom_number_02() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(1221)).isTrue();
  }

  @Test
  public void test_palindrom_number_03() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(1223)).isFalse();
  }

  @Test
  public void test_palindrom_number_04() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(885588)).isTrue();
  }

  @Test
  public void test_palindrom_number_05() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(-885588)).isFalse();
  }

  @Test
  public void test_palindrom_number_06() {
    PalindromeNumber palindromNumber = new PalindromeNumber();
    assertThat(palindromNumber.isPalindrome(-2147483648)).isFalse();
  }
}
