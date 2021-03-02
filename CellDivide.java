/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: none
 * 
 * This file is a subclass of Cell.
 * This file has a string representation of "+".
 */

import java.util.List;

/**
 * This class has an extra instance variable, direction.
 * This class checks whether the cell has exactly 3 neighboring cells.
 */

public class CellDivide extends Cell{
    
    // instance field for CellDivide
    public int direction;

    // Constructor for CellDivide
    public CellDivide(int currRow, int currCol, int mass) {
        super(currRow, currCol, mass);
        this.direction = 1;
    }

    // copy Constructor for CellDivide
    public CellDivide(CellDivide otherCellDivide) {
        super(otherCellDivide);
        this.direction = 1;
    }

    // returns string representation of CellDivide
    public String toString() {
        return "+";
    }

    // returns true or false depending on the given conditions
    @Override
    public boolean checkApoptosis(List<Cell> neighbors) {
        if (neighbors.size() == 3) {// given condition
            return true;
        }

        return false;
    }
}
