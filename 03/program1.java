import java.io.*;
class program1{
    public static void main(String args[]) {
        InputStream in = System.in;
        OutputStream out = System.out;
        int i;
        System.out.println("Type something");
        try {
            while((i=in.read()) != -1) {
                out.write((char)i);
            }
            
        } catch(IOException e) {
            System.out.println("End of buffer reached");
        }
    }
}
