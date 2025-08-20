/* Eratosthenes.java - Class to Find Prime Numbers using Sieve of Eratosthenes 
 * Myles Darity-Reese
 * 27-Oct-23
 * What it does:
 * CreateList(): Adds nNum of Trues
 * EraseComposites(): Changes vPrime's Index to False if is a Composite number
 * FindPrime(): Outputs Prime Numbers to nNum
 * main(): Tester for Eratosthenes Class
 */

import java.util.LinkedList;    //LinkedList
import java.util.Scanner;       //Scanner
import java.util.Stack;         //Stack

public class Eratosthenes {
    //Eratosthenes - Class to Find Prime Numbers using Sieve of Eratosthenes 
    //NOTE: Credit: https://www.geeksforgeeks.org/java-program-for-sieve-of-eratosthenes/
    private static void CreateList(Stack<Boolean> vPrime, int nNum){
        //CreateList(): Adds nNum of Trues
        //Implementation: Iterates vPrime
        //TODO:(Minor Bug): Fix Method to add nNum trues
        for(int i = 0; i <= nNum; i++)
            vPrime.add(true);
    }

    private static void EraseComposites(Stack<Boolean> vPrime, int nNum){
        //EraseComposites(): Changes vPrime's Index to False if is a Composite number
        //Implementation: Iterates through vPrime then Changes Element to False if a Composite, Math
        for(int iPrime = 2; iPrime*iPrime <= nNum; iPrime++){
            if(vPrime.get(iPrime) == true){
                for(int iElt = iPrime*iPrime; iElt <= nNum; iElt += iPrime)
                    vPrime.set(iElt, false);
            }
        }
    }

    public static void FindPrime(int nNum){
        //FindPrime(): Outputs Prime Numbers to nNum
        //Implementation: Iterates print(), Outputs vPrime's Index if it is true
        Stack<Boolean> vPrime = new Stack<>();
        CreateList(vPrime, nNum);

        EraseComposites(vPrime, nNum);

        for(int i = 2; i <= nNum; i++){
            if(vPrime.get(i) == true)
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        //main(): Tester for Eratosthenes Class
        //Implementation: Calls to Methods
        Scanner oScanner = new Scanner(System.in);
        LinkedList<Integer> vNum = Input.GetIntList(oScanner, "Enter a Number to Find all of its Primes: ");
        int nNum = vNum.get(0);
        System.out.print("FindPrime(" + nNum + "): ");
        FindPrime(nNum);
        System.out.println();
        System.out.println("Below Test Private Methods__________________________________________ ");
        Stack<Boolean> vBool = new Stack<>();
        CreateList(vBool, 5);
        System.out.println("CreateList(vBool, 5): " + vBool);
        System.out.println("Expected:             [true, true, true, true, true]");
        EraseComposites(vBool, 5);
        System.out.println("EraseComposites(vBool, 10): " + vBool);
        System.out.println("Expected:                   [true, true, true, true, false]");
    }
}
