import java.io.*;
import java.util.*;

public class P1602A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      String s = in.nextLine(), ans;
      int low = 0;
      for(int i = 0; i < s.length(); ++i)
        if(s.charAt(i) < s.charAt(low))
          low = i;
      if(low == 0)
        ans = s.charAt(0) + " " + s.substring(1);
      else if(low == s.length() - 1)
        ans = s.charAt(low) + " " + s.substring(0, low);
      else
        ans = s.charAt(low) + " " + s.substring(0, low) + s.substring(low + 1);
      System.out.println(ans);
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
