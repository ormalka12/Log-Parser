package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
  BufferedReader reader;

  public void createReader(String filePath) throws FileNotFoundException {
    reader = new BufferedReader(new FileReader(filePath));
  }

  public String readCurrentLine() throws IOException {
    String currentLine = reader.readLine();
    return currentLine;
  }

  public void closeReader() throws IOException {
    reader.close();
  }

}