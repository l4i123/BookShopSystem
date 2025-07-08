

package Server;


import Service.UserService;
import Model.User;
import Helper.Constants;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final UserService userService;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.userService = new UserService(connection); // 🎯 свързване със Service
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Connected to BookShop Server!");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                handleCommand(inputLine); // 🎯 Тук ще реагираме на команди
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];

        switch (command.toUpperCase()) {
            case "LOGIN":
                if (parts.length < 3) {
                    out.println("Usage: LOGIN <email> <password>");
                    return;
                }
                String email = parts[1];
                String password = parts[2];
                User user = userService.getUserByEmail(email);
                if (user != null && userService.checkPassword(user, password)) {
                    out.println("Login successful! Welcome " + user.getUserName());
                } else {
                    out.println(Constants.ERROR_INVALID_CREDENTIALS);
                }
                break;

            default:
                out.println("Unknown command: " + command);
        }
    }
}
