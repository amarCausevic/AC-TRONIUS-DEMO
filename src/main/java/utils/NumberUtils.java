package utils;

import java.util.Random;

public class NumberUtils {

  private final Random random = new Random();

  public int getRandom(int low, int high) {
    low = 0;
    high = 6;
    return random.nextInt(high - low) + low;
  }
}
