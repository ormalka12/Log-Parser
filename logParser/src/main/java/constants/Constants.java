package constants;

public enum Constants {
  LOG_PATH("/Users/omalka/logParser/src/main/resources/all.log"),
  DB_PATH("/Users/omalka/logParser/src/main/resources/GeoLite2-Country.mmdb"),
  USER_AGENT_REGEX(
      "[^\"]*(mozilla|opera|ipad|applewebkit|khtml|7b405|bot|sundance|lynx|etc|etc)[^\"]*(?=\")"),
  COUNTRY_LOG_MESSAGE("****  Countries:  ****"),
  OS_LOG_MESSAGE("****  Operating systems:  ****"),
  BROWSER_LOG_MESSAGE("****  Browsers:  ****");

  private final String path;

  Constants(String path) {
    this.path = path;
  }

  public String getValue() {
    return path;
  }
}
