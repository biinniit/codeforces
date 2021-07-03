import java.io.*;
import java.util.*;

public class P1538A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), minI = 0, min = Integer.MAX_VALUE, maxI = 0, max = Integer.MIN_VALUE, ans = 0;
      for(int i = 0, temp; i < n; ++i) {
        temp = in.nextInt();
        if(temp < min) {
          minI = i;
          min = temp;
        }
        if(temp > max) {
          maxI = i;
          max = temp;
        }
      }
      if(minI < maxI)
        if(minI + 1 <= n - maxI)
          System.out.println(Math.min(minI + 1 + n - maxI, maxI + 1));
        else
          System.out.println(Math.min(minI + 1 + n - maxI, n - minI));
      else
        if(maxI + 1 <= n - minI)
          System.out.println(Math.min(maxI + 1 + n - minI, minI + 1));
        else
          System.out.println(Math.min(maxI + 1 + n - minI, n - maxI));
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
