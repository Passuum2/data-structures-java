/* ReverseList.java - Class to Reverse a Linked List
 * Myles Darity-Reese
 * 27-Oct-23
 * What it does:
 * reverse(): Returns reversed list as Linked List
 * main(): Tester for ReverseList class
 */

import java.util.Scanner;                //Scanner
import java.util.LinkedList;             //LinkedList 

public class ReverseList {
    //ReverseList - Class to Reverse a Linked List
    public static LinkedList<String> reverse(LinkedList<String> llList){
        //reverse(): Returns reversed list as Linked List
        //Implementation: Iterates through llList, pushes llList Elements to new List
        LinkedList<String> llBuf = new LinkedList<>();
        for (int iBuf = 0; iBuf < llList.size(); iBuf++) {
            llBuf.push(llList.get(iBuf));
        }
        return llBuf;
    }
    public static void main(String[] args){
        //main(): Tester for ReverseList class
        //Implementation: Calls to Methods
        Scanner oScanner = new Scanner(System.in);
        LinkedList<String> vStrings = Input.GetUserStringArray(oScanner, "Enter a list of Strings?> ");
        vStrings = reverse(vStrings);
        System.out.println("reverse(vStrings): " + vStrings);
    }
}