package prep;

import java.util.Calendar;

/**
 * Leap Day
 * 5/5/20
 * 
 * Cisco technical exercise 
 * 
 * Calculates the number of leap days that fell on each 
 *  weekday on and between two given years. 
 * 
 * Usage: 
 * LeapDay <start year> <end year>
 * i.e., LeapDay 1900 2000
 * 
 * In getWeekdaysOfLeapDays, I chose to return the int array 
 *  regardless of success or falure so that this method could more
 *  easily be extended upon in some future work. 
 * 
 * While printWeekdaysOfLeapDays has constant Big O time, 
 *  getWeekdaysOfLeapDays is not optimized for large intervals 
 *  between start year and end year as it checks each year one at a time. 
 */
public class LeapDay {
    public static void main(String[] args) {
        int firstArg, secondArg;
        if (args.length == 2) {
            // check that received two integers
            try {
                firstArg = Integer.parseInt(args[0]); 
                secondArg = Integer.parseInt(args[1]); 
                System.out.println("LeapDay(" + firstArg + ", " + secondArg + "): ");
                getWeekdaysOfLeapDays(firstArg, secondArg);
            } catch (NumberFormatException e) {
                System.err.println("LeapDay received " + args[0] + ", " + args[1] 
                    + ": must both be integers.");
                e.printStackTrace();
            } 
        } else {
            System.err.println("usage: LeapDay <start year (integer greater than 0)>" 
                + " <end year (integer greater than 0)>");
        }   
    }
    
    /** 
     * getWeekdaysOfLeapDays - keeps track of the number of 
     *  leap days on each weekday between startYear and endYear
     *  inclusive. 
     * 
     * Uses java.util.Calendar class (one instance only)
     * @param startYear - int 
     * @param endYear - int greater than or equal to startYear (checked)
     * @return countPerWeekday  - int[] in order Su M T W H F Sa; on bad param(s) 
     *  this array is returned empty
     */
    public static int[] getWeekdaysOfLeapDays(int startYear, int endYear) {
        int currYear; 
        Calendar calendar; 
        int[] countPerWeekday = new int[7];
        // check parameters: 
        if (startYear <= 0 || endYear <= 0) {
            // received negative or zero year param(s); no leap days, return empty array
            System.err.println("LeapDay: weekdayLeapDays received " + startYear + ", " + endYear 
                + ": must both be integers greater than 0.");
            return countPerWeekday;  
        } 
        if (startYear > endYear) {
            // startYear is not less than (or equal to) endYear; no leap days, return empty array
            System.err.println("LeapDay: weekdayLeapDays received " + startYear + ", " + endYear 
                + ": starting year must be less than or equal to end year.");
            return countPerWeekday; 
        }
        // maintain one calendar instance for all years that are checked
        calendar = Calendar.getInstance(); 
        currYear = startYear; 
        while (currYear <= endYear) { 
            // check each year incrementally: [startYear, endYear] (inclusive)
            if (currYear % 400 == 0 || (currYear % 4 == 0 && currYear % 100 != 0)) {
                /* year number divisible by 400; leap year or 
                    year number divisible by 4 and not 100; leap year */
                calendar.set(currYear, Calendar.FEBRUARY, 29); 
                countPerWeekday[calendar.get(Calendar.DAY_OF_WEEK) - 1]++; 
            }
            currYear++; 
        }
        // print for ease: 
        printWeekdaysOfLeapDays(countPerWeekday);
        return countPerWeekday; 
    }
    
    /** 
     * printWeekdaysOfLeapDays - explicitly print out a formatted table 
     *  to command line detailing the number of leap days on each weekday 
     * 
     * @param countPerWeekday - int[] in order Su M T W H F Sa
     */
    public static void printWeekdaysOfLeapDays(int[] countPerWeekday) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", 
        "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.printf("%-10sNumber of leap days:%n", "Weekday:");
        for (int i = 0; i < countPerWeekday.length; i++) {
            System.out.printf("%-15s%d%n", daysOfWeek[i], countPerWeekday[i]);
        }
        return; 
    }
}