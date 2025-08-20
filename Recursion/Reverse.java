/* Reverse.java - Class to hold reverse()
 * Myles Darity-Reese
 * 6-Oct-23
 * What it does:
 * reverse(): Returns the Reverse order of a String
 * Drive(): Outputs reverse()
 * main(): Tester for Reverse
 */

import java.util.ArrayList;   //ArrayList
import java.util.Scanner;     //Scanner

public class Reverse {
    //Reverse - Class to hold reverse()
    static String reverse(String text){
        //reverse(): Returns the Reverse order of a String
        //Implementation: Recurs reverse() till text.length() is 1
        int nLastChar = text.length()-1;
        if(text.length() == 1){
            return "" + text.charAt(0);
        }
        return text.charAt(nLastChar) 
                  + reverse(text.substring(0, nLastChar));
    }

    private static void Drive(ArrayList<String> vStrings){
        //Drive(): Outputs reverse()
        //Implementation: Iterates on reverse(), vStrings
        //NOTE: Exceeds Expectations
        for (int iString = 0; iString < vStrings.size(); iString++) {
            System.out.println("reverse(" + vStrings.get(iString) + "): " 
                                          + reverse(vStrings.get(iString))); 
        }
    }
    public static void main(String[] args) {
        //main(): Tester for Reverse
        //Implementation: Calls to Input Class
        Scanner oScanner = new Scanner(System.in);
        ArrayList<String> vStrings = Input.GetUserStringArray(oScanner, "Enter List of String?> ");
        Drive(vStrings);
    }
}
