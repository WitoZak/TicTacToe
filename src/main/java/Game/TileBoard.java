package Game;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import static Game.Logic.*;


public class TileBoard {

    static Tile [][] tiles = new Tile[3][3];
    private InfoCenter infoCenter;
    private StackPane pane;
    private char playerTurn = 'X';
    static boolean isGameOver = false;

    public  TileBoard(InfoCenter infoCenter) {
        this.infoCenter = infoCenter;
        pane = new StackPane();
        pane.setMinSize(UIConstants.APP_WIDTH, UIConstants.TILE_BOARD_HEIGHT);
        pane.setTranslateX(UIConstants.APP_WIDTH / 2);
        pane.setTranslateY((UIConstants.TILE_BOARD_HEIGHT / 2) + UIConstants.INFO_CENTER_HEIGHT);

        addAllTiles();
    }

    private void addAllTiles() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Tile tile = new Tile();
                tile.getStackPane().setTranslateX((col * 100) - 100);
                tile.getStackPane().setTranslateY((row * 100) - 100);
                pane.getChildren().add(tile.getStackPane());
                tiles[row] [col] = tile;
            }
        }
    }

    public void changePlayerTurn() {
        if (playerTurn == 'X') {
            playerTurn = 'O';
        } else {
            playerTurn = 'X';
        }
        infoCenter.updateMessage("It's " + playerTurn + "'s turn");
    }

    public String getPlayerTurn() {
        return String.valueOf(playerTurn);
    }

    public void startNewGame() {
        isGameOver = false;
        playerTurn = 'X';
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col].setValue("");
            }
        }
    }

    public StackPane getStackPane() {
        return pane;
    }

    public class Tile {
        private StackPane pane;
        private Label label;
        public Tile() {
            pane = new StackPane();
            pane.setMinSize(100, 100);

            Rectangle border = new Rectangle();
            border.setWidth(100);
            border.setHeight(100);
            border.setFill(Color.TRANSPARENT);
            border.setStroke(Color.BLACK);
            pane.getChildren().add(border);

            label = new Label();
            label.setAlignment((Pos.CENTER));
            label.setFont(Font.font(24));
            pane.getChildren().add(label);

            pane.setOnMouseClicked(event ->  {
                if (label.getText().isEmpty() && !isGameOver) {
                    label.setText(getPlayerTurn());
                    changePlayerTurn();
                    checkForWinner();
                }
            });
        }

        public StackPane getStackPane() {
            return pane;
        }

        public String getValue() {
            return label.getText();
        }

        public void setValue(String value) {
            label.setText(value);
        }

    }

}
