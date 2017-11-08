package sample.Network;

import sample.Player;

import java.io.IOException;

public class Host extends Player {

    private NetworkServer network;

    Host(String name, int port, int numberPlayer) throws IOException {
        super(name);
        network.connect(port, numberPlayer);
    }
}

