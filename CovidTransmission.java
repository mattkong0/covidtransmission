/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: zyBook, 
 * 
 * This file is used to project the risk of the virus transmitting.
 */

 import java.util.Scanner;

 /**
  * This class takes 6 different integers and computes how mnany minutes person A and B interacted for.
  * This file also determines the level of risk. 
  */

 public class CovidTransmission {
     public static void main(String[] args) {
         Scanner scnr = new Scanner(System.in);
         private static final D1;
         private static final H1;
         private static final M1;
         private static final D2;
         private static final H2;
         private static final M2;

         D1 = scnr.nextInt();
         H1 = scnr.nextInt();
         M1 = scnr.nextInt();
         D2 = scnr.nextInt();
         H2 = scnr.nextInt();
         M2 = scnr.nextInt();

         System.out.println(D1 + " " + H1 + " " + M1 + " " + D2 + " " + H2 + " " + M2);

        // Conversions to Minutes (1440 minutes in a day and 60 minutes in an hour)
        int daysToMinutes = (D2 - D1) * 1440;
        int hoursToMinutes = (H2 - H1) * 60;
        int m = M2 - M1;

        // Total time of interaction
        int totalMinutes = daysToMinutes + hoursToMinutes + m;
        
        // Risk levels
        String r1;
        String r2;
        String r3;
        String r4;

        r1 = "low";
        r2 = "medium";
        r3 = "high";
        r4 = "HIGH";

        // Determine risk level based on total time of interaction
        if (! ((D1 >= 1) && (D1 <= 31)))  {
            System.out.println("-1 -1 " + "(D1 is out of range)" );
            return;
        }
        else if (D1 > D2) {
            System.out.println("-1 -1 " + "(D2 H2 M2 represents an earlier time than D1 H1 M1)");
            return;
        }
        else if ((totalMinutes >= 0) && (totalMinutes < 60)) {
            System.out.println(totalMinutes + " " + r1);
        }
        else if ((totalMinutes >= 60) && (totalMinutes < 180)) {
            System.out.println(totalMinutes + " " + r2);
        }
        else if ((totalMinutes >= 180) && (totalMinutes < 360)) {
            System.out.println(totalMinutes + " " + r3);
        }
        else {
            System.out.println(totalMinutes + " " + r4);
        }
         
     }
 }



