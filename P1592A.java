import java.io.*;
import java.util.*;

public class P1592A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), H = in.nextInt(), max1 = 0, max1i = -1, max1cnt = 0, max2 = 0, a[] = new int[n], ans;
      for(int i = 0; i < n; ++i)
        if((a[i] = in.nextInt()) > max1) {
          max1 = a[i];
          max1i = i;
        }
      for(int i = 0; i < n; ++i) {
        if(a[i] > max2 && i != max1i)
          max2 = a[i];
        if(a[i] == max1)
          ++max1cnt;
      }
      
      if(max1cnt < 2) {
        ans = H / (max1 + max2) * 2;
        int mod = H % (max1 + max2);
        if(mod > 0 && mod <= max1)
          ++ans;
        if(mod > max1)
          ans += 2;
      }
      else
        ans = H / max1 + (H % max1 > 0 ? 1 : 0);
      
      System.out.println(ans);
    }
  }

  static class SpeedScanner {
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
