/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: zybook, tutors
 * 
 * This file with keep track of who has been infected by the virus.
 * This file will also count how many cases caused by each student and
 * which of the students has caused the most infections.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * This class will who keep track of who has been infected by the virus.
 */

public class InfectionTracking {

    // Part 1: Reading Input File and Populating Arrays
    // This method sorts info from input file into its corresponding arrays.
    public static int populateArrays(String pathToFile, String[] names, 
                                    int[] locations, int[] movements,
                                    int[] infections) throws IOException {
        
        // Open file with scanner
        Scanner in = new Scanner(new File(pathToFile));

        // Check if file is null (in other words, not found)
        if (pathToFile == null) {
            return -1;
        }

        // check if any of the arrays are null
        if ( (names == null) || 
             (locations == null) || 
             (movements == null) || 
             (infections == null) ) {
            return -1;
        }

        // check if array lengths match
        if ( (names.length != locations.length) ||
             (locations.length != movements.length) || 
             (movements.length != infections.length) ) {
            return -1;
        }

        for(int i = 0; in.hasNextLine(); i++) {// parse info to parallel arrays
            String[] str = in.nextLine().split(",");
            // check if inputFile length matches array length
            if (i > names.length) {
                return -1;
            }

            // get values from each line
            String person = str[0];
            int place = Integer.parseInt(str[1]);
            int action = Integer.parseInt(str[2]);
            int cas = Integer.parseInt(str[3]);

            names[i] = person;
            locations[i] = place;
            movements[i] = action;
            infections[i] = cas;
        }

        printArrayStr(names);
        printArrayInt(locations);
        printArrayInt(movements);
        printArrayInt(infections);

        // get maximum value of location
        int maxVal = 0;
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] > maxVal) {
                maxVal = locations[i];
            }
        }
        return maxVal + 1;
    }

    // helper method to print out str array
    public static void printArrayStr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print("");
    }

    // helper method to print out int array
    public static void printArrayInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("");
    }

    // Part 2: Update Locations and Infections
    // This method update a student's location.
    public static void updateLocations(int worldSize, int[] locations, 
                                       int[] movements) {

        // check if either array is null
        if ( (locations == null) || (movements == null) ) {
            return;
        }

        // Check if world size is negative
        if (worldSize < 0) {
            return;
        }

        // check if input is outside of [0, worldSize]
        for (int i = 0; i < locations.length; i++) {
            if ( (locations[i] < 0) || (locations[i] > worldSize)) {
                return;
            }
        }

        // Check if locations and movements don't have the same length
        if (locations.length != movements.length) {
            return;
        }

        // Update location of student
        for (int i = 0; i < locations.length; i++) {
            // condition 1: check if updated location is less than 0
            if (locations[i] + movements[i] < 0) {
                locations[i] = (locations[i] + (movements[i] % worldSize) + worldSize)
                               % worldSize;
            }
            // condition 2: check if updated location is bigger than size
            else if (locations[i] + movements[i] >= worldSize) {
                locations[i] = (locations[i] + movements[i]) % worldSize;
            }
            // condition 3: if 1 and 2 don't apply
            else {
                locations[i] = locations[i] + movements[i];
            }
        }

        System.out.println(locations);
    }

    // This method will update infection status of student and return
    // number of cases caused by that student.
    public static int[] updateInfections(int worldSize, int[] locations,
                                         int[] infections) {

        // check if either array is null
        if ( (locations == null) || (infections == null) ) {
            return null;
        }

        // check if worldSize is a negative number
        if (worldSize < 0) {
            return null;
        }

        // check if arrays have same length
        if (locations.length != infections.length) {
            return null;
        }

        // check for any invalid inputs in infections
        for (int i = 0; i < infections.length; i++) {
            // check if infection value is not 0 and 1
            if ( (infections[i] != 0) && (infections[i] != 1) ) {
                return null;
            }
        }

        // check if any value in locations is out of range [0, worldSize - 1]
        for (int i = 0; i < locations.length; i++) {
            if ( (locations[i] < 0) || (locations[i] > worldSize) ) {
                return null;
            }
        }

        // create empty array to tally number of cases caused by each student
        int[] numStudentsInfected = new int[infections.length];

        // tally number of infections caused by each student
        // loop 1: loop over infections array
        for (int i = 0; i < infections.length; i++) {
            // check 1: check if studentI is infected
            // only want to tally number of students infected
            int caseI = infections[i];
            if (caseI == 1) { // 1 for infected and 0 for no infection
                // loop 2: locations and tally number of infections
                // caused by studentI
                for (int j = 0; j < locations.length; j++) {
                    int studentLocationI = locations[i];
                    int studentLocationJ = locations[j];
                    // check 2: check if students are in same location
                    if (studentLocationI == studentLocationJ) {
                        int caseJ = infections[j];
                        // check 3: check if studentJ is not infected
                        if (caseJ == 0) {
                            // increment number of students infected by this student
                            numStudentsInfected[i] += 1;
                        }
                    }
                }
            }
        }

        // update infection status of student
        // loop 1: loop over infections array
        for (int i = 0; i < infections.length; i++) {
            // check 1: check if this student is infected
            int caseI = infections[i];
            if (caseI == 1) {
                // loop 2: loop over locations
                for (int j = 0; j < locations.length; j++) {
                    int studentLocationI = locations[i];
                    int studentLocationJ = locations[j];
                    // check 2: check if students are in same location
                    if (studentLocationI == studentLocationJ) {
                        int caseJ = infections[j];
                        // check 3: check if studentJ is not infected
                        if (caseJ == 0) {
                            infections[j] += 1;
                        }
                    }
                }
            }
        }

        return numStudentsInfected;
    }

    // Part 3: Stimulate Spread
    // This method will count how many infections are caused each day
    public static int[] countInfectionsByStudent(int days, int worldSize,
                                                 int[] locations, int[] movements,
                                                 int[] infections) {
        // check if days is negative
        if (days < 0) {
            return null;
        }    
        
        // check if any array is null
        if ( (locations == null) || 
             (movements == null) || 
             (infections == null) ) {
            return null;
        }  
        
        // check if array lengths don't match
        if ( ! ( (locations.length == movements.length) || 
                 (movements.length == infections.length) ) ) {
            return null;
        }

        // create new array to number of student infected
        int [] infectionRecord = new int[infections.length];

        // calculate total number of student infected in each location
        for (int i = 0; i < days; i++) {
            updateLocations(worldSize, locations, movements);
            int [] arr = updateInfections(worldSize, locations, infections);
            for (int j = 0; j < infections.length; j++) {
                infectionRecord[j] += arr[j];
            }
        }
        return infectionRecord;
    }

    // Part 4: Analyze Results
    // This method will calculate the average infections per student
    public static int findRNaught(int[] infectionRecord) {

        // check 1: check if array has no length
        if (infectionRecord.length == 0) {
            return -1;
        }

        // check 2: check if array is null
        if (infectionRecord == null) {
            return -1;
        }

        // check 3: check if any input is negative
        for (int i = 0; i < infectionRecord.length; i++) {
            if (infectionRecord[i] < 0) {
                return -1;
            }
        }

        // calculate sum and then find average
        int sum = 0;
        int avg = 0;
        for (int i = 0; i < infectionRecord.length; i++) {
            sum = infectionRecord[i] + sum;
        }
        avg = sum / infectionRecord.length;

        // find smallest integer greater than current average
        if (sum % infectionRecord.length > 0) {
            avg = avg + 1;
        }
        return avg;
    }

    // This method returns the name of the student who 
    // caused the most infections
    public static String findSuperSpreader(int[] infectionRecord, String[] names) {

        // check 1: check if either array has no length
        if ( (infectionRecord.length == 0) || (names.length == 0) ) {
            return null;
        }

        // check 2: check if arrays have different lengths
        if (infectionRecord.length != names.length) {
            return null;
        }

        // check 3: check if either array is null
        if ( (infectionRecord == null) || (names == null) ) {
            return null;
        }

        // check 4: check if any value in infectionRecord is negative
        for (int i = 0; i < infectionRecord.length; i++) {
            if (infectionRecord[i] < 0) {
                return null;
            }
        }

        // analyze the most infections caused by a student
        int mostInfections = 0;
        // loop over infectionRecord array
        for (int i = 0; i < infectionRecord.length; i++) {
            if (infectionRecord[i] > mostInfections) {
                mostInfections = infectionRecord[i];
            }
        }

        // fnd out who caused the most infections
        String student = "";
        // loop over names array
        for (int i = 0; i < names.length; i++) {
            if (infectionRecord[i] == mostInfections) {
                if ( (infectionRecord[i-1] == mostInfections) && 
                     (infectionRecord[i] == mostInfections) ) {
                    student = student + names[i-1];
                }
                else {
                    student = student + names[i];
                }
            }
        }

        return student;
    }
}
