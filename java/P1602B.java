import java.io.*;
import java.util.*;

public class P1602B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      /*
      int n = in.nextInt(), a[] = new int[2000], aCopy[] = new int[2000], A[] = new int[n];
      for(int i = 0; i < n; ++i) {
        A[i] = in.nextInt();
        ++a[A[i] - 1];
      }

      for(int i = 0; i < n; ++i)
        aCopy[i] = a[i];

      int queries[][] = new int[2][in.nextInt()], maxK = 0, valueAfter[] = new int[queries[0].length];
      for(int i = 0; i < queries[0].length; ++i) {
        queries[0][i] = in.nextInt();
        if((queries[1][i] = in.nextInt()) > maxK)
          maxK = queries[1][i];
      }
      
      for(int i = 0, qMark = 0; i < maxK; ++i) {
        for(int j = 0, number; j < n; ++j) {
          number = a[j];
          aCopy[j] -= number;
          aCopy[number] += number;
          A[] //-- I gave up here
        }

        for(int j = 0; j < queries[1].length; ++j) {
          if(queries[1][j] == i + 1) {
            valueAfter[j] = A[]
          }
        }
      }
      */
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
