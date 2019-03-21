import java.io.*;
import java.net.*;
import java.util.*;

public class TCPExample3 {

    private PrintWriter output;
    private BufferedReader input;

    public TCPExample3(Socket socket) throws Exception {
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    // SERVER - think of a socket as a pipe (input one end - output the other, visa versa)
    public void startReceiving() throws Exception {
        while(true){
            String line;
            System.err.println(">>THEM:");
            if ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            Scanner stdin = new Scanner(System.in);
            System.err.println(">>YOU:");
            if (stdin.hasNextLine()){
                output.println(stdin.nextLine());
            }
        }
    }

    // CLIENT - input here same as output of server and visa versa
    public void startSending() throws Exception {
        while(true){
            Scanner stdin = new Scanner(System.in);
            System.err.println(">>YOU:");
            if (stdin.hasNextLine()) {
                output.println(stdin.nextLine());
            }
            String line;
            System.err.println(">>THEM:");
            if ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {
        Socket socket = null;
        try{
            int port = Integer.parseInt(args[0]);
            if (args.length > 1) {
                socket = new Socket(args[1], port);
                System.err.println("Connected to " + args[1] + " on port " + port);
                TCPExample3 example = new TCPExample3(socket);
                example.startSending();
            }else{
                ServerSocket serverSocket = new ServerSocket(port);
                System.err.println("Waiting for someone to connect");
                socket = serverSocket.accept();
                System.err.println("Accepted connection on port " + port);
                TCPExample3 example = new TCPExample3(socket);
                example.startReceiving();
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\nUsage: java TCPExample <port> [host]");
        }
    }
}
