import java.io.*;
import java.util.*;

public class P1604B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    outer: while(t-- != 0) {
      int n = in.nextInt(), a[] = new int[n];
      for(int i = 0; i < n; ++i)
        a[i] = in.nextInt();
      
      if((n & 1) == 0)
        System.out.println("YES");
      else {
        for(int i = 0; i < n - 1; ++i)
          if(a[i] >= a[i + 1]) {
            System.out.println("YES");
            continue outer;
          }

        System.out.println("NO");
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
