package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class BookShopClient {

    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int SERVER_PORT = 1234;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            // Прочитаме съобщение от сървъра
            System.out.println(in.readLine());

            while (true) {
                System.out.print("Enter command: ");
                String command = scanner.nextLine();
                out.println(command);

                String response = in.readLine();
                System.out.println("Server: " + response);

                if (command.equalsIgnoreCase("EXIT")) break;
            }

        } catch (IOException e) {
            System.err.println("Client exception: " + e.getMessage());
        }
    }
}
