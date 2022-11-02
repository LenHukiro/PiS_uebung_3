package controller;

import model.*;
import views.IView;

import java.util.Arrays;

import static processing.core.PApplet.arrayCopy;

public class GameController {

    final IGameModel model;
    final IView view;

    public GameController(IView view) {
        this.view = view;
        model = new GameModel();
    }

    public int[] getGrid() {
        return model.getGrid();
    }

    public void random_tile() {
        model.random_tile(model.getGrid());
    }

    public void addTile(int[] grid) {
        model.random_tile(grid);
        view.show();
        System.out.println("SCORE =" + model.getScore());
    }

    public void checkIfGameOver() {
        if (model.is_game_over()) {
            model.gameOver();
        }
    }

    public boolean isGameRunning() {
        return model.isGameRunning();
    }

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
