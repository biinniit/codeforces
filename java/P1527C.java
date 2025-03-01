import java.io.*;
import java.util.*;

public class P1527C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    int[] a;
    Map<Integer, Integer> occurs = new HashMap<>();
    while(t-- != 0) {
      int n = in.nextInt();
      boolean distinct = true;
      if(n == 1)
        System.out.println(0);

      a = new int[n];
      for(int i = 0; i < n; ++i) {
        occurs.put(a[i] = in.nextInt(), occurs.get(a[i]) == null ? 1 : occurs.get(a[i]) + 1);
        if(occurs.get(a[i]) > 1)
          distinct = false;
      }
      
      if(distinct)
        System.out.println(0);
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
