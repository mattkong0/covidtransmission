/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: Lecture slides, tutors, zybook, 
 * 
 * This file will display the output of a genome sequence by using k-reversing.
 * This algorithm should work with any string and any integer k.
 */

import java.util.Scanner;

/**
 * This class will take a string and an integer k and
 * display the output genome sequence using k-reversing.
 */

public class CovidMutation {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String sequence;
        int k;

        // Input Sequence
        sequence = scnr.next();
        k = scnr.nextInt();

        // Output Sequence
        String result = "";
        if (k < 0) {
            System.out.print(sequence);
        }
        else if (sequence.length() % k == 0) {
            for (int i = 0; i < sequence.length() / k; i++) {
                for (int j = i * k + (k - 1); j >= i * k; j--) {//assuming that the string length is divisble by k
                    result = result + sequence.charAt(j);
                }
            }
        }
        System.out.print(result);

    }
}
