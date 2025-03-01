import java.io.*;
import java.util.*;

public class P1671A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    outer: while(t-- != 0) {
      char[] s = in.nextLine().toCharArray();
      char prev = ' ';
      int count = 0;
      
      for(char c: s) {
        if(c != prev) {
          if(count == 1) {
            System.out.println("NO");
            continue outer;
          }
          count = 1;
        } else if(c == prev)
          ++count;
        prev = c;
      }
      
      if(count == 1)
        System.out.println("NO");
      else
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
