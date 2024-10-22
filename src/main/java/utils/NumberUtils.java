package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;

public class NumberUtils {

  private final Random random = new Random();

  public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
    final NumberFormat numFormat = NumberFormat.getNumberInstance(locale);
    if (numFormat instanceof DecimalFormat) {
      ((DecimalFormat) numFormat).setParseBigDecimal(true);
    }
    return (BigDecimal) numFormat.parse(amount.replaceAll("[^\\d.,]", ""));
  }

  public int getRandom(int low, int high) {
    low = 0;
    high = 6;
    return random.nextInt(high - low) + low;
  }

  public String covertBigDecimalToCurrency(String value, Locale locale) {
    BigDecimal amount = new BigDecimal(value);
    final NumberFormat numFormat = NumberFormat.getCurrencyInstance(locale);
    return numFormat.format(amount);
  }
}
