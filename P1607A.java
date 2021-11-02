import java.io.*;
import java.util.*;

public class P1607A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      String list = in.nextLine();
      char[] word = in.nextLine().toCharArray();
      int ans = 0;

      if(word.length == 1) {
        System.out.println(0);
        continue;
      }

      for(int i = 0; i < word.length - 1; ++i)
        ans += Math.abs(list.indexOf(word[i]) - list.indexOf(word[i + 1]));

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
