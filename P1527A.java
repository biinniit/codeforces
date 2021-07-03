import java.io.*;
import java.util.*;

public class P1527A {
  static Map<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    map.put(1, 0);
    while(t-- != 0)
      System.out.println(findK(in.nextInt()));
  }

  static int findK(int n) {
    if(map.containsKey(n))
      return map.get(n);
    else if((n & n - 1) == 0) {
      map.put(n, n - 1);
      return n - 1;
    }
    map.put(n, findK(n & n - 1));
    return map.get(n);
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
