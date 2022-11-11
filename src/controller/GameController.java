package controller;

import model.*;
import views.IView;

import java.util.Arrays;

import static processing.core.PApplet.arrayCopy;

/**
 * The type Game controller.
 */
public class GameController {

    /**
     * The Model.
     */
    final IGameModel model;
    /**
     * The View.
     */
    final IView view;

    /**
     * Instantiates a new Game controller.
     *
     * @param view the view
     */
    public GameController(IView view) {
        this.view = view;
        model = new GameModel();
    }

    /**
     * Get grid int [ ].
     *
     * @return the int [ ]
     */
    public int[] getGrid() {
        return model.getGrid();
    }

    /**
     * Create start tiles.
     */
    public void createStartTiles() {
        model.random_tile(model.getGrid());
        model.random_tile(model.getGrid());
    }

    /**
     * Add tile.
     *
     * @param grid the grid
     */
    public void addTile(int[] grid) {
        model.random_tile(grid);
        view.show();
        System.out.println("SCORE =" + model.getScore());
    }

    /**
     *
     */
    private void checkIfGameOver() {
        if (model.is_game_over()) {
            model.gameOver();
        }
    }

    /**
     * Is game running boolean.
     *
     * @return the boolean
     */
    public boolean isGameRunning() {
        return model.isGameRunning();
    }

    /**
     * Make move.
     *
     * @param rotation the rotation
     */
    public void makeMove(int rotation) {
        int[] grid = getGrid();
        int[] temp_grid = Arrays.copyOf(grid, grid.length);
        arrayCopy(temp_grid,grid);
        if (rotation != 0) {
            model.rotate(grid, 4 - rotation);
            model.addToScore(model.move(grid));
            model.rotate(grid, Math.abs(rotation - 4));
        } else {
            model.addToScore(model.move(grid));
        }
        if (!Arrays.equals(grid, temp_grid)) addTile(grid);
        checkIfGameOver();
    }
}
