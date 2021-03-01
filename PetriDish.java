/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: none
 * 
 * This file contains all of the cells growing on the petridish.
 * This file fills the petridish with a variety of cells.
 */

/**
 * This class contains a board that holds 
 * all the cells growing on the petri dish.
 */

public class PetriDish {
    
    // instance variable for Petridish
    public Cell[][] dish;

    // Constructor for Petridish
    public PetriDish(String[][] board) {

        // setup 2d array
        dish = new Cell[board.length][board[0].length];

        // fill petridish
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String input = board[i][j];

                // split input from board
                String [] boardInfo = input.strip().split(" ");

                // get info from string
                String boardType = boardInfo[0];

                // get position of cell from the string
                int mass = Integer.parseInt(boardInfo[1]);

                // cases
                switch(boardType) {
                    case "CellStationary":
                        dish[i][j] = new CellStationary(i, j, mass);
                        break;
                    case "CellMoveUp":
                        dish[i][j] = new CellMoveUp(i, j, mass);
                        break;
                    case "CellDivide":
                        dish[i][j] = new CellDivide(i, j, mass);
                        break;
                    case "CellMoveToggle":
                        dish[i][j] = new CellMoveToggle(i, j, mass);
                        break;
                    case "CellMoveDiagonal":
                        dish[i][j] = new CellMoveDiagonal(i, j, mass);
                        break;
                    case "CellMoveToggleChild":
                        dish[i][j] = new CellMoveToggleChild(i, j, mass);
                        break;
                }
            }
        }
    }
}

