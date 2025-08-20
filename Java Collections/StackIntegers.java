/*StackIntegers - Class to turn an Integer into a Stack ArrayList
 * Myles Darity-Reese
 * 29-Oct-23
 * What it Does:
 * TurnToStack(): Turns nNum's digits into Stack ArrayList 
 * print(): Outputs Stack ArrayList
 * main(): Tester for StackIntegers Class
 */
import java.util.LinkedList;    //LinkedList
import java.util.Scanner;       //Scanner
import java.util.Stack;         //Stack

public class StackIntegers {
    //StackIntegers - Class to turn an Integer into a Stack ArrayList
    public static Stack<Integer> TurnToStack(int nNum, Stack<Integer> vNum){
        //TurnToStack(): Turns nNum's digits into Stack ArrayList 
        //Implementation: Adds Last Digit of nNum to saNum, then adds Top element to vNum
        //NOTE: sa stands for Stack Array in a Variable
        Stack<Integer> saNum = new Stack<>();
        while (nNum > 0) {
            saNum.add(nNum % 10);
            nNum /= 10;
        }

        while(saNum.size() > 0){
            vNum.add(saNum.pop());
        }
        return vNum;
    }

    public static void print(Stack<Integer> saNum){
        //print(): Outputs Stack ArrayList
        //Implementation: Iterates through saNum
        System.out.println(saNum);
        System.out.print("print(saNum): ");
        for (int iNum = 0; iNum < saNum.size(); iNum++) {
            System.out.print(saNum.get(iNum) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //main(): Tester for StackIntegers Class
        //Implementation: Calls to Methods
        Scanner oScanner = new Scanner(System.in);
        LinkedList<Integer> vNum = Input.GetIntList(oScanner, "Enter a Number: ");
        int nNum = vNum.get(0);
        Stack<Integer> saNum = new Stack<>();
        TurnToStack(nNum, saNum);
        System.out.println("TurnToStack(nNum, saNum):" + saNum);
        print(saNum);
    }
}
