package prep;

import java.util.LinkedList;

/**
 * 3.6 Animal Shelter
 * 5/7/20
 */
public class AnimalShelter {
    abstract class Animal {
        private int arrivalOrder; 
        protected String name; 
        public Animal(String n) { this.name = n; }
        public int getOrder() {return arrivalOrder; }
        public void setOrder(int order) {this.arrivalOrder = order; }

        public boolean isOlderThan(Animal a) {
            return this.arrivalOrder < a.getOrder();
        }
    }

    public class Dog extends Animal {
        public Dog(String n) {super(n); }
    }
    public class Cat extends Animal {
        public Cat(String n) { super(n); }
    }
    class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<Dog>(); 
    }
}