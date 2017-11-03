package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

class Dimension {
    int width = 0;
    int height = 0;
}

public class Board extends Pane {
    private int [][] board;
    private ArrayList<ArrayList<Square>> listSquare = new ArrayList<ArrayList<Square>>();
    private Dimension dimension = new Dimension();
    private GridPane gridPane = new GridPane();
    int width = 0;
    int height = 0;
    Board() {
        initializeMap();
        loadBoard();
        getChildren().add(gridPane);
    }

    private void initializeMap() {
        board = new int[][]{
                {5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5},
                {1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1},
                {1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1},
                {2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2},
                {1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1},
                {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1},
                {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1},
                {5, 1, 1, 2, 1, 1, 1, 0, 1, 1, 1, 2, 1, 1, 4},
                {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1},
                {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1},
                {1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1},
                {2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2},
                {1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1},
                {1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1},
                {5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5}
        };
        dimension.width = 15;
        dimension.height = 15;
    }

    private void loadBoard() {
        for (int i = 0; i < dimension.width; ++i) {
            ArrayList<Square> tmpSquare = new ArrayList<Square>();

            for (int j = 0; j < dimension.height; ++j){
                Square square = null; //System.out.println(board[i][j]);

                if(board[i][j] == 0){
                    square = new Square("/res/start.png", SquareType.Normal);
                    tmpSquare.add(square);
                } else if(board[i][j] == 1) {
                    square = new Square("/res/blank.png", SquareType.Normal);
                    tmpSquare.add(square);
                } else if(board[i][j] == 2) {
                    square = new Square("/res/double_letter.png", SquareType.DoubleLetter);
                    tmpSquare.add(square);
                } else if(board[i][j] == 3) {
                    square = new Square("/res/triple_letter.png", SquareType.TripleLetter);
                    tmpSquare.add(square);
                } else if(board[i][j] == 4) {
                    square = new Square("/res/double_word.png", SquareType.DoubleWord);
                    tmpSquare.add(square);
                } else if(board[i][j] == 5) {
                    square = new Square("/res/triple_word.png", SquareType.TripleWord);
                    tmpSquare.add(square);
                }
                gridPane.add(square, j, i);
            }
            listSquare.add(tmpSquare);
        }
    }
}
