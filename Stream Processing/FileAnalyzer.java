/* FileAnalyzer.java - Class for Prompting Methods
 * Myles Darity-Reese
 * 28-Sept-23
 * What it does:
 * GetUserFile(): Returns User Input Files as String ArrayList
 * FindFile(): Returns True is File exists, Returns corrected File Name
 * main(): Tester for FileAnalyzer class
 */

import java.io.File;                     //File()
import java.io.FileNotFoundException;    //FileNotFoundException
import java.util.ArrayList;              //ArrayList
import java.util.Scanner;                //Scanner
import java.util.StringTokenizer;        //StringTokenizer()

public class FileAnalyzer {
    //FileAnalyzer: Class for Prompting Methods

    private static ArrayList<String> vFile = new ArrayList<>();

    public static String GetUserFile(Scanner oScanner, String sPromt) throws Exception{
        //GetUserFile(): Returns User Inputed Files as String ArrayList
        //Implementation: Iterate StringTokenizer.nextToken on Scanner, vFile.get()
        //NOTE: CREDIT: https://www.techiedelight.com/read-string-standard-input-java/
        System.out.print(sPromt);
        
        StringTokenizer sToken = new StringTokenizer(oScanner.nextLine());
        while(sToken.hasMoreElements()){
            vFile.add(sToken.nextToken());
        }
        
        for (int iFile = 0; iFile < vFile.size();iFile++){
            if(!FindFile(vFile.get(iFile), iFile)){
                throw new Exception("Cannot find file: " + vFile.get(iFile));
            }
        }
        return vFile.get(0);
    }

    private static boolean FindFile(String sFile, int iFile){
        //FindFile(): Returns True is File exists, Returns corrected File Name
        //Implementation: Calls to File, Scanner class
        //NOTE: This exceeds expectations
        try (Scanner oScanner = new Scanner(new File(sFile))) {
            return true;
        } catch (FileNotFoundException FNFE){}

        try (Scanner oScanner = new Scanner(new File(sFile + ".txt"))) {
            vFile.set(iFile, vFile.get(iFile) +".txt");
            return true;
        } catch (FileNotFoundException FNFE){}

        try (Scanner oScanner = new Scanner(new File(sFile + ".in"))) {
            vFile.set(iFile, vFile.get(iFile) +".in");
            return true;
        } catch (FileNotFoundException FNFE){return false;}
    }

    public static void main(String[] args) throws Exception {
        //main(): Tester for FileAnalyzer class
        //Implementation: Calls to Methods
        Scanner oScanner = new Scanner(System.in);
        String sFileName = GetUserFile(oScanner, "Enter Multiple File Name (Entering .txt or .in is unnecessary): ");
        System.out.println(sFileName);
        System.out.print("FindFile(Input1): " + FindFile("Input1",0));
    }
}
