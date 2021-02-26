import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P102942A {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), pos = 0;
      char[] s = in.nextLine().toCharArray();
      while(n > 0)
        if(s[--n] == '0') ++pos; else --pos;
      switch(pos & 0b11) {
        case 0:
          System.out.println('E');
          break;
        case 1:
          System.out.println('S');
          break;
        case 2:
          System.out.println('W');
          break;
        case 3:
          System.out.println('N');
          break;
      }
    }
  }
}

class SpeedScanner {
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
