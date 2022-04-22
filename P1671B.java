import java.io.*;
import java.util.*;

public class P1671B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    outer: while(t-- != 0) {
      int n = in.nextInt(), x[] = new int[n], LIMIT = 2, diff = 0;
      for(int i = 0; i < n; x[i++] = in.nextInt());
      for(int i = 0, prev = x[i]; i < n; ++i) {
        if(x[i] - prev > 1) {
          if((diff += x[i] - prev - 1) > LIMIT) {
            System.out.println("NO");
            continue outer;
          }
        }
        prev = x[i];
      }
      System.out.println("YES");
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
