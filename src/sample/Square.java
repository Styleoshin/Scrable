package sample;

public class Square extends Sprite {
    private boolean tileLocked = false;

    Square(String filenameImage) {
        super(filenameImage);
    }

    public boolean isTileLocked() {
        return tileLocked;
    }

    public void setTileLocked(boolean tileLocked) {
        this.tileLocked = tileLocked;
    }
}
