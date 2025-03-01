import java.io.*;
import java.util.*;

public class P1666A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    char[] description = in.nextLine().toCharArray();
    long admissibles = 0;

    outer: for(int i = 0; i < description.length; ++i) {
      int x = 0, y = 0;
      for(int j = i + 1; j < description.length; j += 2) {
        switch(description[j - 1]) {
          case 'U': --y; break;
          case 'L': --x; break;
          case 'D': ++y; break;
          case 'R': ++x; break;
        }
        if(x < 0 || y < 0) continue outer;
        switch(description[j]) {
          case 'U': --y; break;
          case 'L': --x; break;
          case 'D': ++y; break;
          case 'R': ++x; break;
        }
        if(x < 0 || y < 0) continue outer;
        if(x == 0 && y == 0) ++admissibles;
      }
    }

    System.out.println(admissibles);
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
