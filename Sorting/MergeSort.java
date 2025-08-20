/* MergeSort.java - Class to Sort String List Lexicographically
 * Myles Darity-Reese
 * 12-Oct-23
 * What it Does:
 * Sort():Sorts a List of Strings in  Lexicographic Order
 * Merge(): Swaps vFirst and vSecond into Lexicographic Order then merges into vString Array
 * printArray(): Outputs ArrayList
 * main(): Tester for MergeSort
 */

public class MergeSort{
    //MergeSort.java - Class to Sort String List Lexicographically
    public static void Sort(String[] vStrings){  
        //Sort(): Sorts a List of Strings in Lexicographic Order
        //Implementation: Iterates vFirst and vSecond to add first and second half of vStrings
        if (vStrings.length <= 1) {return;}
        String[] vFirst = new String[vStrings.length / 2];
        String[] vSecond = new String[vStrings.length - vFirst.length];

        for (int i = 0; i < vFirst.length; i++){vFirst[i] = vStrings[i];}
        for (int i = 0; i < vSecond.length; i++){vSecond[i] = vStrings[vFirst.length + i];}
        
        Sort(vFirst);
        Sort(vSecond);
        Merge(vFirst, vSecond, vStrings);
   }

    private static void Merge(String[] vFirst, String[] vSecond, String[] vStrings){  
        //Merge(): Swaps vFirst and vSecond into Lexicographic Order then merges into vString Array
        //Implementation: Increments iFirst, iSecond, and iString
        int iFirst = 0;
        int iSecond = 0;
        int iString = 0;

        while (iFirst < vFirst.length && iSecond < vSecond.length){  
            if (vFirst[iFirst].compareToIgnoreCase(vSecond[iSecond]) < 0){  
                vStrings[iString] = vFirst[iFirst];
                iFirst++;
            }
            else{  
                vStrings[iString] = vSecond[iSecond];
                iSecond++;
            }
            iString++;
        }
        while (iFirst < vFirst.length){ 
            vStrings[iString] = vFirst[iFirst]; 
            iFirst++; iString++;
        }

        while (iSecond < vSecond.length){ 
            vStrings[iString] = vSecond[iSecond]; 
            iSecond++; iString++;
        }
    }

        public static void printArrayList(String[] vString){ 
        //printArray(): Outputs ArrayList
        //Implementation: Iterates print(), iString
        int iString = 1;
        for (String sString : vString){
            if(iString == vString.length){System.out.print(sString); continue;}
            System.out.print(sString + ", "); 
            iString++;
        }
        System.out.println(); 
    } 

    public static void main(String[] args){  
        //main(): Tester for MergeSort Class
        //Implementation: Calls to Methods
        String[] vStrings = {"Kale", "Apple", 
                             "Banna", "Plum", "Peach", "Tomato", "Carrot"};
        System.out.println("Below shows a Sorting Algorithm that sorts an Array Lexicographically");
        System.out.print("Original List: ");
        printArrayList(vStrings);
        Sort(vStrings);
        System.out.print("OUTPUT: ");
        printArrayList(vStrings);
        System.out.println("Expected: Apple, Banna, Carrot, Kale, Peach, Plum, Tomato");
    }
}
