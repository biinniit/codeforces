import java.io.*;
import java.util.*;

public class P2070C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int n = in.nextInt(), k = in.nextInt(), LIMIT = 1000000000, minPenalty = Integer.MAX_VALUE;
      String s = in.nextLine();
      int[] a = new int[n];
      for (int i = 0; i < n; ++i)
        a[i] = in.nextInt();

      // binary search with jumps
      for (int i = -1, jump = LIMIT / 2; jump >= 1; jump /= 2) {
        boolean colored = false;
        int coloredCount = 0;
        for (int c = 0; c < n; ++c) {
          if (a[c] <= i + jump)
            continue; // don't care about low penalties
          if (s.charAt(c) == 'B' && !colored) {
            if (++coloredCount > k) {
              // restart loop
              i += jump;
              c = -1;
              colored = false;
              coloredCount = 0;
            } else
              colored = true;
          } else if (s.charAt(c) == 'R' && colored)
            colored = false;
        }
        minPenalty = Math.min(minPenalty, i + jump);
      }

      System.out.println(minPenalty);
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
