/* Binary.java - Class to hold the MakeBinaryStr()
 * Myles Darity-Reese
 * 6-Oct-23
 * What it does:
 * MakeBinaryStr(): Returns String Binary Representation of a Number
 * Drive(): Outputs MakeBinaryStr()
 * main(): Tester for Binary
 */

import java.util.ArrayList;   //ArrayList
import java.util.Scanner;     //Scanner

public class Binary {
    //Binary - Class to hold the MakeBinaryStr()
    static String MakeBinaryStr(int nNum) {
        //MakeBinaryStr(): Returns String Binary Representation of a Number
        //Implementation: Recurs MakeBinaryStr() till nNum is 0
        if(nNum == 0){return "0";}
        if(nNum % 2 == 0){
            return MakeBinaryStr(nNum/2) + "0";
        } else {
            return MakeBinaryStr(nNum/2) + "1";
        }
    }

    private static void Drive(ArrayList<Integer> vNums){
        //Drive(): Outputs MakeBinaryStr()
        //Implementation: Iterates on MakeBinaryStr(), vNums
        //NOTE: Exceeds Expectations
        for (int iNum = 0; iNum < vNums.size(); iNum++) {
            System.out.println("MakeBinaryStr(" + vNums.get(iNum) + "): " 
                                          + MakeBinaryStr(vNums.get(iNum))); 
        }
    }

    public static void main(String[] args) {
        //main(): Tester for Binary
        //Implementation: Calls to Input
        Scanner oScanner = new Scanner(System.in);
        ArrayList<Integer> vNums = Input.GetIntList(oScanner);
        Drive(vNums);
    }
}
