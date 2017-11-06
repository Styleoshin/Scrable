package sample;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.util.Pair;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
class MenuItem extends Pane {
    private Text text;

    private Effect shadow = new DropShadow(5, Color.BLACK);
    private Effect blur = new BoxBlur(1, 1, 3);

    public MenuItem(String name) {
        Polygon bg = new Polygon(
                0, 0,
                200, 0,
                215, 15,
                200, 30,
                0, 30
        );
        bg.setStroke(Color.color(1, 1, 1, 0.75));
        bg.setEffect(new GaussianBlur());

        bg.fillProperty().bind(
                Bindings.when(pressedProperty())
                        .then(Color.color(0, 0, 0, 0.75))
                        .otherwise(Color.color(0, 0, 0, 0.25))
        );

        text = new Text(name);
        text.setTranslateX(5);
        text.setTranslateY(20);

        text.setFill(Color.WHITE);

        text.effectProperty().bind(
                Bindings.when(hoverProperty())
                        .then(shadow)
                        .otherwise(blur)
        );

        getChildren().addAll(bg, text);
    }

    public void setOnAction(Runnable action) {
        setOnMouseClicked(e->action.run());
    }
}

class MenuNetwork extends Pane {
    GridPane gridPane = new GridPane();

    MenuNetwork() {
        getChildren().add(gridPane);
    }

    public void createOnlineServer() {
        gridPane.getChildren().clear();

        Label labelPort = new Label("Enter number of port : ");
        Label labelNumberPlayer = new Label("Enter number of players : ");
        Spinner port = new Spinner(40000, 65536, 40000);
        Spinner numberPlayer = new Spinner(2, 4, 2);

        labelPort.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        labelNumberPlayer.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Button host = new Button("Start host game");

        gridPane.add(labelPort, 0, 0);
        gridPane.add(labelNumberPlayer, 0, 1);
        gridPane.add(port, 1, 0);
        gridPane.add(numberPlayer, 1, 1);
        gridPane.add(host, 0, 2, 2, 1);

        gridPane.setHalignment(host, HPos.CENTER);
        gridPane.setVgap(10);
    }
}

    public class MenuManager extends Pane {

    private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    private double lineX = WIDTH / 2 - 100;
    private double lineY = HEIGHT / 3 + 50;

    private boolean startAnimationLine = true;

    private List<Pair<String, Runnable>> menuData = null;

    private VBox menuBox = new VBox(-5);
    private Line line = new Line();

    public MenuManager() {
        addBackground();
        showMainMenu();
        update();
    }

    private void showMainMenu() {

        List<Pair<String, Runnable>> menu = Arrays.asList(
                new Pair<String, Runnable>("Online game", () -> {
                    showMenuOnline();
                    update();
                }),
                new Pair<String, Runnable>("Local game", () -> {
                }),
                new Pair<String, Runnable>("Exit", Platform::exit)
        );
        menuData = menu;
    }

    private void showMenuOnline() {

        List<Pair<String, Runnable>> menu= Arrays.asList(
                new Pair<String, Runnable>("Host game", () -> {
                }),
                new Pair<String, Runnable>("Join game", () -> {
                }),
                new Pair<String, Runnable>("Back menu", () -> {
                    showMainMenu();
                    update();
                })
        );
        menuData = menu;
    }

    private void update() {
        menuBox.getChildren().clear();
        getChildren().remove(menuBox);
        if(startAnimationLine) {
            addLine(lineX, lineY);
        }
        addMenu(lineX + 5, lineY + 5);
        startAnimation();
    }

    private void addBackground() {
        ImageView imageView = new ImageView(new Image(getClass().getResource("/res/background.png").toExternalForm()));
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);

        getChildren().add(imageView);
    }

    private void addLine(double x, double y) {
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(x);
        line.setEndY(y+120);

        line.setStrokeWidth(3);
        line.setStroke(Color.color(1, 1, 1, 0.75));
        line.setEffect(new DropShadow(5, Color.BLACK));
        line.setScaleY(0);

        getChildren().add(line);
    }

    private void startAnimation() {
        List<TranslateTransition> listTranslateTransition = new ArrayList<TranslateTransition>();

        ScaleTransition st = new ScaleTransition(Duration.seconds(1), line);
        st.setToY(1);

        for (int i = 0; i < menuBox.getChildren().size(); i++) {
            Node n = menuBox.getChildren().get(i);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5 + i * 0.15), n);
            tt.setToX(0);
            tt.setOnFinished(e2 -> n.setClip(null));
            listTranslateTransition.add(tt);
        }

        if(startAnimationLine) {
            st.setOnFinished(e -> {
                for (int i = 0; i < listTranslateTransition.size(); i++) {
                    listTranslateTransition.get(i).play();
                }
                startAnimationLine = false;
            });
            st.play();
        }  else {

            for (int i = 0; i < listTranslateTransition.size(); i++) {
                listTranslateTransition.get(i).play();
            }
        }

    }

    private void addMenu(double x, double y) {
        menuBox.setTranslateX(x);
        menuBox.setTranslateY(y);
        menuData.forEach(data -> {
            MenuItem item = new MenuItem(data.getKey());
            item.setOnAction(data.getValue());
            item.setTranslateX(-300);

            Rectangle clip = new Rectangle(300, 30);
            clip.translateXProperty().bind(item.translateXProperty().negate());

            item.setClip(clip);

            menuBox.getChildren().addAll(item);
        });

        getChildren().add(menuBox);
    }
}
