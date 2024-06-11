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

      long maxLocations = 0;
      for (int i = 1; i <= B[0]; ++i)
        for (int j = i; j <= B[1]; ++j)
          if (k % (i * j) == 0 && k / i / j <= B[2]) {
            long third = k / i / j;
            long locations = (B[0] - i + 1) * (B[1] - j + 1) * (B[2] - third + 1);
            if (locations > maxLocations) 
              maxLocations = locations;
          }

      System.out.println(maxLocations);
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
