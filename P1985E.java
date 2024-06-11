import java.io.*;
import java.util.*;

public class P1985E {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int[] B = {in.nextInt(), in.nextInt(), in.nextInt()};
      long k = in.nextLong();

      Arrays.sort(B);

      Long minDiff = Long.MAX_VALUE;
      long[] S = {1, 1, k};
      for (int i = 1; i <= B[0]; ++i) {
        if (k % i == 0) {
          for (int j = i; j <= B[1]; ++j) {
            if ((k / i) % j == 0) {
              long third = k / (i * j);
              if (third - i < minDiff) {
                minDiff = third - i;
                S[0] = i;
                S[1] = j;
                S[2] = third;
              }
            }
          }
        }
      }

      Arrays.sort(S);

      if (S[2] <= B[2])
        System.out.println((B[0] - S[0] + 1) * (B[1] - S[1] + 1) * (B[2] - S[2] + 1));
      else
        System.out.println(0);
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
