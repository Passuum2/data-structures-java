/* IntSort.java: Class for Selection Sort on int array
 * Myles Darity-Reese
 * 09-Oct-23
 * What it does:
 * IntSort(): Constructor
 * Sort(): Sort Elements of Instance Variable int Array
 * GetMinPos(): Return Index of Smallest Elt in ArrayList tail
 * Swap(): Exchange ints at Indices
 * main(): Tester for IntSort Class
 */

import java.util.ArrayList;   //ArrayList
import java.util.Arrays;      //asList()

public class IntSort {
   //IntSort: Selection Sort on int array
   public ArrayList<Integer> vInt = new ArrayList<>();

   public IntSort(ArrayList<Integer> vInt) {
      //IntSort(): Constructor
      //Implementation: Assigns Parameters to Instance Variables
      this.vInt = vInt;
   }
   public void Sort(){
      //Sort(): Sort Elements of Instance Variable int Array
      //Implementation: Iterates GetMaxPos(), Swap()
      for (int iElt = 0; iElt < vInt.size() - 1; iElt++) {
         int nMaxPos = GetMaxPos(iElt);
         Swap(nMaxPos, iElt);
      }
   }
   private int GetMaxPos(int nFrom) {
      //GetMinPos(): Return Index of Smallest Elt in ArrayList tail
      //Implementation: Iterates vInt
      int nMaxPos = nFrom;
      for (int iPos = nFrom + 1; iPos < vInt.size(); iPos++)
         if (vInt.get(iPos) > vInt.get(nMaxPos)) nMaxPos = iPos;
      return nMaxPos;
   }
   private void Swap(int i, int j) {
      //Swap(): Exchange ints at Indices
      //Implementation: Assignment with Temp Storage
      int nTempInt = vInt.get(i);
      this.vInt.set(i,this.vInt.get(j));
      this.vInt.set(j, nTempInt);
   }
   public static void main(String[] args) {
      //main(): Tester for IntSort Class
      //Implementation: Calls to Methods
      ArrayList <Integer> vInts = new ArrayList<>(Arrays.asList (25, 5, 5, 1, 10));
      System.out.println("Below shows a Sorting Algorithm that swaps in Decending Order");
      System.out.println("Original List: " + vInts);
      IntSort oSelSort = new IntSort(vInts);
      oSelSort.Sort();
      System.out.print("OUTPUT:        ");
      System.out.println(oSelSort.vInt);
      System.out.println("Expected:      [" + "25, " +"10, " +"5, " + "5, " + "1]");
   }
}