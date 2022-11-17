package model;

import java.util.Arrays;
import java.util.Random;

import static processing.core.PApplet.arrayCopy;

/**
 * The type Game model.
 */
public class GameModel {
    /**
     * The Grid in which the game is being played.
     */
    final int[] grid = new int[16]; // default values are 0

    /**
     * The User's Score.
     */
    int score = 0;

    /**
     * Boolean if the game is still in progress.
     */
    boolean game = true;

    /**
     * Merges numbers of the same value together.
     *
     * @param grid the grid
     * @return the updated player score
     */
    int merge(int[] grid) {
        int score = 0;
        for (int i = 0; i < grid.length; i++) {
            if (i % 4 < 3) {
                if (grid[i] > 0 && grid[i] == grid[i + 1]) {
                    grid[i] += grid[i + 1];
                    grid[i + 1] = 0;
                    score += grid[i];
                }
            }
        }
        return score;
    }

    /**
     * Moves a tile inside the grid
     *
     * @param grid containing the numbers of the game
     * @return the player's score
     */
    public int move(int[] grid) {
        int score;
        shift(grid);
        score = merge(grid);
        shift(grid);
        return score;
    }

    /**
     * Inserts a new tile inside the grid.
     *
     * @param grid the given playing grid
     * @param n    the position of the new tile
     * @param val  the value of the enw tile
     */
    void insert_tile(int[] grid, int n, int val) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == 0) {
                if (n == 0) {
                    grid[i] = val;
                    break;
                }
                n--;
            }
        }
    }


    /**
     * Creates a random tile inside the given grid
     *
     * @param grid the given grid
     */
    public void random_tile(int[] grid) {
        int pos, val;
        if (free_slots(grid) == 0) return;
        pos = new Random().nextInt(0, free_slots(grid));
        val = new Random().nextInt(0, 1) < 0.9 ? 2 : 4;
        insert_tile(grid, pos, val);

    }

    /**
     * Returns the number of free tiles inside the given grid.
     *
     * @param grid the given grid
     * @return number of free tiles
     */
    int free_slots(int[] grid) {
        int i = 0;
        for (int val : grid) {
            if (val == 0) i++;
        }
        return i;
    }

    /**
     * Checks if the game conditions are met for a game over
     *
     * @return boolean if the player got a game over
     */
    public boolean is_game_over() {
        int[] temp_grid = new int[grid.length];
        arrayCopy(grid, temp_grid);
        for (int i = 1; i <= 4; i++) {
            move(temp_grid);
            rotate(temp_grid);
        }
        return Arrays.equals(temp_grid, grid);
    }

    /**
     * Fills the empty spaces inside the grid with 0's
     *
     * @param grid the given grid
     */
    void shift(int[] grid) {
        int offset = 0;
        for (int i = 0; i < grid.length; i++) {
            if (i % 4 == 0) {
                offset = 0;
            }
            if (grid[i] == 0) {
                offset++;
            } else if (offset > 0) {
                grid[i - offset] = grid[i];
                grid[i] = 0;
            }
        }
    }

    /**
     * Rotates the given grid a number of times in the given direction
     *
     * @param grid the given grid
     * @param n the direction in which the grid is rotated
     */
    public void rotate(int[] grid, int n) {
        for (int i = 1; i <= (n % 4); i++) {
            rotate(grid);
        }
    }

    /**
     * Rotates the given grid
     *
     * @param grid the grid
     */
    void rotate(int[] grid) {
        int[] temp_grid = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            temp_grid[i + 12 - (i % 4) * 5 - (i / 4) * 3] = grid[i];
        }
        arrayCopy(temp_grid, grid);
    }

    /**
     * Returns the playing grid
     *
     * @return the grid
     */
    public int[] getGrid() {
        return grid;
    }

    /**
     * Returns the player's high Score
     *
     * @return the player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Adds a value to the player's score
     *
     * @param val the points, which should be added to the score
     */
    public void addToScore(int val) {
        score += val;
    }


    /**
     * Ends the game and prints a game over message
     */
    public void gameOver() {
        game = false;
        System.out.println("GAME OVER. YOUR SCORE =" + score);
    }

    /**
     * Checks if the game is still running
     *
     * @return boolean if the game is still going on
     */
    public boolean isGameRunning() {
        return game;
    }
}
