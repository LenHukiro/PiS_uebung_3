package controller;

import model.GameModel;
import views.BaseView;

import java.util.Arrays;

public class GameController {

    final GameModel model;
    final BaseView view;

    public GameController(BaseView view) {
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
        int[] temp_grid = Arrays.copyOf(grid,grid.length);
        if (rotation != 0) {
            model.rotate(model.getGrid(),4 - rotation );
            model.addToScore(model.move(model.getGrid()));
            model.rotate(model.getGrid(),Math.abs(rotation - 4));
        } else {
            model.addToScore(model.move(model.getGrid()));
        }
        if (!Arrays.equals(grid, temp_grid)) addTile(grid);
        checkIfGameOver();
    }
}
