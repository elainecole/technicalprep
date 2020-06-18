package prep;

/**
 * 8.5 Recusrive Multiply
 * 6/15/20
 */
public class RecursiveMultiply {

    public static void main(String[] args) throws Exception {
        System.out.println("Initializing Technical Prep");
        System.out.println("Recursive Multiply Add: " + recursiveMultiplyAdd(33, 4));
        System.out.println("Recursive Multiply Bit Shift: " + recursiveMultiplyBitShift(33, 4));
    }

    static int recursiveMultiplyAdd(int num1, int num2) {
        if (num1 == 0) {
            return 0; 
    }
        num1--; 
        return recursiveMultiplyAdd(num1, num2) + num2; 
    }
    

    static int recursiveMultiplyBitShift(int num1, int num2) {
        if (num1 == 0) return 0;
        if (num1 == 1) return num2; 
        if (num1 % 2 == 1) { // odd
            return num2 + (recursiveMultiplyBitShift(num1 >> 1, num2) << 1);
        }
        return recursiveMultiplyBitShift(num1 >> 1, num2) << 1; 
    }
    
}