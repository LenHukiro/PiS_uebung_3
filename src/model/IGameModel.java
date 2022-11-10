package model;

public interface IGameModel {


    int[] getGrid();

    void random_tile(int[] grid);

    int getScore();

    boolean is_game_over();

    void gameOver();

    boolean isGameRunning();

    void rotate(int[] grid, int i);

    int move(int[] grid);

    void addToScore(int score);
}
