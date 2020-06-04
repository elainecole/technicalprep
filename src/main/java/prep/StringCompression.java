package prep;

/**
 * 1.6 String Compression
 * 4/26/20
 */
public class StringCompression {
    public static void main(String[] args) throws Exception {
        System.out.println("Initializing Technical Prep");
        System.out.println("stringCompression: " + stringCompression("aa"));
    }

    public static String stringCompression(String in) {
        int tally = 0; 
        int i = 0; 
        String out = ""; 
        char val = in.charAt(i);
        while (i <= in.length() - 1) {
            while (Character.compare(in.charAt(i), val) == 0) {
                tally++; 
                if (i < in.length() - 1) {
                    i++; 
                } else {
                    break; 
                }
            }
            out = out + val + tally; 
            tally = 0;
            if (i < in.length() - 1) {
                val = in.charAt(i);
            } else {
                break; 
            }
        }
        if (in.length() <= out.length()) {
         System.out.println("out: " + out);

            return in; 
        }
        System.out.println("out: " + out);

        return out; 
    }
}