import java.io.*;
import java.util.*;

public class P1527B {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int size = in.nextInt(), $a = 0, $b = 0, i;
      char[] string = in.nextLine().toCharArray();
      boolean alice = true, lastReversed = false;

      for(i = 0; i < size; ++i)
        if(string[i] == '1' && string[size - i - 1] == '0')
          break;
      if(i == size)
        for(i = 0; i < size && string[i] == '1'; ++i);

      while(i < size) {
        if(!isPalindrome(string) && !lastReversed) {
          lastReversed = true;
          alice = !alice;
        }
        else {
          if(alice) ++$a; else ++$b;
          lastReversed = false;
          alice = !alice;
          string[i] = '1';
          for(i = 0; i < size; ++i)
            if(string[i] == '1' && string[size - i - 1] == '0')
              break;
          if(i == size)
            for(i = 0; i < size && string[i] == '1'; ++i);
        }
      }

      System.out.println(($a == $b ? "DRAW" : $a < $b ? "ALICE" : "BOB") + ", $a = " + $a + ", $b = " + $b);
    }
  }
  
  static boolean isPalindrome(char[] n) {
    int length = n.length, midpoint = length / 2;
    for(int i = 0; i < midpoint; ) {
      if(n[i] != n[length - ++i])
        return false;
    }
    return true;
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
