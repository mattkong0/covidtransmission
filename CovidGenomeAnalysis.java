/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: zybook, lecture slides
 * 
 * This file is used to determine which bases are on one strand if we know what bases are on another strand.
 * This file is also used to calculate how many times a certain base appears on a strand of DNA.
 */

import java.util.Scanner;

/**
 * This class will print the input and output strands and determine how many times 
 * a certain base appears in the output strand.
 */

public class CovidGenomeAnalysis {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String strand;
        int i;
        int j;

        // Input Strand
        strand = scnr.next();


        // Output Strand
        String result = "";
        j = 0;
        for (i = 0; i < strand.length(); i++) {
            if (strand.charAt(i) == 'A') {
                result += 'T';
                j = j + 1;
            }
            if (strand.charAt(i) == 'C') {
                result += 'G';
            }
            if (strand.charAt(i) == 'G') {
                result += 'C';
            }
            if (strand.charAt(i) == 'T') {
                result += 'A';
            }
        }
        System.out.print(j + " " + result);
    }
}