import java.io.*;
import java.util.*;

public class P1980B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int n = in.nextInt(), f = in.nextInt(), k = in.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; a[i++] = in.nextInt());

      f = a[f - 1];

      Arrays.sort(a);
      k = n - k;

      if (f < a[k])
        System.out.println("NO");
      else if (f == a[k] && (k != 0 && f == a[k - 1]))
        System.out.println("MAYBE");
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
      while (splitter == null || !splitter.hasMoreElements())
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
