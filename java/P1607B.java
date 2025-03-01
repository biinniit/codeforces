import java.io.*;
import java.util.*;

public class P1607B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      long x = in.nextLong(), n = in.nextLong();
      switch((int) (n % 4)) {
        case 0:
          System.out.println(x);
          break;
        case 1:
          System.out.println(x % 2 == 0 ? x - n : x + n);
          break;
        case 2:
          System.out.println(x % 2 == 0 ? x + 1 : x - 1);
          break;
        case 3:
          System.out.println(x % 2 == 0 ? x + n + 1 : x - n - 1);
          break;
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
      while(splitter == null || !splitter.hasMoreElements())
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
