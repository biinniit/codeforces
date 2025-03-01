import java.io.*;
import java.util.*;

public class P1484B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), a[] = new int[n], firstInc = 0;
      if(n == 1) {
        System.out.println("0");
        continue;
      }
      boolean arbLarge = true, met1stInc = false;
      for(int i = 0; i < n; ++i) {
        a[i] = in.nextInt();
        if(i > 0) {
          if(a[i] - a[i - 1] != a[1]- a[0])
            arbLarge = false;
          if(!met1stInc && a[i] > a[i - 1]) {
            firstInc = i;
            met1stInc = true;
          }
        }
      }
      if(arbLarge) {
        for(int i = 2, c = a[1] - a[0]; i < n; ++i)
          if(a[i] - a[i - 1] != c) {
            arbLarge = false;
            break;
          }
        System.out.println(arbLarge ? "0" : "-1");
      }
      else if(!met1stInc)
        System.out.println("-1");
      else {
        int c = a[firstInc] - a[firstInc - 1], m = 0, max = a[0];
        boolean impossible = false;
        for(int i = 1; i < n; ++i) {
          if(a[i] > a[i - 1]) {
            if(a[i] - a[i - 1] != c) {
              impossible = true;
              break;
            }
          }
          else if(a[i] < a[i - 1])
            m = a[i - 1] - a[i] + c;
          else {
            impossible = true;
            break;
          }
          if(a[i] > max)
            max = a[i];
        }
        if(max >= m) {
          impossible = true;
        }
        if(impossible)
          System.out.println("-1");
        else
          System.out.println(m + " " + c);
      }
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
