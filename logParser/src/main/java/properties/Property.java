package properties;

import java.util.HashMap;
import parse.Parse;

public class Property {
  private int counter = 0;
  private HashMap<String, Integer> map = new HashMap<String, Integer>();
  private Parse parseMethod;
  private String logMessage;

  public Property(Parse parseMethod, String logMessage) {
    this.parseMethod = parseMethod;
    this.logMessage = logMessage;
  }

  public int getCounter() {
    return counter;
  }

  public HashMap<String, Integer> getMap() {
    return map;
  }

  public Parse getParseMethod() {
    return parseMethod;
  }

  public void incrementTotalCount() {
    counter++;
  }

  public String getLogMessage() {
    return logMessage;
  }

}
