package parse;

import static nl.basjes.parse.useragent.UserAgent.AGENT_NAME;
import static parse.ExtractUserAgent.getUserAgent;

import nl.basjes.parse.useragent.UserAgent;

public class ParseBrowserImpl implements Parse {
  @Override
  public String parse(String inputLine) throws Exception {
    UserAgent agent = getUserAgent(inputLine);
    return agent.getValue(AGENT_NAME);
  }
}
