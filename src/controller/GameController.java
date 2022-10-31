package controller;

import model.GameModel;
import views.BaseView;

import java.util.Arrays;

public class GameController {

    GameModel model;
    BaseView view;

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

    public int getScore() {
        return model.getScore();
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

    public void keyPressed(int keyCode, boolean isInputValid) {
        int[] grid = getGrid();
        int[] temp_grid = grid;
        if (isInputValid) {
            switch (keyCode) {
                case LEFT:
                    score += move(grid);
                    break;
                case RIGHT:
                    rotate(grid, 2);
                    score += move(grid);
                    rotate(grid, 2);
                    break;
                case UP:
                    rotate(grid);
                    score += move(grid);
                    rotate(grid, 3);
                    break;
                case DOWN:
                    rotate(grid, 3);
                    score += move(grid);
                    rotate(grid);
            }
        }
        if (!Arrays.equals(grid, temp_grid)) addTile(grid);

        checkIfGameOver();
    }
}
