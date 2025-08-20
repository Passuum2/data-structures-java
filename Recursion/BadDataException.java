/* BadDataException.java - Class for Custom Exception
 * Myles Darity-Reese
 * 4-Oct-23
 * What it does:
 * BadDataException(): Throws an IOException when thrown
 * BadDataException(): Throws an IOException with a message when thrown
 * Error(): Throws Custom Error if nNumber is 2
 * main(): Tester for BadDataException
 */
import java.io.IOException; // IOException

public class BadDataException extends IOException {
    // BadDataException - Class for Custom Exception
    // NOTE: Credit: Hortsmann
    public BadDataException() {
        // BadDataException(): Throws an IOException when thrown
        // Implementation: Extends from IOException
    }

    public BadDataException(String sMessage) {
        // BadDataException(): Throws an IOException with a message when thrown
        // Implementation: Extends from IOException
        super(sMessage);
    }

    private static void Error(int nNumber) throws BadDataException{
        // Error(): Throws Custom Error if nNumber is 2
        // Implementation: Throws Custom Error if nNumber is 2
        if(nNumber == 2){throw new BadDataException("Error(" + nNumber + "): " + 
                                                    "Bad Number: " + nNumber);}
        else{System.out.println("Error(" + nNumber + "): "
                                         + nNumber + " is not a Bad Number");}
    }
    public static void main(String[] args) throws BadDataException {
        //main(): Tester for BadDataException
        //Implementation: Calls to Methods
        System.out.println("START");
        Error(1);
        Error(2);
    }
}