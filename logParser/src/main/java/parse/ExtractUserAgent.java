package parse;

import constants.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

public class ExtractUserAgent {
  static UserAgentAnalyzer uaa;
  static UserAgent agent;

  //List<String> fileds
  public static void init() {
    uaa = UserAgentAnalyzer
        .newBuilder()
        .withField("OperatingSystemName")
        .withField("AgentName")
        .build();
  }

  public static UserAgent getUserAgent(String inputLine) {
    Pattern pattern =
        Pattern.compile(Constants.USER_AGENT_REGEX.getValue(), Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(inputLine);
    if (matcher.find()) {
      String userAgent = matcher.group(0);
      agent = uaa.parse(userAgent);
    }
    return agent;
  }


}
