package parse;

import static nl.basjes.parse.useragent.UserAgent.OPERATING_SYSTEM_NAME;
import static parse.ExtractUserAgent.getUserAgent;

import nl.basjes.parse.useragent.UserAgent;

public class ParseOSImpl implements Parse {

  @Override
  public String parse(String inputLine) {
    UserAgent agent = getUserAgent(inputLine);
    return agent.getValue(OPERATING_SYSTEM_NAME);
  }
}
