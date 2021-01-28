/**
 * Name: Matthew Kong
 * ID: A16660796
 * Email: mkong@ucsd.edu
 * Sources used: Lecture slides, tutors
 * 
 * This file will decrypt a message given a random set of letters.
 * This file will have multiple types of deciphering including Caesar Cipher and Vigenere Cipher.
 */

/**
 * This class will check validity of the input and decipher the message.
 */

public class Cipher {

    //Validity Checking Part 1
    public static boolean isLowerCase(char letter) {
        char curChar = letter;
        if (! ( (curChar >= 'a') && (curChar <= 'z') ) ) {
            return false;
        }
        else {
            return true;
        }
    }

    //Validity Checking Part 2
    public static boolean isLowerCase(String str) {
        for (int j = 0; j < str.length(); j++) {
            char currChar = str.charAt(j);
            if (! ( (currChar >= 'a') && (currChar <= 'z') ) ) {
                return false;
            }
        }
        return true;
    }

    //Caesar Cipher Part 1 (encrypting the plaintext)
    public static char caesarShiftEncode(char plaintext, char key) {
        char ct = key;
        char plain = plaintext;

        if (! ( (isLowerCase(plain) ) && (isLowerCase(ct) ) ) )  {
            return plain;
        }
        else {
            ct = (char)(( ((int)plain - 'a') + ((int)ct - 'a') ) % 26 + 'a');
        }
        return ct;
    }

    //Caesar Cipher Part 2 (decrypting the ciphertext)
    public static char caesarShiftDecode(char ciphertext, char key) {
        char pt = key;
        char cipher = ciphertext;

        if (! ( (isLowerCase(cipher) ) && (isLowerCase(pt) ) ) ) {
            return cipher;
        }
        else {
            pt = (char)((Math.abs(((int)cipher - 'a') - ((int)pt - 'a'))) % 26 + 'a');
        }
        return pt;
    }

    //Vigenere Cipher Part 1
    public static String vigenereEncode(String plaintext, String key) {
        String ptxt = plaintext;
        String ke = key;
        String cip = "";

        //checking for Uppercase letters for the plaintext
        for (int i = 0; i < ptxt.length(); i++) {
            if (! ((ptxt.charAt(i) >= 'a') && (ptxt.charAt(i) <= 'z')) ) {
                return null;
            }
        }

        //key has no characters
        if (ke.equals("")) {
            return null;
        }

        //checking for Uppercase letters for the key
        for (int i = 0; i < ke.length(); i++) {
            if (! ((ke.charAt(i) >= 'a') && (ke.charAt(i) <= 'z')) ) {
                return null;
            }
        }

        //encrypting the plaintext
        for (int i = 0; i < ptxt.length(); i++) {
            cip = cip + caesarShiftEncode(ptxt.charAt(i), ke.charAt(i % ke.length()));
        }
        return cip;
    }

    //Vigenere Cipher Part 2
    public static String vigenereDecode(String ciphertext, String key) {
        String ctxt = ciphertext;
        String ky = key;
        String pla = "";

        //checking for Uppercase letters for the ciphertext
        for (int i = 0; i < ctxt.length(); i++) {
            if (! ((ctxt.charAt(i) >= 'a') && (ctxt.charAt(i) <= 'z')) ) {
                return null;
            }
        }

        //key has no characters
        if (ky.equals("")) {
            return null;
        }

        //checking for Uppercase letters for the key
        for (int i = 0; i < ky.length(); i++) {
            if (! ((ky.charAt(i) >= 'a') && (ky.charAt(i) <= 'z')) ) {
                return null;
            }
        }

        //decrypting the ciphertext
        for (int i = 0; i < ctxt.length(); i++) {
            pla = pla + caesarShiftDecode(ctxt.charAt(i), ky.charAt(i % ky.length()));
        }
        return pla;
    }
}
