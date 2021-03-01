/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: none
 * 
 * This file is a subclass of CellMoveUp.
 * This file has two new instance variables,
 * orientedRight and diagonalMoves.
 */

import java.util.List;

/**
 * This class checks if the cell has more than 3 neighbors.
 */

public class CellMoveDiagonal extends CellMoveUp{
    
    // instance fields
    public boolean orientedRight;
    public int diagonalMoves;

    // Constructor for CellMoveDiagonal
    public CellMoveDiagonal(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);

        // default for orientedRight
        this.orientedRight = true;

        // default for diagonalMoves
        this.diagonalMoves = 0;
    }

    // copy Constructor for CellMoveDiagonal
    public CellMoveDiagonal(CellMoveDiagonal otherCellMoveDiagonal) {
        super(otherCellMoveDiagonal);

        // default for orientedRight
        this.orientedRight = true;

        // default for diagonalMoves
        this.diagonalMoves = 0;
    }

    // returns string representation of CellMoveDiagonal depending on condition
    public String toString() {
        if (orientedRight) {
            return "/";
        }
        return "\"";
    }

    // returns true or false depending on given condition
    public boolean checkApoptosis(List<Cell> neighbors) {
        if (neighbors.size() > 3) {// given condition
            return true;
        }
        return false;
    }
    
}
