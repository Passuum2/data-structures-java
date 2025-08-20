/* TheScanner.java - Class that holds Methods for reading Files
 * Myles Darity-Reese
 * 28-Nov-23
 * LinesWithThe(): Outputs total lines from a file that contains "the"
 * TheInFile(): Outputs the total of "the" in a file
 * PrintLinesWithThe(): Outputs lines containing the word the
 * PrintWordsLTFC(): Outputs unique words from a file with at most 4 characters in Lexicographic Order
 */

import java.util.Arrays;        // Arrays, asList()
import java.io.IOException;     // IOException
import java.nio.file.Files;     // Files, lines(), split()
import java.nio.file.Paths;     // Paths, get()
import java.util.stream.Stream; // Stream, flatMap(), filter(), forEach(), close(), distinct(), map()
import java.util.Scanner;       // Scanner

public class TheScanner {
   //TheScanner: Class that holds Methods for reading Files

   public static void LinesWithThe(String sFile) throws IOException{
      //LinesWithThe(): Outputs total lines from a file that contains "the"
      //Implementation: lines() | filter() | contains("the") | count()
      //NOTE: Closed Stream
      long lCount = 0;
      try (Stream<String> streamLine = Files.lines(Paths.get(sFile))){
         lCount = streamLine
            .filter(line -> Arrays.asList(line.split("\\s+"))
            .contains("the"))
            .count();
         streamLine.close();
      }
      System.out.println(sFile + " has " + lCount + " line(s) containing the word \"the\".");
   }

   public static void TheInFile(String sFile) throws IOException{
      //TheInFile(): Outputs the total of "the" in a file
      //Implementation: lines() | flatMap(split(whitespace)) | filter(equalsIgnoreCase) | count()
      //NOTE: Credit: Code started by ChatGPT
      long lCount = 0;
      try(Stream<String> streamLine = Files.lines(Paths.get(sFile))){
         lCount = streamLine
            .flatMap(line -> Stream.of(line.split("\\s+")))
            .filter(word -> word.equalsIgnoreCase("the"))
            .count();
         streamLine.close();
      }
      System.out.println(sFile + " has " + lCount + " word(s) of \"the\".");
   }

   public static void PrintLinesWithThe(String sFile) throws IOException{
      //PrintLinesWithThe(): Outputs lines containing the word the
      //Implementation: lines() | filter() | contains("the") | forEach(println)
      System.out.println("(All Lines with \"the\" Below) ______________________________________");
      try (Stream<String> streamLine = Files.lines(Paths.get(sFile))){
         streamLine
            .filter(line -> Arrays.asList(line.split("\\s+"))
            .contains("the"))
            .forEach(System.out::println);
         streamLine.close();
      }
      System.out.println("(All Lines with \"the\" Above) ______________________________________");
   }

   public static void PrintWordsLTFC(String sFile) throws IOException{
      //PrintWordsLTFC(): Outputs unique words from file with at most 4 characters in Lexicographic Order
      //Implementation: lines() | flatMap(whitespace) | map(toLowercase) | filter(length <= 4) | distinct() | sorted() | forEach(println)
      //NOTE: Credit: Helped by ChatGPT
      System.out.println("(All unique words Below) ______________________________________");
      try(Stream<String> streamLine = Files.lines(Paths.get(sFile))){
         streamLine
            .flatMap(line -> Stream.of(line.split("\\s+")))
            .map(String::toLowerCase)
            .filter(word -> word.length() <= 4)
            .distinct()
            .sorted()
            .forEach(System.out::println);
         streamLine.close();
      }
      System.out.println("(All unique words Below) ______________________________________");
   }

   public static void main(String[] args) throws Exception {
      //main(): Tester
      //Implementation: Calls to Methods
      Scanner oScanner = new Scanner(System.in);
      String sFile = FileAnalyzer.GetUserFile(oScanner, "Enter File Name ?> "); //NOTE: You don't need to type the file extention
      LinesWithThe(sFile);
      TheInFile(sFile);
      PrintLinesWithThe(sFile);
      PrintWordsLTFC(sFile);
      oScanner.close();
   }
}