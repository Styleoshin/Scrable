import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sample.Square;

import java.util.ArrayList;

public class Rack extends Pane {
    private ArrayList<Square> listSquare = new ArrayList<Square>();;
    private HBox layout = new HBox(+5);

    public void lockTiles() {
        for(int i =0; i<listSquare.size(); ++i) {
            listSquare.get(i).setTileLocked(true);
        }
    }

    public void unlockTiles() {
        for(int i =0; i<listSquare.size(); ++i) {
            listSquare.get(i).setTileLocked(false);
        }
    }

    public void addSquare(Square square) {
            listSquare.add(square);
            layout.getChildren().add(square);
    }

    public void removeSquare(Square square) {
        listSquare.remove(square);
        layout.getChildren().remove(square);
    }
}

