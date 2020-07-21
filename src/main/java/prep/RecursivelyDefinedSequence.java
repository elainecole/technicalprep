package prep;

/**
 * Recursively-Defined Sequence
 * 5/5/20
 * 
 * Cisco technical exercise 
 * 
 * Given two functions f(n) and a(n), defined as such: 
 *  - f(n) returns a number: 
 *      - if n is even, f(n) = (n / 2)
 *      - if n is odd, f(n) = (1 + n * 3)
 *  - a(n) returns a sequence of numbers: 
 *      - initial element is n
 *      - each following element is function f applied to 
 *          previous element 
 *      - sequence terminates after it evaluates to 1
 *  this returns the sum of the elements in the sequence 
 *  returned by a(n) given some integer n parameter 
 * 
 * Usage: 
 * RecursivelyDefinedSequence <integer greater than 0>
 * i.e., RecursivelyDefinedSequence 3
 * 
 * This class is not optimized for numeric values larger than 
 *  what Java's int can handle (i.e., BigInteger). This also only 
 *  takes in integers (no doubles) given the behavior of 
 *  functions f(n) and a(n). 
 */
public class RecursivelyDefinedSequence {
    public static void main(String[] args) {
        int firstArg;
        if (args.length == 1) {
            // check that received one integer
            try {
                firstArg = Integer.parseInt(args[0]); 
                System.out.println("RecursivelyDefinedSequence(" + firstArg + "): " 
                    + sumSequence(firstArg));
            } catch (NumberFormatException e) {
                System.err.println("RecursivelyDefinedSequence received " + args[0] 
                    + ": must be integer.");
                e.printStackTrace();
            }
        } else {
            System.err.println("usage: RecursivelyDefinedSequence <integer greater than 0>");
        }
    }

    /**
     * sumSequence - starting at n, sums values of 
     *  sequence of numbers of function a(n):
     * - initial element is n
     * - each subsequent element is function f (calculation())
     *  applied to previous element (prev)
     * - terminate after evaluate to 1
     * @param n - must be an int, greater than 0 (checked)
     * @return sum of sequence of a(n), -1 if n is not greater than 0
     */
    public static int sumSequence(int n) {
        int prev = n; 
        int sum, curr; 
        if (n < 1) {
            // check that received nonzero positive n
            System.err.println("RecursivelyDefinedSequence: sumSequence received " + n 
                + ": must be integer greater than 0.");
            return -1;
        } 
        sum = prev; 
        while (prev != 1) { // base case: 1
            curr = calculation(prev); 
            sum += curr; 
            prev = curr; 
        }
        return sum; 
    }

    /**
     * calculation - returns value of function f(n): 
     * - if n is even, f(n) = (n / 2)
     * - if n is odd, f(n) = (1 + n * 3)
     *  @param n - int (input of f(n))
     *  @return value of specified f(n)
     */
    public static int calculation(int n) {
        if (n % 2 == 0) {
            // n is even
            return (n / 2);
        } 
        // n is odd
        return (n * 3 + 1);
    }
}