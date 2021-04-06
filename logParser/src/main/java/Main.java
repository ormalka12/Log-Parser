import constants.Constants;


public class Main {
  public static void main(String[] args) throws Exception {
    Parser parser = new Parser(Constants.LOG_PATH.getValue());
    parser.start();

  }
}
