import java.io.*;
import java.util.*;

public class P1974A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int x = in.nextInt(), y = in.nextInt();
      int screensY = y / 2 + y % 2;
      int screensX = x / 7 + (x % 7 == 0 ? 0 : 1);

      if (screensY >= screensX)
        System.out.println(screensY);
      else {
        if (y % 2 == 1) {
          if (x <= (y / 2 * 7) + 11) {
            screensX = screensY;
          } else {
            x = x - (y / 2 * 7) - 11;
            screensX = screensY;
            screensX += x / 15 + (x % 15 == 0 ? 0 : 1);
          }
        } else {
          x = x - (y / 2 * 7);
          screensX = screensY;
          screensX += x / 15 + (x % 15 == 0 ? 0 : 1);
        }

        System.out.println(screensX);
      }
    }
  }

  static class SpeedScanner {
    BufferedReader in;
    StringTokenizer splitter;
  
    public SpeedScanner() {
      in = new BufferedReader(new InputStreamReader(System.in));
    }
  
    String next() {
      while (splitter == null || !splitter.hasMoreElements())
        try {
          splitter = new StringTokenizer(in.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      return splitter.nextToken();
    }
  
    String nextLine() {
      String s = "";
      try {
        s = in.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return s;
    }
  
    int nextInt() {
      return Integer.parseInt(next());
    }
  
    long nextLong() {
      return Long.parseLong(next());
    }
  
    double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
