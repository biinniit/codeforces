import java.io.*;
import java.util.*;

public class P1607C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt();
      long maxMin, sum = 0, a[] = new long[n];;

      for(int i = 0; i < n; ++i)
        a[i] = in.nextInt();

      Arrays.sort(a);
      sum = maxMin = a[0];
      
      for(int i = 1; i < n; sum += a[i++]) {
        a[i] -= sum;
        if(a[i] > maxMin)
          maxMin = a[i];
      }

      System.out.println(maxMin);
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
