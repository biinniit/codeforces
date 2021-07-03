import java.io.*;
import java.util.*;

// not working
public class P1538C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), l = in.nextInt(), r = in.nextInt(), a[] = new int[n], pairs = 0;
      for(int i = 0; i < n; ++i)
        a[i] = in.nextInt();
      Arrays.sort(a);
      int templ = -1, tempr = n;
      while(a[--tempr] >= r);
      try {
        while(a[++templ] + a[tempr] < l);
      } catch(ArrayIndexOutOfBoundsException e) {
        templ = n;
      }
      while(templ < tempr) {
        int tempsum = a[templ] + a[tempr];
        if(tempsum <= r) {
          int i = tempr;
          for( ; i > templ; --i)
            if(l <= a[templ] + a[i])
              break;
          pairs += i - templ;
          ++templ;
        }
        else
          --tempr;
      }
      System.out.println(pairs);
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
