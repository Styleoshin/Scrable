package sample.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class AcceptClient implements Runnable {

    private ServerSocket socketserver;
    private Socket socket;
    public AcceptClient(ServerSocket s){
        socketserver = s;
    }

    public void run() {

        try {
            while(true){
                socket = socketserver.accept();
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class NetworkServer {

    private ServerSocket server;
    private Socket socket ;

    public void connect(int port, int numberPlayer) throws IOException {
<<<<<<< HEAD
            server = new ServerSocket(port, numberPlayer);
        }
=======
        server = new ServerSocket(port, numberPlayer);
        Thread t = new Thread(new AcceptClient(server));
        t.start();
    }
>>>>>>> d4c31f4... Fix crash Network
}

