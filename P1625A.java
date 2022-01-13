import java.io.*;
import java.util.*;

public class P1625A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), l = in.nextInt();
      int[] positions = new int[l];
      for(int i = 0; i < n; ++i) {
        String num = Integer.toBinaryString(in.nextInt());
        if(num.length() < l) {
          int zeros = l - num.length();
          for(int j = 0; j < zeros; ++j)
            num = "0" + num;
        }
        for(int j = 0; j < l; ++j)
          positions[j] += num.charAt(j) == '0' ? 0 : 1;
      }

      String ans = "";
      for(int i: positions)
        ans += Math.round((double) i / n);
      
      System.out.println(Integer.parseInt(ans, 2));
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
