package model;

import java.util.Arrays;
import java.util.Random;

public class GameModel {
    final int[] grid = new int[16]; // default values are 0
    int score = 0;
    boolean game = true;


    public GameModel(){

    }

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
    public int move(int[] grid) {
        int score;
        shift(grid);
        score = merge(grid);
        shift(grid);
        return score;
    }

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



    public void random_tile(int[] grid) {
        int pos, val;
        pos = new Random().nextInt(0, free_slots(grid));
        val = new Random().nextInt(0, 1) < 0.9 ? 2 : 4;
        insert_tile(grid, pos, val);
    }

    int free_slots(int[] grid) {
        int i = 0;
        for (int val : grid) {
            if (val == 0) i++;
        }
        return i;
    }

    public boolean is_game_over() {
        int[] temp_grid = Arrays.copyOf(grid,grid.length);
        for (int i = 1; i <= 4; i++) {
            move(temp_grid);
            temp_grid = rotate(temp_grid);
        }
        return Arrays.equals(temp_grid, grid);
    }

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

    public void rotate(int[] grid,int n) {
        for (int i = 1; i <= (n % 4); i++) {
            rotate(grid);
        }
    }

    int[] rotate(int[] grid) {
        int[] temp_grid = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            temp_grid[i + 12 - (i % 4) * 5 - (i / 4) * 3] = grid[i];
        }
        return temp_grid;
    }


    public int[] getGrid() {
        return grid;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int val){
        score += val;
    }

    public void gameOver() {
        game = false;
        System.out.println("GAME OVER. YOUR SCORE ="+ score);
    }

    public boolean isGameRunning() {
        return game;
    }
}
