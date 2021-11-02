import java.io.*;
import java.util.*;

public class P1607D {
  public static void main(String[] args) {
    SpeedScanner in = new SpeedScanner();
    int t = in.nextInt();
    while(t-- != 0) {
      int n = in.nextInt(), a[] = new int[n];
      char[] letters;
      boolean ans = true;

      for(int i = 0; i < n; ++i)
        a[i] = in.nextInt();
      
      letters = in.nextLine().toCharArray();
      List<Integer> blue = new ArrayList<>();
      List<Integer> red = new ArrayList<>();
      for(int i = 0; i < n; ++i)
        if(letters[i] == 'B')
          blue.add(a[i]);
        else
          red.add(a[i]);

      Collections.sort(blue);
      Collections.sort(red);

      for(int i = 1; i < blue.size(); ++i)
        if(blue.get(i) == blue.get(i - 1))
          ans = false;

      for(int i = 1; i < red.size(); ++i)
        if(red.get(i) == red.get(i - 1))
          ans = false;

      System.out.println(ans ? "YES" : "NO");        
    }
  }

  static class BR implements Comparable<BR> {
    int index, value;

    BR(int index, int value){
        this.index = index;
        this.value = value;
    }

    public int compareTo(BR e) {
        return this.value - e.value;
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
