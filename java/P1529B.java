import java.io.*;
import java.util.*;

public class P1529B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), a[] = new int[n], ans = 0;
      for(int i = 0; i < n; ++i)
        if((a[i] = in.nextInt()) < 1)
          ++ans;

      Arrays.sort(a);

      if(ans < n) {
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < ans; ++i)
          if(Math.abs(a[i] - a[i + 1]) < minDiff)
            minDiff = Math.abs(a[i] - a[i + 1]);

        if(minDiff >= a[ans])
          ++ans;
      }

      System.out.println(ans);
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
