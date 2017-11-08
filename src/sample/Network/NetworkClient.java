package sample.Network;

import java.io.IOException;
import java.net.Socket;

public class NetworkClient {

    private Socket socket;

    public void connect(String ip, int port ) throws IOException {
      socket = new Socket(ip,port);
    }
}