package views;

import controller.GameController;
import controller.IGameController;
import controller.MoveDirection;
import processing.core.PApplet;


/**
 * The Base view, which views should implement.
 */
public abstract class BaseView extends PApplet implements IView {

    /**
     * The Size of the tile.
     */
    final int SIZE_TILE = 80;
    /**
     * The Size of the border.
     */
    final int SIZE_BORDER = 10;

    /**
     * The X pos.
     */
    final int X_POS = 0;
    /**
     * The Y pos.
     */
    final int Y_POS = 0;
    /**
     * The X offset.
     */
    final int X_OFFSET = 20;
    /**
     * The Y offset.
     */
    final int Y_OFFSET = 20;

    /**
     * The Controller of this view.
     */
    final IGameController controller;

    /**
     * Instantiates the controller for the view.
     */
    public BaseView() {
        controller = new GameController(this);
    }


    /**
     * Shows and updates the game
     */
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

    /**
     * Initializes the application and starts the game
     */
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(27);
        noStroke();
        addColorScheme();

        controller.createStartTiles();
        show();
    }

    /**
     * Adds a color scheme to the application.
     */
    protected void addColorScheme() {
        background(color(179, 189, 214));
        colorMode(HSB, 360, 100, 100);
    }

    /**
     * Sets the size of the application window
     */
    @SuppressWarnings("PointlessArithmeticExpression")
    public void settings() {
        int X_SIZE = 2 * X_POS + 2 * X_OFFSET + SIZE_BORDER + 4 * (SIZE_TILE + SIZE_BORDER);
        int Y_SIZE = 2 * Y_POS + 2 * Y_OFFSET + SIZE_BORDER + 4 * (SIZE_TILE + SIZE_BORDER);
        print("X_SIZE:", X_SIZE, "Y_SIZE:", Y_SIZE);
        size(X_SIZE, Y_SIZE);
    }

    /**
     * Handels the KeyInputs from the user
     */
    public void keyPressed() {
        boolean isMoveAllowed = key == CODED && controller.isGameRunning();
        if (isMoveAllowed) {
            switch (keyCode) {
                case LEFT:
                    controller.makeMove(MoveDirection.LEFT);
                    break;
                case RIGHT:
                    controller.makeMove(MoveDirection.RIGHT);
                    break;
                case UP:
                    controller.makeMove(MoveDirection.UP);
                    break;
                case DOWN:
                    controller.makeMove(MoveDirection.DOWN);
            }
        }

    }

    /**
     * Needs to be added in order to run Processing
     */
    public void draw() {
    }

}
