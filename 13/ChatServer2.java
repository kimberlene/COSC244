// ChatServer2.java

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer2 {

   private static List<ClientHandler> clients = new LinkedList<ClientHandler>();

   public static void main(String[] args) {
      try {
         new ChatServer2().startServer(Integer.parseInt(args[0]));
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println("\nUsage: java ChatServer2 <port>");
      }
   }

   public void startServer(int port) throws Exception {
      ServerSocket serverSocket = new ServerSocket(port);
      System.err.println("ChatServer2 started, listening on port " + serverSocket.getLocalPort());
      while (true) {
         ClientHandler ch = new ClientHandler(serverSocket.accept());
         System.err.println("Clients ID is " + ch);
         synchronized (clients) {
            clients.add(ch);
         }
         ch.start();
      }
   }

   public static void sendAll(String line, ClientHandler sender) {
      System.err.println("Sending '" + line + "' to : " + clients);
      synchronized (clients) {
         for (ClientHandler cl : clients) {
            cl.send(sender + ": " + line);
         }
      }
   }

   public static class ClientHandler extends Thread {

      private BufferedReader input;
      private PrintWriter output;
      private String id;
      private static int count = 0;

      public ClientHandler(Socket socket) throws Exception {
         input = new BufferedReader(
               new InputStreamReader(socket.getInputStream()));
         output = new PrintWriter(socket.getOutputStream(), true);
         id = "client_" + ++count;
         System.err.println("Clients host " + socket.getInetAddress() +
                            " Clients port " + socket.getPort());
         System.err.println("Local port " + socket.getLocalPort());
      }

      public void send(String line) {
         output.println(line);
      }

      public String toString() {
         return id;
      }

      public void run() {
         try {
            send("Welcome! You are " + this + ".");
            String line;
            while ((line = input.readLine()) != null) {
               sendAll(line, this);
            }
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            synchronized (clients) {
               clients.remove(this);
            }
            System.err.println(this + " closed connection!");
         }
      }
   }
}
