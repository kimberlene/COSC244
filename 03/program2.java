import java.io.*;
import java.lang.*;
import java.lang.StringBuilder;

class program2 {
    public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter input");
      String line = br.readLine();
      StringBuilder str = new StringBuilder();
      str.append(line);
      System.out.println(str.reverse());
    } catch (IOException ioe) {
        ioe.printStackTrace();
   }
  }
}
