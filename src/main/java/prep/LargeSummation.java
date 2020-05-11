package prep;

import java.math.BigInteger; 

/**
 * Large Summation 
 * Cisco technical exercise 
 * 
 * Sums the multiples of a given factor less than or 
 *  equal to a given ceiling 
 * 
 * Usage: 
 * LargeSummation <factor> <ceiling>
 * i.e., LargeSummation 5 999999999
 * 
 * While I could have coded a solution that 
 *  sums multiples of both 5 and 7 less than 1 million 
 *  explicitly, I chose instead to write a program that 
 *  is generalized and can sum multiples of a given factor 
 *  less than a given ceiling received as command line
 *  arguments. 
 * 
 * Therefore, I solved the problem by running this program 
 *  twice (LargeSummation 7 1000000000 and LargeSummation 
 *  5 999999999) and took the sum of the returned values. 
 * 
 * Given the size limits of Java's int, I chose to use the 
 * existing BigInteger from Java's math library. 
 */
public class LargeSummation {
    public static void main(String[] args) {
        BigInteger firstArg, secondArg; 
        if (args.length == 2) {
            // check that received two BigIntegers
            try {
                firstArg = BigInteger.valueOf(Integer.parseInt(args[0])); 
                secondArg = BigInteger.valueOf(Integer.parseInt(args[1])); 
                System.out.println("LargeSummation(" + firstArg + ", " + secondArg 
                    + "): " + sumMultiples(firstArg, secondArg));
            } catch (NumberFormatException e) {
                System.err.println("LargeSummation received " + args[0] + ", " 
                    + args[1] + ": must both be integers (BigInteger).");
                e.printStackTrace();
            }
        } else {
            System.err.println("usage: LargeSummation <factor> <ceiling>");
        }
    }

    /**
     * sumMultiples - sum the multiples of factor less than 
     *  or equal to ceiling
     * 
     * starting at the largest multiple less than or equal to ceiling (retrieved 
     *  by call to findLargestMultiple), sum each multiple by repeatedly 
     *  subtracting by one factor until we are at a number less than factor 
     *  (should be zero given the nature of multiples)
     * @param factor - BigInteger 
     * @param ceiling - BigInteger greater than or equal to factor
     * @return sum of multiples; explicitly 0 if unsuccessful given bad parameter(s)
     */
    public static BigInteger sumMultiples(BigInteger factor, BigInteger ceiling) {
        BigInteger index;
        BigInteger sum = BigInteger.ZERO; 
        // check parameters: 
        if (factor.signum() <= 0 || ceiling.signum() <= 0) { 
            // param(s) negative or zero; no multiples to be found so sum is zero
            System.err.println("LargeSummation: sumMultiples received " + factor + ", " + ceiling 
                + ": must both be positive nonzero integers (BigInteger).");
            return sum; 
        }
        if (factor.compareTo(ceiling) > 0) {
            // factor is greater than ceiling; no multiples to be found so sum is zero
            System.err.println("LargeSummation: sumMultiples received " + factor + ", " + ceiling 
                + ": first integer must be less than or equal to second integer (BigInteger).");
            return sum; 
        }
        index = findLargestMultiple(factor, ceiling); 
        while (index.compareTo(factor) >= 0) {
            // index has not decreased below factor 
            sum = sum.add(index);
            index = index.subtract(factor); 
        }
        return sum; 
    }

    /**
     * findLargestMultiple - find the largest multiple of factor 
     *  that is less than or equal to ceiling
     * 
     * this method is not optimized for large values of factor, as we 
     *  find the largest multiple less than or equal to ceiling by recursively
     *  decrementing ceiling by one
     * @param factor - BigInteger 
     * @param ceiling - BigInteger greater than or equal to factor
     * @return largest multiple of factor less than or equal to ceiling
     */
    public static BigInteger findLargestMultiple(BigInteger factor, BigInteger ceiling) {
        if (ceiling.mod(factor).equals(BigInteger.ZERO)) { 
            // base case: found greatest multiple <= ceiling
            return ceiling; 
        }
        return findLargestMultiple(factor, ceiling.subtract(BigInteger.valueOf(1))); 
    }
}