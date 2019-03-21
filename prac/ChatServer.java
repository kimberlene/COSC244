import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static List<ClientHandler> clients = new LinkedList<ClientHandler> ();

    public static void main(String args[]) {
        try {
            new ChatServer().startServer(Integer.parseInt(args[0]));
        }
        catch(IOException e) {
            e.printStackTrace();
            Sytem.err.println("\nUsage: java ChatServer <port> ");
        }
    }

    public void startServer(int port)throws IOException {
        ServerSocket serverSocket = new severSocket(port);
        System.err.println("ChatServer started");
        while(true) {
            ClientHandler ch = new ClientHandler(serverSocket.accept());
            synchronised(clients) {
                clients.add(ch);
            }
            ch.start();
        }
    }

    public static void sendAll(String line, ClientHandler sender) {
    }

public class ReadWriteThread extends Thread {

    private BufferedReader input;
    private PrintWriter output;
    private String prefix;

    public ReadWriteThread(InputStream input, OutputStream output, String prefic) {
        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = new PrintWriter(output, true);
        this.prefix = prefix;
    }

    public void run() {
        try {
            String line;
            while((line = input.readLine())!=null) {
                output.println(prefix + line);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
    }
}
