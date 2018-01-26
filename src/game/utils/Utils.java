package game.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

  public static String loadFileAsString(String path) {
    StringBuilder s = new StringBuilder();

    try {
      BufferedReader br = new BufferedReader(new FileReader(path));
      String l;
      while ((l = br.readLine()) != null) {
        s.append(l + "\n");
      }
      br.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return s.toString();
  }

  public static int parseInt(String number) {
    try {
      return Integer.parseInt(number);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      return 0;
    }
  }

}
