//Client.java

import java.net.*;

public class Client {

    public static void main(String[] args) {
        try {
            int port = Integer.parseInt(args[0]);
            Socket socket = new Socket(args[1], port);
            System.err.println("Connected to " + args[1] + " on port " + port);
            new ReadWriteThread(socket.getInputStream(), System.out,"-->").start();
            new ReadWriteThread(System.in, socket.getOutputStream(),"-->").start();
        }catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java Client <port> [host]");
        }
    }
}
