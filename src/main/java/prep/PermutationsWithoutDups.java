package prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 8.7 Permutations Without Dups 
 * 6/25/20
 */
public class PermutationsWithoutDups {
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        Set<String> set = new HashSet<String>(); 
        set.add("a"); 
        set.add("b"); 
        set.add("c");  
        set.add("d");  

        Iterator<String> value = set.iterator(); 
        ArrayList<Set<String>> list = new ArrayList<Set<String>>(); 
        System.out.println("Permutations Without Dups: " + permsWithoutDups(value, list));
    }

    static ArrayList<Set<String>> permsWithoutDups(Iterator<String> iter, ArrayList<Set<String>> list) {
        if (!iter.hasNext()) {
            return list; 
        }
        String iterString = iter.next();
        if (list.isEmpty()) { // only first case
            list.add(Set.of(iterString));
            return permsWithoutDups(iter, list);
        }
        ArrayList<Set<String>> old = new ArrayList<Set<String>>(); 
        old.addAll(list); // duplicate list for iteration
        
        for (Set<String> s : old) {
            if (!s.contains(iterString)) { // check if already contains
                String temp = s.iterator().next(); // get first letter
                for (int i = 0; i < temp.length() + 1; i++) {
                    if (i == 0) { // prepend
                        Set<String> sub = new HashSet<String>(); 
                        sub.add(iterString.concat(temp));
                        list.add(sub); 
                    } else if (i == temp.length()) { // append
                        Set<String> sub = new HashSet<String>(); 
                        sub.add(temp.concat(iterString));
                        list.add(sub);
                        list.remove(s);
                    } else { // middle(s)
                        Set<String> sub = new HashSet<String>(); 
                        String sub1 = temp.substring(0, i);
                        String sub2 = temp.substring(i, temp.length()); 
                        sub.add(sub1.concat(iterString).concat(sub2));
                        list.add(sub); 
                    }
                }

            }
        }
        return permsWithoutDups(iter, list);
    }

    /*
    static ArrayList<Set<String>> permsWithoutDups(Iterator<String> iter, ArrayList<Set<String>> list) {
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
                // char[] charArray = s.toString().toCharArray();

                sub.addAll(s); 
                sub.add(i); 
                
                list.add(sub); 
            }
        }
        System.out.println(list);
        return permsWithoutDups(iter, list);
    }
    */
}