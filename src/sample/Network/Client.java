package sample.Network;

import sample.Network.NetworkClient;
import sample.Player;

import java.io.IOException;

public class Client extends Player {

    private NetworkClient network;

    Client(String name, String ip, int port) throws IOException {
        super(name);
        network.connect(ip,port);
    }
}

