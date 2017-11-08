package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GameWindow extends Pane {

    private Board board = null ;
    private Rack rack = null;

    private Pane paneTop = new Pane();
    private Pane paneBot = new Pane();

    private ArrayList<Pane> panes;

    private Button buttonAbandon = new Button("Abandon",new ImageView(getClass().getResource("/res/abandon.png").toExternalForm()));
    private Button buttonExchange = new Button("Exchange",new ImageView(getClass().getResource("/res/exchange.png").toExternalForm()));
    private Button buttonNext = new Button("Next",new ImageView(getClass().getResource("/res/Next.png").toExternalForm()));
    private Button buttonStart = new Button("Start",new ImageView(getClass().getResource("/res/Start.png").toExternalForm()));

    private HBox layoutPlayer = new HBox(+5);
    private BorderPane borderPane = new BorderPane();

    GameWindow(Board board, Rack rack) {
        this.board = board;
        this.rack = rack;
        initTopPane();
        initBotPane();
        borderPane.setTop(paneTop);
        borderPane.setCenter(board);
        borderPane.setBottom(paneBot);
    }

    private void initBotPane() {
        Button buttonInventory = new Button("",new ImageView(getClass().getResource("/res/sac.png").toExternalForm()));
        HBox layout = new HBox(10);

        layout.getChildren().add(buttonAbandon);
        layout.getChildren().add(buttonInventory);
        layout.getChildren().add(rack);
        layout.getChildren().add(buttonExchange);
        layout.getChildren().add(buttonNext);

        paneBot.getChildren().add(layout);
    }

    public void addPlayer(Player player) {
        VBox layout = new VBox(10);
        Label name = new Label(player.getName());
        Label score = new Label(new Integer(player.getScore()).toString());
        layout.getChildren().add(name);
        layout.getChildren().add(score);

        Pane pane = new Pane();
        pane.getChildren().add(layout);
        panes.add(pane);

        layoutPlayer.getChildren().add(pane);
    }

    public void addButtonStart() {
        borderPane.setLeft(buttonStart);
    }

    private void initTopPane() {
        Button buttonDictionary = new Button("Dictionary",new ImageView(getClass().getResource("/res/dictionary.png").toExternalForm()));
        Button buttonChat = new Button("Chat",new ImageView(getClass().getResource("/res/chat.png").toExternalForm()));

        HBox layout = new HBox(30);

        layout.getChildren().add(layoutPlayer);
        layout.getChildren().add(buttonDictionary);
        layout.getChildren().add(buttonChat);

        paneTop.getChildren().add(layout);
    }
}

