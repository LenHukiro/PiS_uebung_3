package controller;

import model.*;
import views.IView;

import java.util.Arrays;

import static processing.core.PApplet.arrayCopy;

/**
 * The Game controller.
 */
public class GameController implements IGameController {

    /**
     * The model of the game.
     */
    final GameModel model;
    /**
     * The view of the game.
     */
    final IView view;

    /**
     * Instantiates a new Game controller.
     *
     * @param view the view of the game
     */
    public GameController(IView view) {
        this.view = view;
        model = new GameModel();
    }

    /**
     * Getter for the model's grid
     *
     * @return the grid of the game
     */
    public int[] getGrid() {
        return model.getGrid();
    }

    /**
     * Creates start tiles of the game.
     */
    public void createStartTiles() {
        model.random_tile(model.getGrid());
        model.random_tile(model.getGrid());
    }

    /**
     * Adds a tile into the grid.
     *
     * @param grid the given grid
     */
    public void addTile(int[] grid) {
        model.random_tile(grid);
        view.show();
        System.out.println("SCORE =" + model.getScore());
    }

    /**
     * Checks if a game over occured
     */
    private void checkIfGameOver() {
        if (model.is_game_over()) {
            model.gameOver();
        }
    }

    /**
     * Checks if game is still going on.
     *
     * @return boolean if the game is still running
     */
    public boolean isGameRunning() {
        return model.isGameRunning();
    }



    /**
     * Makes a move inside the grid, with the given direction as rotation
     *
     * @param rotation the direction from which the move was made
     */
    public void makeMove(MoveDirection rotation) {
        int[] grid = getGrid();
        int[] temp_grid = Arrays.copyOf(grid, grid.length);
        arrayCopy(temp_grid,grid);
        if (rotation.direction != 0) {
            model.rotate(grid, 4 - rotation.direction);
            model.addToScore(model.move(grid));
            model.rotate(grid, Math.abs(rotation.direction - 4));
        } else {
            model.addToScore(model.move(grid));
        }
        if (!Arrays.equals(grid, temp_grid)) addTile(grid);
        checkIfGameOver();
    }
}
