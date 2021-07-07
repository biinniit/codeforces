import java.io.*;
import java.util.*;

public class P1543A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      long a = in.nextLong(), b = in.nextLong(), diff = Math.abs(a - b), moves = 0;
      if(a == b) {
        System.out.println("0 0");
        continue;
      }
      System.out.println(diff + " " + Math.min(a % diff, diff - (a % diff)));
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
