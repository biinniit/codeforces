import java.io.*;
import java.util.*;

public class P102942D {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    outer: while(t-- != 0) {
      int a = in.nextInt(), b = in.nextInt(), x = b, bits = 0, max = -1;
      do max <<= 1; while((x >>= 1) != 0);
      max = 1 + ~max;
      for(x = (a ^ b) + 1; x < max; ++x)
        if((x ^ a) <= b || (x ^ b) <= a) {
          System.out.println("Yes");
          continue outer;
        }
      System.out.println("No");
    }
  }

  private static class SpeedScanner {
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
