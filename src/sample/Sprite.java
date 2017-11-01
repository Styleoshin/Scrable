package sample;

import javafx.scene.image.ImageView;

public class Sprite extends ImageView{
    Sprite(String filename) {
        super(filename);
        setFitHeight(50);
        setPreserveRatio(true);
    }
}
