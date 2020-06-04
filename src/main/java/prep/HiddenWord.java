package prep;

/**
 * Java Practice with Dad: from AP Comp Sci practice 
 * 5/28/20
 * 
 * Consider a guessing game in which a player tries to guess a hidden word. 
 * The hidden word contains only capital letters and has a length known to the player. 
 * A guess contains only capital letters and has the same length as the hidden word. 
 * After a guess is made, the player is given a hint that is based on a comparison between 
 * the hidden word and the guess. Each position in the hint contains a character that 
 * corresponds to the letter in the same position in the guess. The following rules 
 * determine the characters that appear in the hint.
 * 
 * The HiddenWord class will be used to represent the hidden word in the game. 
 * The hidden word is passed to the constructor. The class contains a method, getHint, 
 * that takes a guess and produces a hint. 
 */
public class HiddenWord {
        String word; 
        int wordLength; 
    
    public HiddenWord(String w) {
        this.word = w;
        this.wordLength = w.length(); 
    }

    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep: Paths with Sum");
    }
    public String getHint(String guess) {
        char[] wordChars = word.toCharArray();
        char[] guessChars = guess.toCharArray(); 
        char[] hintChars = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            hintChars[i] = '*'; // base case: wrong letter
            if (guessChars[i] == wordChars[i]) { 
                // correct letter and position
                hintChars[i] = guessChars[i];
            } else { // could also have done continue at end of if
                for (int j = 0; j < wordLength; j++) {
                    if (guessChars[i] == wordChars[j]) {
                        // right letter, wrong position
                        hintChars[i] = '+'; 
                    }
                }
    }
        }
        return hintChars.toString(); 
    }
    
}