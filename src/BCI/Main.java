package BCI;

import java.io.*;
import java.net.*;

public class Main  {

    public static void main(String argv[]) {
        TCPClient client = new TCPClient("localhost", 5001);
        String message = "";
        while (true) {
            System.out.println("Available actions:");
            int cn = 1;
            for (String cmd : Constants.getActions()) {
                System.out.println(cn + " - " + cmd);
                cn++;
            }
            System.out.print("Execute: ");
            message = readMessage();
            if (message.equals("exit")) {
                client.sendToServer(message);
                break;
            }
            try {
                int executeCommand = Integer.parseInt(message) - 1;
                System.out.println("Selected action: " + Constants.getAction(executeCommand));
                client.sendToServer(Constants.getAction(executeCommand));
            } catch (Exception e) {
                System.out.println("Wrong input");
                System.out.println("Example: 1");
            }
        }
        client.closeSocket();
    }

    private static String readMessage() {
        String sentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        try {
            sentence = inFromUser.readLine();
            return sentence;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}