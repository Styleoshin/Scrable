package sample.Network;

import sample.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class NetworkStream implements NetworkReader, NetworkWritter {

    @Override
    public ArrayList<Player> readPlayers(ObjectInputStream objectSocket) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(objectSocket);
        Object object = in.readObject();

        ArrayList<Player> players  = (ArrayList<Player>) object;
        return players;
    }

    @Override
    public void writePlayer(OutputStream objectSocket, ArrayList<Player> players) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(objectSocket);
        out.writeObject(players);
    }
}
