package sample;

abstract public class Player {
    private int score = 0;
    private String name;

    Player(String name) {
        this.name = name;
    }

    private void addScore(int newScore ){
        score+=newScore;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
