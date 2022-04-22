import java.io.*;
import java.util.*;

public class P1671C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), budget = in.nextInt(), largest = 0, ans = 0;
      long[] cost = new long[n];
      for(int i = 0; i < n; cost[i++] = in.nextInt());
      Arrays.sort(cost);
      for(int i = 1; i < n && cost[i - 1] <= budget; cost[i] += cost[i++ - 1], largest = i - 1);
      ans = cost[0] <= budget ? largest + 1 : 0;
      for(int day = 1, i; cost[0] + day <= budget; ++day) {
        for(i = largest; cost[i] + day * (i + 1) > budget; --i);
        largest = i;
        ans += largest + 1;
      }
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
