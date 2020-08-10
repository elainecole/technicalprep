package prep;

/**
 * 8/3/20
 * Given int n 
 * Output # prime numbers < n
 * Prime number: only divisible by itself and 1
 * Check each # less than itself > 1, if mod isn’t 0
 * BF: check each number starting at 2 up to n - 1, see if it is a prime number 
 */
public class IsPrime {
    boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false; 
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false; 
            }
        }
        return true; 
    }
     
    int primeNumbers(int n) {
        int numPrime = 0; 
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (isPrime(i)) {
                numPrime++; 
            }
        }
        return numPrime; 
    }
    
}