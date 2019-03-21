import java.io.*;
class Exercise9 {

    public static void main(String [] args) {
        int i=0;
        int count=0;
        if(args.length > 0) {
            try {
            count = Integer.parseInt(args[1]);
            for (i=0; i<count; i++) {
            System.out.println(args[0]);
            }
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[1] + " must be an Interger");
                System.exit(1);
            }
        }
    }
}
