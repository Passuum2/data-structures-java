/* Math.java - Class for Common Math Algorithms
 * Myles Darity-Reese
 * 10-Oct-23
 * What it does:
 * Factor(): Returns Factors of nProduct as ArrayList
 * Factorize(): Adds all Factors of nNum to vFactors
 * Drive(): Outputs Factor()
 * main(): Tester for Math Class
 */

import java.util.ArrayList; //ArrayList

public class Math {
    //Math - Class for Common Math Algorithms
    static public ArrayList<Integer> Factor(int nProduct) throws BadDataException{
        //Factor(): Returns Factors of nProduct as ArrayList
        //Implementation: Calls to BadDataException
        if(nProduct <= 0){throw new BadDataException("Bad Number: " + nProduct);}
        ArrayList<Integer> vFactors = new ArrayList<>();
        vFactors.add(1);
        Factorize(nProduct, vFactors);
        vFactors.add(nProduct);
        return vFactors;
    }

    static public void Factorize(int  nNum, ArrayList<Integer> vFactors){
        //Factorize(): Adds all Factors of nNum to vFactors
        //Implementation: Recurs Factorize() till nNum is 1
        if(nNum == 1){return;}
        int nFactor = 2;
        while(nFactor <= nNum && nNum % nFactor != 0){nFactor++;}
        vFactors.add(nFactor);
        Factorize(nNum/nFactor, vFactors);
    }

    private static void Drive(int nCount) throws BadDataException{
        //Drive(): Outputs Factor()
        //Implementation: Iterates on Factor(), vFactor
        //NOTE: Exceeds Expectations
        for (int iCount = 1; iCount < nCount; iCount++) {
            ArrayList<Integer> vFactors = Factor(iCount);
            System.out.print("Factor("+iCount+"): ");
            for(int iFactor = 0; iFactor < vFactors.size(); iFactor++){
                if(iFactor == vFactors.size()-1){
                    System.out.print(vFactors.get(iFactor));
                    continue;
                }
                System.out.print(vFactors.get(iFactor) + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws BadDataException {
        //main(): Tester for Math Class
        //Implementation: Calls to Methods
        System.out.println("Bellow shows the factors of numbers 1-12");
        Drive(13);
    }
}
