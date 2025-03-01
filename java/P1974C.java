import java.io.*;
import java.util.*;

public class P1974C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int n = in.nextInt(), ans = 0;
      int[] a = new int[n];

      for (int i = 0; i < n; a[i++] = in.nextInt());

      for (int i = 0; i < n - 3; ++i)
        for (int j = i + 1; j < n - 2; ++j) {
          // System.out.printf("b = [%d, %d, %d]; c = [%d, %d, %d];\n", a[i], a[j], a[i + 1], a[j + 1], a[i + 2], a[j + 2]);
          if ((a[i] == a[j] ? 1 : 0)
            + (a[i + 1] == a[j + 1] ? 1 : 0)
            + (a[i + 2] == a[j + 2] ? 1 : 0) == 2)
              ++ans;
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
