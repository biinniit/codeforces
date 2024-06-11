import java.io.*;
import java.util.*;

public class P1985D {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int n = in.nextInt(), m = in.nextInt(), h = 0, k = 0;
      long prevLineCount = 0;

      for (int i = 0; i < n; ++i) {
        String line = in.nextLine();
        long count = line.chars().filter(ch -> ch == '#').count();
        if (count < prevLineCount)
          continue;
        if (count > 0) {
          h = i + 1;
          k = (line.indexOf('#') + line.lastIndexOf('#')) / 2 + 1;
        }
        prevLineCount = count;
      }

      System.out.printf("%d %d\n", h, k);
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
