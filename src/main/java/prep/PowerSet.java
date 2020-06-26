package prep;

import java.util.*; 

/**
 * 8.4 Power Set
 * 6/17/20
 * 
 */
public class PowerSet {
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        Set<String> set = new HashSet<String>(); 
        set.add("a"); 
        set.add("b"); 
        set.add("c");  
        Iterator<String> value = set.iterator(); 
        ArrayList<Set<String>> list = new ArrayList<Set<String>>();
        System.out.println("Power Set: " + powerSet(value, list));
    }

    static ArrayList<Set<String>> powerSet(Iterator<String> iter, ArrayList<Set<String>> list) {
        if (!iter.hasNext()) {
            return list; 
        }
        String i = iter.next();
        list.add(Set.of(i));  
        ArrayList<Set<String>> old = new ArrayList<Set<String>>(); 
        old.addAll(list); 
        for (Set<String> s : old) {
            if (!s.contains(i)) {
                Set<String> sub = new HashSet<String>(); 
                sub.addAll(s); 
                sub.add(i); 
                list.add(sub); 
            }
        }
        System.out.println(list);
        return powerSet(iter, list);
    }
}