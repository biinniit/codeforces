import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class P1980C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int n = in.nextInt(), m;
      int[] a = new int[n], b = new int[n], d;
      List<Integer> nonMatches = new ArrayList<>();
      for (int i = 0; i < n; a[i++] = in.nextInt());
      for (int i = 0; i < n; ++i) {
        b[i] = in.nextInt();
        if (b[i] != a[i]) nonMatches.add(i);
      }
      m = in.nextInt();
      d = new int[m];
      for (int j = 0; j < m; d[j++] = in.nextInt());

      if (IntStream.of(b).noneMatch(number -> number == d[m - 1])) {
        System.out.println("NO");
        continue;
      }

      for (int j = m - 1; j >= 0 && nonMatches.size() > 0; --j)
        for (int i = 0; i < nonMatches.size(); ++i)
          if (d[j] == b[nonMatches.get(i)]) {
            nonMatches.remove(i);
            break;
          }

      if (nonMatches.isEmpty())
        System.out.println("YES");
      else
        System.out.println("NO");
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
