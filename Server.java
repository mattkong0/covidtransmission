/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: none
 * 
 * This file stores all IDs from COVID-19 positive users.
 * This file also adds new IDs to the server.
 */

import java.util.ArrayList;

/**
 * This class stores recent IDs from COVID-19 positive users.
 * This class adds and receives all the stored IDs.
 */

public class Server {
    
    // Instance variable for server
    public ArrayList<Integer> infectedIds;

    // Constructor for Server
    public Server() {
        infectedIds = new ArrayList<>();
    }

    // This method adds Ids in the order that they appear in
    public boolean addInfectedIds(ArrayList<Integer>ids) {

        // check if ids is null
        if (ids == null) {
            return false;
        }

        // add Ids 
        infectedIds.addAll(ids);
        return true;
    }

    // This method returns a deep copy of infectedIds
    public ArrayList<Integer> getInfectedIds() {
        ArrayList<Integer> added = new ArrayList<>();
        for (int i : infectedIds) {
            added.add(i);
        }
        return added;
    }

}
