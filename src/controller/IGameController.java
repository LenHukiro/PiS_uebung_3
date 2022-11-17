package controller;

/**
 * The interface of the gameController
 */
public interface IGameController {
    int[] getGrid();

    void createStartTiles();

    boolean isGameRunning();

    void makeMove(MoveDirection i);
}
