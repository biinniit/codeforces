import java.io.*;
import java.util.*;

public class P102942C {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), min = in.nextInt(), student[] = new int[n];
      int singles = 0, doubles = 0, i, j;
      for(i = 0; i < n; ++i)
        if((student[i] = in.nextInt()) >= min) ++singles;
      Arrays.sort(student);
      for(i = n - singles - 1, j = 0; j < i; ++j)
        if(student[i] + student[j] >= min) break;
      for( ; j < i; --i, ++j)
        if(student[i] + student[j] >= min) ++doubles;
        else ++i;
      System.out.println(singles + doubles);
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
