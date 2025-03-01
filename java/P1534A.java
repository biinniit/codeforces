import java.io.*;
import java.util.*;

public class P1534A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), m = in.nextInt();
      char[][] grid = new char[n][m];
      boolean red = true, started = false, failed = false;
      for(int i = 0; i < n; ++i)
        grid[i] = in.nextLine().toCharArray();

      outer: for(int i = 0; i < n; ++i, red = ((m & 1) == 0 ? !red : red))
        for(int j = 0; j < m; ++j) {
          if(grid[i][j] == 'R') {
            if(!started) red = started = true;
            else if(!red) {
              failed = true;
              break outer;
            }
            red = false;
          }
          else if(grid[i][j] == 'W') {
            if(!started) red = !(started = true);
            else if(red) {
              failed = true;
              break outer;
            }
            red = true;
          }
          else red = !red;
        }

      if(!failed) {
        System.out.println("YES");
        if((m & 1) == 0) red = !red;
        if(((n & 1) == 0 && (m & 1) == 0) || ((n & 1) == 1 && (m & 1) == 1)) red = !red;
        for(int i = 0; i < n; ++i, red = ((m & 1) == 0 ? !red : red)) {
          for(int j = 0; j < m; ++j, red = !red)
            System.out.print(red ? 'R' : 'W');
          System.out.println();
        }
      }
      else
        System.out.println("NO");
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
