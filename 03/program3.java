import java.util.Scanner;
import java.io.*;

class program3 {
    public static void main(String args[]) {
        System.out.println("Enter something to convert it to upper case");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String upper = line.toUpperCase();
        System.out.println(upper);
    }
}
