package org.paukov.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpaukov on 3/31/18.
 * <p>
 * Base class for resolving 0/1 knapsack problems.
 * <p>
 * https://en.wikipedia.org/wiki/Knapsack_problem
 */
public class Knapsack<O extends Knapsack.Item> {

  O[] items;
  int capacity;
  public Knapsack(O[] objects, int capacity) {
    this.items = objects;
    this.capacity = capacity;
  }

  public static void main(String[] args) {
    Knapsack<StringItem> knapsack = new Knapsack<>(new StringItem[]{
        new StringItem("red", 5, 60),
        new StringItem("green", 3, 50),
        new StringItem("blue", 4, 70),
        new StringItem("yellow", 2, 30),

    }, 7);
    System.out.println(knapsack.getBestSelection());
  }

  public List<O> getBestSelection() {
    // Value matrix
    int[][] V = new int[items.length + 1][capacity + 1];

    // Selected items matrix
    boolean[][] S = new boolean[items.length + 1][capacity + 1];

    for (int i = 0; i <= items.length; i++) {
      for (int j = 0; j <= capacity; j++) {
        if (i == 0 || j == 0) {
          V[i][j] = 0;
        } else {
          if (items[i - 1].weight <= j) {
            int withoutCurrentItem = V[i - 1][j];
            int withCurrentItem = V[i - 1][j - items[i - 1].weight] + items[i - 1].value;
            if (withCurrentItem >= withoutCurrentItem) {
              V[i][j] = withCurrentItem;
              S[i][j] = true;
            } else {
              V[i][j] = withoutCurrentItem;
              S[i][j] = false;
            }
          } else {
            V[i][j] = V[i - 1][j];
            S[i][j] = false;
          }
        }

      }
    }

    // Tracking back to find the selected items
    List<O> result = new ArrayList<>();
    int t = capacity;
    int k = items.length;
    while (t >= 0 && k >= 0) {
      if (S[k][t]) {
        result.add(items[k - 1]);
        t = t - items[k - 1].weight;
      }
      k--;
    }
    return result;
  }

  static class Item<T> {

    T object;
    int weight;
    int value;

    public Item(T object, int weight, int value) {
      this.object = object;
      this.weight = weight;
      this.value = value;
    }

    @Override
    public String toString() {
      return "(" + object.toString() + ", w=" + weight + ", v=" + value + ")";
    }
  }

  static class StringItem extends Item<String> {

    StringItem(String object, int weight, int value) {
      super(object, weight, value);
    }
  }
}
