package com.doggeddev;

/***Practice pathfinding in a matrix****/


/*Starts in upper right hand corner and works its way
  through a randomly generated matrix.

	    ---Need to do some refactoring
  */

import java.util.Random;

public class SimpleRecursivePathfinder {


	static int prevR = 0;
	static int prevC = 0;


	private static boolean checkSurroundingGrids(int r, int c, char[][] maze) {

		if (maze[r][c] == '*')
			return false;
		if (maze[r][c] == 'X')
			return false;
		if (maze[r][c] == 'E') {
			return true;
		} else {
			maze[prevR][prevC] = '*';
			prevC = c;
			prevR = r;

			//need to refactor these, but this adds some understanding and readibility.
			if (r + 1 < maze.length && checkSurroundingGrids(r + 1, c, maze)) ;

			if (r - 1 >= 0 && checkSurroundingGrids(r - 1, c, maze)) ;

			if (c + 1 < maze[0].length && checkSurroundingGrids(r, c + 1, maze)) ;

			if (c - 1 >= 0 && checkSurroundingGrids(r, c - 1, maze)) ;

			maze[prevR][prevC] = '*';
			prevC = c;
			prevR = r;

		}

		return false;
	}


	private static char[][] initGrid(char[][] grid) {
		Random r = new Random();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = ' ';
			}
		}
		for (int k = 0; k < 30; k++) {
			grid[r.nextInt(10)][r.nextInt(10)] = 'X';
		}

		return grid;
	}

	public static void main(String[] args) {

		char[][] grid = new char[10][10];

		initGrid(grid);

		grid[9][9] = 'E';

		System.out.println("___________BEFORE SEARCH__________________________________");
		printGrid(grid);

		checkSurroundingGrids(0, 0, grid);

		System.out.println("\n\n\n\n");

		System.out.println("___________AFTER SEARCH____________________________________");
		printGrid(grid);

	}

	private static void printGrid(char[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(" " + grid[i][j] + " ");
			}
			System.out.println();
		}

	}
}
