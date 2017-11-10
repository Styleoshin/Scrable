package sample.Network;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NetworkManager {

    private Host host = null;
    private Client client = null;

    public void createHost(HashMap<String, String> informations) throws IOException {

        HashMap<String, String> selects = informations;
        String name = null;
        int port = 0;
        int numberPlayer = 0;

        for(Map.Entry<String, String> entry : selects.entrySet()) {
            if(entry.getKey() == "port"){
                port = Integer.parseInt(entry.getValue());
            } else if (entry.getKey() == "name") {
                name = entry.getValue();
            } else if (entry.getKey() == "numberPlayer") {
                numberPlayer = Integer.parseInt(entry.getValue());
            }
        }
        host = new Host(name,port, numberPlayer);
    }

     public void createClient(HashMap<String, String> informations) throws IOException {

        HashMap<String, String> selects = informations;
        String name = null;
        String ip = null;
        int port = 0;

        for(Map.Entry<String, String> entry : selects.entrySet()) {
            if(entry.getKey() == "port"){
                port = Integer.parseInt(entry.getValue());
            } else if (entry.getKey() == "name") {
                name = entry.getValue();
            } else if (entry.getKey() == "ip") {
                ip = entry.getValue();
            }
        }
        client = new Client(name, ip, port);
    }


}
