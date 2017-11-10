package sample.Network;

import sample.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public interface NetworkReader {

    public ArrayList<Player> readPlayers(ObjectInputStream object) throws IOException, ClassNotFoundException;
}
