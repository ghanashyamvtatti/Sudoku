package com.weekend.assignment;

public class Backtrack {
	/**
	 * The main method
	 * @param args
	 */
	public static void main(String args[]){
		int puzzle[][] = new int[9][9];
		solve(puzzle);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++)
				System.out.print("\t" + puzzle[i][j]);
			System.out.println();
		}
	}
	
	/**
	 * Method to validate the positioning of a element
	 * @param puzzle
	 * @return
	 */
	public static boolean check(int puzzle[][], int row, int col, int num){
		//Check row and col
		for(int i = 0; i < 9; i++){
			if(num == puzzle[row][i] && i != col)
				return false;
			else if(num == puzzle[i][col] && i != row)
				return false;
		}
		//Check box
		int r = (row - row%3);
		int c = (col - col%3);
		for(int i = r; i < r+3; i++)
			for(int j = c; j < c+3; j++)
				if(num == puzzle[i][j] && i != row && j != col)
					return false;
		return true;
	}
	/**
	 * Method to insert new elements recursively using backtracking
	 * @param puzzle
	 * @return
	 */
	public static boolean solve(int puzzle[][]){
		boolean Full = true;
		//Find first element with value zero
		int row = -1, col = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(puzzle[i][j] == 0){
					Full = false;
					row = i;
					col = j;
					break;
				}
				if(!(Full))
					break;
			}
		}
		if(Full)
			return true;
		//Try inserting number and check if it leads to a solution
		for(int i = 1; i < 10; i++){
			if(check(puzzle,row, col,i)){
				puzzle[row][col] = i;

				if(solve(puzzle))
					return true;
				else
					puzzle[row][col] = 0;
			}
		}
		return false;
	}
}
