package sample.Network;

import sample.Player;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

interface NetworkWritter {

    void writePlayer(OutputStream object, ArrayList<Player> players) throws IOException;
}
