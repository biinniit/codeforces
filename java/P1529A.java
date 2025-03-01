import java.io.*;
import java.util.*;

public class P1529A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), a[] = new int[n], min = Integer.MAX_VALUE;
      Map<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < n; ++i) {
        if(map.get(a[i] = in.nextInt()) == null)
          map.put(a[i], 1);
        else
          map.put(a[i], map.get(a[i]) + 1);
        if(a[i] < min)
          min = a[i];
      }
      System.out.println(n - map.get(min));
    }
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
