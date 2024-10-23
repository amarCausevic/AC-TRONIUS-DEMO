package utils;

public class StringUtils {

  public String removeBreakLine(String value) {
    return value.replace("\n", " ").replace("\r", " ");
  }
}
