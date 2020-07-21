package prep;

/**
 * 1.9 String Rotation 
 * 6/22/20
 */
public class StringRotation {
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        System.out.println("String Rotation: " + isRotation("waterbottle", "erbottlewat"));
    }

    static boolean isRotation(String s1, String s2) {
        String s1Double = s1 + s1; 
        return isSubstring(s2, s1Double); 
    }

    static boolean isSubstring(String s1, String s2) {
        
        return true; 
    }
    
}