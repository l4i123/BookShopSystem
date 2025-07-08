package Server;


import Helper.DBConnection;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class BookShopServer {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (
            ServerSocket serverSocket = new ServerSocket(PORT);
            Connection connection = DBConnection.getConnection(); 
        ) {
            System.out.println("BookShop Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected.");
                ClientHandler handler = new ClientHandler(clientSocket, connection);
                new Thread(handler).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
