import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P1606C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), k = in.nextInt(), a[] = new int[n];
      for(int i = 0; i < n; ++i)
        a[i] = (int) Math.pow(10, in.nextInt());

      BigInteger ans = BigInteger.ZERO;
      int i;
      for(i = 0; i < n - 1; ++i) {
        if((a[i + 1] - a[i]) / a[i] <= k) {
          ans = ans.add(BigInteger.valueOf(a[i + 1] - a[i]));
          k -= (a[i + 1] - a[i]) / a[i];
        }
        else
          break;
      }
      ans = ans.add(BigInteger.valueOf(k + 1).multiply(BigInteger.valueOf(a[i])));
      
      System.out.println(ans.toString());
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
