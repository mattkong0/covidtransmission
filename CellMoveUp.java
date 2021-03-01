/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: none
 * 
 * This file is another subclass of Cell.
 * This file has a string representation of "^".
 */

import java.util.List;

/**
 * This class checks for whether this cell 
 * does not have exactly 4 neighbors.
 */

public class CellMoveUp extends Cell{
    
    // Constructor for CellMoveUp
    public CellMoveUp(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
    }

    // copy Constructor for CellMoveUp
    public CellMoveUp(CellMoveUp otherCellMoveUp) {
        super(otherCellMoveUp);
    }

    // return String representation of CellMoveUp
    public String toString() {
        return "^";
    }

    // this method returns true or false depending on the given conditions
    public boolean checkApoptosis(List<Cell> neighbors) {
        if (neighbors.size() != 4) {// given condition
            return true;
        }

        return false;
    }
}
