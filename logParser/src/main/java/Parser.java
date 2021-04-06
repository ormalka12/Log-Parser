import static constants.Constants.BROWSER_LOG_MESSAGE;
import static constants.Constants.COUNTRY_LOG_MESSAGE;
import static constants.Constants.OS_LOG_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import parse.ExtractUserAgent;
import parse.ParseBrowserImpl;
import parse.ParseCountryImpl;
import parse.ParseOSImpl;
import properties.Property;
import reader.InputReader;
import statistics.Statistics;

public class Parser {
  private final String logPath;
  List<Property> propertiesList = new ArrayList<>();


  public Parser(String logPath) {
    this.logPath = logPath;
  }

  public void init() {
    propertiesList.add(new Property(new ParseCountryImpl(), COUNTRY_LOG_MESSAGE.getValue()));
    propertiesList.add(new Property(new ParseOSImpl(), OS_LOG_MESSAGE.getValue()));
    propertiesList.add(new Property(new ParseBrowserImpl(), BROWSER_LOG_MESSAGE.getValue()));
    ExtractUserAgent.init();
  }

  public void start() throws Exception {
    init();
    InputReader inputReader = new InputReader();
    try {
      inputReader.createReader(logPath);
      String currentLine = inputReader.readCurrentLine();
      while (currentLine != null) {
        for (Property property : propertiesList) {
          Statistics
              .addToStatistics(property.getMap(), property.getParseMethod().parse(currentLine));
          property.incrementTotalCount();
        }
        currentLine = inputReader.readCurrentLine();
      }
    } finally {
      inputReader.closeReader();
    }
    printResults();
  }

  private void printResults() {
    for (Property property : propertiesList) {
      Statistics.printResults(property.getLogMessage(), property.getMap(), property.getCounter());
    }
  }
}
