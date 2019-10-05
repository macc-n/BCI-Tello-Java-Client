package BCI;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    private Socket clientSocket;
    private String address;
    private int port;
    private boolean socketIsClosed = false;
    private static final char stopChar = ';';

    public TCPClient(String address, int port) {
        try {
            this.address = address;
            this.port = port;
            this.clientSocket = new Socket(address, port);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendToServer(String message) {
        try {
            if (socketIsClosed) {
                this.clientSocket = new Socket(address, port);
            }
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(message + stopChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket() {
        try {
            clientSocket.close();
            socketIsClosed = true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}