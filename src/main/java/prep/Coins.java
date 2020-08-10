package prep;

/**
 * 8.11 Coins
 * 8/5/20
 */
public class Coins {
    public static void main(String[] args) {
        System.out.println(makeChange(55)); 
        System.out.println(makeChange(66)); 
    }
    static int makeChange(int n) {
        System.out.println("change: " + n);
        
            int numQuarters = recurseChange(n, 25);
        n = n - numQuarters * 25; 
        int numDimes = recurseChange(n, 10); 
        n = n - numDimes * 10;
        int numNickels = recurseChange(n, 5);
        n = n - numNickels * 5; 
        int numPennies = recurseChange(n, 1); 
        n = n - numPennies;
        System.out.println("num Q: " + numQuarters); 
        System.out.println("num D: " + numDimes); 
        System.out.println("num N: " + numNickels); 
        System.out.println("num P: " + numPennies); 
        return n; 
    }
        
    static int recurseChange(int n, int coinVal) {
        if (n < coinVal) {
            return 0; 
        }
        return 1 + recurseChange(n - coinVal, coinVal); 
    }
}