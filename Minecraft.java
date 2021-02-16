/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: tutors
 * 
 * This file allows us to create a server in Minecraft.
 * This file will also allow us to determine who needs to get
 * tested before going to the Minecraft Party.
 */

import java.util.ArrayList;

/**
 * This class will create a Minecraft server.
 */

public class Minecraft {

    // This method allows us to rotate the floor plan
    public static int[][] rotateFloorPlan(int[][] originalFloorPlan) {

        // check if originalFloorPlan is null
        if (originalFloorPlan == null) {
            return null;
        }

        // make a new 2D array that rotates original floor plan
        int [][] rotd = new int [originalFloorPlan[0].length]
                                [originalFloorPlan.length];
        for (int row = 0; row < originalFloorPlan[0].length; row++) {
            for (int col = 0; col < originalFloorPlan.length; col++) {
                rotd[row][col] = originalFloorPlan
                                 [originalFloorPlan.length-1-col]
                                 [row];
            }
        }

        return rotd;
    }

    // This method determines who needs to get tested before the party
    public static ArrayList<String>getMobsToTest(String[][] groups, 
                                                 String infected) {

        // check if groups or infected is null
        if (groups == null || infected == null) {
            return null;
        }

        // make new ArrayList that returns the mobs that need to be tested
        ArrayList<String> getTested = new ArrayList<String>();
        for (int row = 0; row < groups.length; row++) {
            for (int col = 0; col < groups[row].length; col++) {
                String villager = groups[row][col];
                // check if infected is in the group 
                if (infected.equals(villager)) {
                    String [] mobs = groups[row];
                    // what we have now that infected is in
                    for (String testers : mobs) {
                        // check for any null inputs in the group
                        if (testers == null) {
                            continue;
                        }
                        // those that are affected who need to get tested
                        if (!testers.equals(infected)) {
                            if (!getTested.contains(testers)) { // duplicates
                                getTested.add(testers);
                            }
                        }
                    }
                    // infected is only gone through once to prevent any duplicates
                    break;
                }
            }
        }
        return getTested;
    }

    // helper method to print out a 2d int array
    public static void print2DArrayint(int [][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println("");
        }
    }

    //helper method to print out a string array
    public static void printArrayString(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + ",");
        }
        System.out.println("");
    }
}
