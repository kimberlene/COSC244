import java.util.Scanner;
import java.io.*;
class BitLevel {

    public static void main(String [] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream(args[1]); 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key");
        String key = sc.nextLine();
        
        int i=0, y=0, result=0;
        
        while( (in.available()) >0) {
            for(y=0; y<key.length(); y++) {
                i = in.read();
                result = i ^ ((int)(key.charAt(y)));
                out.write((char)result);
            }
            if(y == (key.length()-1)) {
                y=0;
            }
        }
        out.close();
    }
}
