package views;

import controller.GameController;
import processing.core.PApplet;

import java.util.Arrays;

public class BaseView extends PApplet {

    final int SIZE_TILE = 80;
    final int SIZE_BORDER = 10;

    final int X_POS = 0;
    final int Y_POS = 0;
    final int X_OFFSET = 20;
    final int Y_OFFSET = 20;

    GameController controller;

    public void draw() {
    }

    public BaseView(){
        controller = new GameController(this);
    }

    public void show() {
        int[] grid = controller.getGrid();
        int edge_length = (int) (sqrt(grid.length));
        int i = 0;
        int X, Y;
        for (int y = 0; y < edge_length; y++) {
            Y = Y_POS + Y_OFFSET + SIZE_BORDER + y * (SIZE_TILE + SIZE_BORDER);
            for (int x = 0; x < edge_length; x++) {
                X = X_POS + X_OFFSET + SIZE_BORDER + x * (SIZE_TILE + SIZE_BORDER);
                // fill(color(179, 189, 214));
                fill(color(30 + log(grid[i] + 1) / log(2) * 10, 100, 100));
                rect(X, Y, SIZE_TILE, SIZE_TILE, 15);
                if (grid[i] != 0) {
                    fill(color(271, 0, 1));
                    text(grid[i], X + (float) SIZE_TILE / 2 + 1, Y + (float) SIZE_TILE / 2 + 1);
                }
                i++;
            }
        }
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(27);
        noStroke();
        background(color(179, 189, 214));
        colorMode(HSB, 360, 100, 100);

        controller.random_tile();
        controller.random_tile();
        show();
    }

    public void settings() {
        int X_SIZE = 2 * X_POS + 2 * X_OFFSET + SIZE_BORDER + 4 * (SIZE_TILE + SIZE_BORDER);
        int Y_SIZE = 2 * Y_POS + 2 * Y_OFFSET + SIZE_BORDER + 4 * (SIZE_TILE + SIZE_BORDER);
        print("X_SIZE:", X_SIZE, "Y_SIZE:", Y_SIZE);
        size(X_SIZE, Y_SIZE);
    }

    public void keyPressed() {
        boolean isInputValid= key == CODED && controller.isGameRunning();
        controller.keyPressed(keyCode,isInputValid);
    }
}