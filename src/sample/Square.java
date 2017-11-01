package sample;

class Tile {
    private char letter ;
    private int score = 0;
    private boolean isBlank = false;
    private  boolean placed = false;

    Tile(char letter, int score, boolean isBlank) {
        this.letter = letter;
        this.score = score;
        this.isBlank = isBlank;
    }

    public int getScore() {
        return score;
    }

    public boolean isBlank() {
        return isBlank;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}

public class Square extends Sprite {
    private boolean tileLocked = false;
    private Tile tile = null;

    Square(String filenameImage) {
        super(filenameImage);
    }

    public boolean isTileLocked() {
        return tileLocked;
    }

    public void setTileLocked(boolean tileLocked) {
        this.tileLocked = tileLocked;
    }
        Square(String filenameImage, char letter, int score, boolean isBlank){
            super(filenameImage);
            tile = new Tile(letter, score, isBlank);
        }
}

