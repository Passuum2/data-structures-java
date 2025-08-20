/* BubbleSort.java - Class to Sort Int List using Bubble Sort
 * Myles Darity-Reese
 * 12-Oct-23
 * What it does:
 * BubbleSwap(): Exchange ints at Indices if Condition is True
 * BSort(): Runs BubbleSwap vInts.size() times
 * printArray(): Outputs ArrayList
 * main(): Tester for BubbleSort Class
 */

import java.util.ArrayList;   //ArrayList
import java.util.Arrays;      //asList()

public class BubbleSort {
    //BubbleSort - Class to Sort Int List using Bubble Sort
    static private void BubbleSwap(ArrayList<Integer> vInts){
        //BubbleSwap(): Exchange ints at Indices if Condition is True
        //Implementation: Iterates
        for (int iInt = 0; iInt < vInts.size(); iInt++) {
            int jInt = iInt + 1;
            try{
                if(vInts.get(iInt) > vInts.get(jInt)){
                    int nTempInt = vInts.get(iInt);
                    vInts.set(iInt, vInts.get(jInt));
                    vInts.set(jInt, nTempInt);
                }
            } catch(IndexOutOfBoundsException IOOB){return;}
        }
    }

    static public void BSort(ArrayList<Integer> vInts){
        //BubbleSort(): Runs BubbleSwap vInts.size() times
        //Implementation: Iterates BubbleSwap
        for (int iInt = 0; iInt < vInts.size(); iInt++) {
            BubbleSwap(vInts);
        }
    }

    public static void printArrayList(ArrayList<Integer> vInts){ 
        //printArray(): Outputs ArrayList
        //Implementation: Iterates print(), iString
        int iString = 1;
        for (Integer sString : vInts){
            if(iString == vInts.size()){System.out.print(sString); continue;}
            System.out.print(sString + ", "); 
            iString++;
        }
        System.out.println(); 
    } 

    public static void main(String[] args) {
        //main(): Tester for BubbleSort Class
        //Implementation: Calls to Methods
        ArrayList <Integer> vInts = new ArrayList<>(Arrays.asList (25, 5, 5, 1, 10));
        System.out.println("Below shows a Sorting Algorithm that uses Bubble Swap");
        System.out.print("Original List: ");
        printArrayList(vInts);
        BSort(vInts);
        System.out.print("OUTPUT: ");
        printArrayList(vInts);
        System.out.println("Expected: " + "1, " +"5, " +"5, " + "10, " + "25");
    }
}
