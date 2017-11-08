package sample.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {

    private ServerSocket server;
    private Socket socket ;

    NetworkServer() throws IOException {
        socket = server.accept();
    }

    public void connect(int port, int numberPlayer) throws IOException {
            server = new ServerSocket(port, numberPlayer);
        }
}

