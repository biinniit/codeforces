import java.io.*;
import java.util.*;

public class P1534B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      long n = in.nextInt(), initUgly, ugly;
      initUgly = ugly = Integer.MIN_VALUE;
      int[] bars = new int[(int) n];

      for(int i = 0; i < n; ++i) {
        bars[i] = in.nextInt();
        if(i == 0)
          initUgly = bars[i];
        else if(i == n - 1) {
          initUgly += Math.abs(bars[i] - bars[i - 1]);
          initUgly += bars[i];
        }
        else if(i > 0 && i < n - 1)
          initUgly += Math.abs(bars[i] - bars[i - 1]);
      }

      ugly = initUgly;
      for(int i = 0; i < n; ++i)
        if(i > 0 && i < n - 1)
          if(bars[i] >= bars[i - 1] && bars[i] >= bars[i + 1]) {
            int localTaller = Math.max(bars[i - 1], bars[i + 1]);
            ugly -= bars[i] - localTaller;
            bars[i] = localTaller;
          }
          else;
        else if(i == 0) {
          if(n == 1)
            break;
          else if(bars[i] >= bars[i + 1]) {
            ugly -= bars[i] - bars[i + 1];
            bars[i] = bars[i + 1];
          }
        }
        else if(i == n - 1)
          if(bars[i] >= bars[i - 1])
            ugly -= bars[i] - bars[i - 1];

      System.out.println(ugly);
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
