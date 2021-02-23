/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: none
 * 
 * This file gets contact information.
 * This file also stores time and distance of contact.
 */

/**
 * This class will store all the person's personal info.
 * This class will determine if the student's information was used to send out
 * an exposure notification.
 */

public class ContactInfo {
    
    public int id;
    public int distance;
    public int time;
    public boolean used;

    // This is the constructor for ContactInfo
    public ContactInfo(int id, int distance, int time) {
        used = false;
        this.id = id;
        this.distance = distance;
        this.time = time;
    }

    // This constructor checks for validity of inputs
    public boolean isValid() {
        if (id < 0 ||
            distance < 0 ||
            time < 0) {// check for invalid inputs
            return false;
        }
        else {// assuming all variables are true
            return true;
        }
    }
}
