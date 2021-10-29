import java.io.*;
import java.util.*;

public class P1606A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      char[] s = in.nextLine().toCharArray();
      int ab = 0;
      if(s.length == 1) {
        System.out.println(new String(s));
        continue;
      }

      for(int i = 0; i < s.length - 1; ++i)
        if(s[i + 1] - s[i] == 1)
          ++ab;
        else if(s[i + 1] - s[i] == -1)
          --ab;

      if(ab != 0)
        s[0] = s[0] == 'a' ? 'b' : 'a';

      System.out.println(new String(s));
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
