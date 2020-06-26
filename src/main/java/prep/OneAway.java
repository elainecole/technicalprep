package prep;

/**
 * 1.5 One Away
 * 4/26/20
 */
public class OneAway {
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        System.out.println("isOneAway: " + isOneAway("test", "test"));
    }

    public static boolean isOneAway(String a, String b) {
        int countOff = 0;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (countOff == 1) {
                        return false;
                    }
                    countOff++;
                }
            }
        } else {
            String longer; 
            String shorter; 
            if (a.length() > b.length()) {
                longer = a;
                shorter = b;
            } else {
                longer = b;
                shorter = a;
            }
            for (int i = 0; i < longer.length(); i++) {
                if (i < shorter.length()) {
                    if (longer.charAt(i) != shorter.charAt(i)) {
                        if (countOff == 1) {
                            return false;
                        }
                        countOff++;
                        longer = longer.substring(0, i) + longer.substring(i + 1);
                    }
                } else {
                    return false; 
                }
                
            }
        }
        return true;
    }
}