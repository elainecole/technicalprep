package prep;

/**
 * 1.4 Palindrome Permutation
 * 8/15/20
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        String test = "taco cat"; 
        String test2 = "oacc att"; 
        String test3 = "bad"; 
        System.out.println("Initializing Technical Prep");
        System.out.println("Palindrome Permutation: " + test + ": " + isPermutationOfPalindrome(test));
        System.out.println("Palindrome Permutation: " + test2 + ": " + isPermutationOfPalindrome(test2));
        System.out.println("Palindrome Permutation: " + test3 + ": " + isPermutationOfPalindrome(test3));
    }

    static int getCharNum(char c, int a, int z) {
        int num = Character.getNumericValue(c); 
        if (a <= num && z >= num) {
            return num - a; 
        }
        return -1; 
    }

    static boolean isPermutationOfPalindrome(String s) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int countOdd = 0; 
        int[] table = new int[z - a + 1];
        for (char c : s.toCharArray()) {
            int val = getCharNum(c, a, z);
            if (val != -1) {
                table[val]++;
                if (table[val] % 2 > 0) {
                    countOdd++; 
                } else {
                    countOdd--; 
                }
            }
        }
        return countOdd <= 1; 
    }
}