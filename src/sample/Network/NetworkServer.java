package sample.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {

    private ServerSocket server;
    private Socket socket ;

    public void connect(int port, int numberPlayer) throws IOException {
<<<<<<< HEAD
            server = new ServerSocket(port, numberPlayer);
        }
=======
        server = new ServerSocket(port, numberPlayer);
        socket = server.accept();
    }
>>>>>>> d4c31f4... Fix crash Network
}

