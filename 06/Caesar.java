import java.io.*;
class Caesar {
    public static void main(String [] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;
        int i=0;
        int output=0;
        while((i=in.read()) != -1) {
            output = i+ Integer.parseInt(args[0]);
            if(output < 255) {
                out.write((char)output);
            }
            else {
                output = i + (Integer.parseInt(args[0])%255);
                out.write((char)output);
                
            }
        }
        out.close();
    }
}
