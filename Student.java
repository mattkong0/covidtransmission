/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: zybook
 * 
 * This file looks at a student's  COVID-19 current test status.
 * This file also handles ID exchanges and student-related functionality.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This class views current COVID test status and 
 * determines if someone is at high-risk for COVID.
 */

public class Student {
    
    // instance fields
    public int id;
    public int location;
    public boolean covidPositive;
    public boolean inQuarantine;
    public ArrayList<Integer> usedIds;
    public ArrayList<ContactInfo> contactHistory;

    // Constructor for Student
    public Student() {
        this.id = -1;
        this.location = -1;
        this.covidPositive = false;
        this.inQuarantine = false;
        this.usedIds = new ArrayList<>();
        this.contactHistory = new ArrayList<>();
    }

    // This method updates the student's location
    public boolean setLocation(int newLocation) {
        if ( (newLocation > 0) && 
             (inQuarantine == false) ) {// valid location and no quarantine
            location = newLocation;
            return true;
        }
        
        return false;
    }

    // This method updates a student's ID
    public void updateId() {

        // Setup random number generator
        Random randGen = new Random();
        int newId = randGen.nextInt(Integer.MAX_VALUE);

        // store updatedId in usedIds
        usedIds.add(usedIds.indexOf(id), newId);
    }

    // This method adds new contact info to array contactHistory
    public boolean addContactInfo(ContactInfo info) {

        if ( (info != null) && 
             (info.isValid() == true) ) {// valid and non-null info
            contactHistory.add(info);
            return true;
        }

        return false;
    }

    // This method adds usedIds into the server
    public boolean uploadAllUsedIds(Server server) {

        if (server != null) {// server is not null
            server.addInfectedIds(usedIds);
            return true;
        }

        return false;
    }

    // Determine if uploadAllUsedIds ran successfully
    public boolean testPositive(Server server) {

        // student tested positive
        covidPositive = true;
        inQuarantine = true;

        // check if server is null before executing previous method
        if (server != null) {
            uploadAllUsedIds(server);
            return true;
        }

        return false;
    }

    // This method returns people who got infected
    public ArrayList<ContactInfo>getRecentPositiveContacts(Server server, 
                                                           int fromTime) {
        
        // get all infected Ids from server                                                    
        ArrayList<Integer> infectedIds = server.getInfectedIds();

        // create new array to store infected people
        ArrayList<ContactInfo> infectedPeople = new ArrayList<ContactInfo>();

        // invalid input #1
        if (server == null) {
            return null;
        }

        // invalid input #2
        if (fromTime < 0) {
            return null;
        }

        // invalid input #3
        if (server.getInfectedIds() == null) {
            return null;
        }

        // inspect student's contact history
        for (ContactInfo infected : contactHistory) {
            if (!(infected.used) && 
                 (infectedIds.contains(infected.id)) && 
                 (infected.time >= fromTime) ) {// conditions
                infectedPeople.add(infected);
            }
        }

        return infectedPeople;

    }

    // This method assesses the student's risk of COVID-19
    public int riskCheck(Server server, int fromTime, boolean quarantineChoice) {

        // get recent contacts with positive cases
        ArrayList<ContactInfo> covidCases = getRecentPositiveContacts(server, fromTime);

        // check if getRecentPositiveContacts returned null
        if (covidCases == null) {
            return -1;
        }

        // analyze if student is at high-risk
        int contacts = 0;
        for (ContactInfo info : covidCases) {
            if ( (info.id == this.id) && 
                 (info.distance <= 1) ) {// condition 1
                contacts += 1;
                info.used = true;
            }
        }

        // high risk
        if (contacts >= 3) {// condition 2
            this.inQuarantine = true;
            return 1;
        }

        return 0;
    }
}
