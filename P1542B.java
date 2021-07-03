import java.io.*;
import java.util.*;

public class P1542B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      long n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
      if(a == 1)
        System.out.println((n - 1) % b == 0 ? "Yes" : "No");
      else {
        boolean ans = false;
        for(long i = 1; i <= n; i *= a)
          if((n - i) % b == 0) {
            ans = true;
            break;
          }
        System.out.println(ans ? "Yes" : "No");
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
