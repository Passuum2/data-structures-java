/* Input.java: Class for Prompting Methods
 * Myles Darity-Reese
 * 06-Oct-23
 * print(): Wrapper for java.lang.System.out.print()
 * println(): Wrapper for java.lang.System.out.println()
 * GetUserStringArray(): Returns User Entered Array List of Strings
 * main(): Tester for Input: Methods
 * GetIntList(): Returns true if Positive Destination List can be from the Source (Src) List
 * ForceIntList(): Returns true if Positive Destination List can be from the Source (Src) List
 */

import java.util.ArrayList;         //ArrayList
import java.util.Scanner;           //Scanner
import java.util.StringTokenizer;   //StringTokenizer()
import static java.lang.System.out; //print(), println()

public class Input {
    //Input: Prompting Methods, Print Methods
    public static void print(String str){
        // print(): Output string
        // Implementation: wrapper for System.out.print
        // NOTE: CREDIT: https://www.quora.com/How-is-it-possible-to-use-only-println-instead-of-System-out-println-in-Java
        out.print(str);
    }

    public static void println(String str){
        // println(): Output string w/ CR
        // Implementation: wrapper for System.out.println
        // NOTE: CREDIT: https://www.quora.com/How-is-it-possible-to-use-only-println-instead-of-System-out-println-in-Java
        out.println(str);
    }

    public static ArrayList<String> GetUserStringArray(Scanner oScanner, String sPromt){
        //GetUserStringArray(): Returns User Entered Array List of Strings
        //Implementation: Iterate StringTokenizer.nextToken on Scanner
        //NOTE: CREDIT: https://www.techiedelight.com/read-string-standard-input-java/
        print(sPromt);
        ArrayList<String> vRet = new ArrayList<>();
        StringTokenizer sToken = new StringTokenizer(oScanner.nextLine());
        while(sToken.hasMoreElements()){
            vRet.add(sToken.nextToken());
        }
        return vRet;
    }

    public static ArrayList<Integer> GetIntList(Scanner scanner){
        //GetIntList(): Only returns when user enters a Integer List
        //Implementation: Iterate on Prompted GetIntList()
        ArrayList<Integer> vRet = new ArrayList<>();
        do{
            ArrayList<String> vTokens = GetUserStringArray(scanner, "Enter a List of Numbers?> ");
            if(ForceIntList(vTokens, vRet)){break;}
        } while(true);
         
        return vRet;
    }

    public static boolean ForceIntList(ArrayList<String> vSrc, ArrayList<Integer> vDst){
        //ForceIntList(): Returns true if Positive Destination List can be from the Source (Src) List
        //Implementation: Iteration on Integer.parseInt and less than or equal to 0
        //NOTE: CREDIT: https://stackoverflow.com/questions/7708698/convert-arrayliststring-to-an-arraylistinteger-or-integer-array
        for(String sSrc : vSrc){
            try{ 
                vDst.add(Integer.parseInt(sSrc));
            } catch (NumberFormatException nfe){
                System.out.println("Could not convert: "+sSrc);
                vDst.clear();
                return false;
            }
        }
        return true;
     } 

    public static void main(String[] args) {
        //main(): Tester for Input: Methods
        //Implementation: Assignments for readInt():
        /*NOTE: This Code Block Test:
         * print()
         * println()
         * GetUserStringArray()
         */
        Scanner oScanner = new Scanner(System.in);
        ArrayList<String> vString = GetUserStringArray(oScanner, "Enter List of String?> ");
        System.out.println(vString);
        ArrayList<Integer> vNum = GetIntList(oScanner);
        System.out.println(vNum);
        
        println("Too lazy for System.out.println");
        print("Too lazy for System.out.print");
    }

}


