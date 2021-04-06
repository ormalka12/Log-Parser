package statistics;

import java.util.HashMap;

public class Statistics {

  public static void addToStatistics(HashMap<String, Integer> map, String key)
      throws Exception {
    if (key != null) {
      int count = map.containsKey(key) ? map.get(key) : 0;
      map.put(key, count + 1);
    }
  }

  public static void getStatistics(HashMap<String, Integer> map, int count) {
    map.entrySet().stream()
        .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
        .forEach(k ->
            System.out.println(k.getKey() + ": " + getPercentValue(k.getValue(), count)));
  }

  public static String getPercentValue(double numerator, double denominator) {
    return String.format("%.2f", Double.valueOf(numerator / denominator * 100)) + "%";
  }

  public static void printResults(String message, HashMap<String, Integer> map, int total) {
    System.out.println(message);
    Statistics.getStatistics(map, total);
  }

}
