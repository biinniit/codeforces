import java.io.*;
import java.util.*;

public class P1974B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();

    while (t-- != 0) {
      int n = in.nextInt();
      String b = in.nextLine();
      Set<Character> rSet = new TreeSet<>();
      char[] ans = new char[b.length()];

      for (char c: b.toCharArray()) {
        rSet.add(c);
      }
      List<Character> r = new ArrayList<>();
      r.addAll(rSet);
      int rSize = r.size();

      for (int i = 0; i < n; ++i)
        ans[i] = r.get(rSize - r.indexOf(b.charAt(i)) - 1);

      System.out.println(new String(ans));
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
