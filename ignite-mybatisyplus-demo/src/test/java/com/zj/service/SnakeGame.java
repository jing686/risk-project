package com.zj.service;

import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private int width;
    private int height;
    private int[][] board;
    private int snakeLength;
    private int[] snakeX;
    private int[] snakeY;
    private int foodX;
    private int foodY;
    private int direction; // 1: up, 2: right, 3: down, 4: left

    public SnakeGame(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[height][width];
        this.snakeLength = 1;
        this.snakeX = new int[width * height];
        this.snakeY = new int[width * height];
        this.snakeX[0] = width / 2;
        this.snakeY[0] = height / 2;
        this.board[snakeY[0]][snakeX[0]] = 1;
        this.direction = 2; // start moving right
        spawnFood();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.print("Enter direction (w/a/s/d): ");
            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "w":
                    if (direction != 3) direction = 1; // cannot move down when moving up
                    break;
                case "a":
                    if (direction != 2) direction = 4; // cannot move right when moving left
                    break;
                case "s":
                    if (direction != 1) direction = 3; // cannot move up when moving down
                    break;
                case "d":
                    if (direction != 4) direction = 2; // cannot move left when moving right
                    break;
                default:
                    System.out.println("Invalid input, please enter w/a/s/d.");
                    continue;
            }
            if (!move()) {
                System.out.println("Game over!");
                break;
            }
        }
        scanner.close();
    }

    private boolean move() {
        int nextX = snakeX[0];
        int nextY = snakeY[0];
        switch (direction) {
            case 1: // up
                nextY--;
                break;
            case 2: // right
                nextX++;
                break;
            case 3: // down
                nextY++;
                break;
            case 4: // left
                nextX--;
                break;
        }
        if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height || board[nextY][nextX] == 1) {
            return false; // hit the wall or hit itself
        }
        if (nextX == foodX && nextY == foodY) {
            snakeLength++;
            spawnFood();
        }
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        snakeX[0] = nextX;
        snakeY[0] = nextY;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = 0;
            }
        }
        for (int i = 0; i < snakeLength; i++) {
            board[snakeY[i]][snakeX[i]] = 1;
        }
        return true;
    }

    private void spawnFood() {
        Random random = new Random();
        do {
            foodX = random.nextInt(width);
            foodY = random.nextInt(height);
        } while (board[foodY][foodX] == 1); // ensure the food is not on the snake
    }

    private void printBoard() {
        System.out.println("Score: " + (snakeLength - 1));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 0) {
                    System.out.print(".");
                } else if (board[i][j] == 1) {
                    System.out.print("O");
                } else if (i == foodY && j == foodX) {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(20, 10);
        game.play();
    }
}
