package OOPs;
public class OPPS {
    public static void main(String[] args) {
        // Pen p1 = new Pen();
        // p1.setColor("Pink");
        // p1.setTipSize(3);
        // System.out.println("Color of Pen p1 = " + p1.getColor());   
        // System.out.println("Tip size of Pen p1 = " + p1.getTipSize());
        // p1.setColor("Yellow");
        // System.out.println("Color of Pen p1 = " + p1.getColor());  
        
        // BankAccount myAccount = new BankAccount();
        // myAccount.username = "Lightning Ace";
        // myAccount.setPassword("Omkar123");
        // System.out.println("Username: " + myAccount.username);

        // Student s1 = new Student();
        // s1.name = "Omkar";
        // s1.rollNo = 3;
        // s1.password = "789";
        // s1.marks[0] = 100;
        // s1.marks[1] = 90;
        // s1.marks[2] = 80;

        // Student s2 = new Student(s1);
        // s2.password = "123";
        // s1.marks[2] = 100;
        // for(int i = 0; i < 3 ; i++) {
        //     System.out.println(s2.marks[i]);
        // }  


        // Fish shark = new Fish();
        // shark.eat();

        // Calculator c1 = new Calculator();
        // System.out.println(c1.sum(3 , 4));
        // System.out.println(c1.sum(3.5f , 3.5f));
        // System.out.println(c1.sum(3 , 4 , 2));

        // Horse h1 = new Horse();

        // h1.eat();
        // h1.walk();

        // Mustang m1 = new Mustang();

        // Queen q = new Queen();
        // ChessPlayer k = new King();
        // k.moves();
        // q.moves();

        // beer b1 = new beer();
        Herbivore b2 = new beer();

        // b2.eatMeat();
        b2.eatPlant();
    }   
}


// Interface for multiple inheritance

interface Herbivore {
    void eatPlant();
}

interface Carnivore {
    void eatMeat();
}

class beer implements Herbivore , Carnivore {
    public void eatPlant() {
        System.out.println("Beer is a herbivore animal");
    }

    public void eatMeat() {
        System.out.println("Beer is a carnivore animal");
    }
}

// Interface for abstraction

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up down left right Diagonal - in 4 directions");
    }
}

class Pawn implements ChessPlayer {
    public void moves() {
        System.out.println("up");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up down left right Diagonal - by 1 step");
    }
}

// abstract classes

abstract class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }

    void eat() {
        System.out.println("Animal Eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called");
    }

    void walk() {
        System.out.println("Walk on 4 legs.");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called.");
    }
}

// Method Overloading

class Calculator {
    int sum(int a , int b) {
        return a + b;
    }

    float sum (float a, float b) {
        return a + b;
    } 

    int sum(int a , int b , int c) {
        return a + b + c;
    }
}

// Inheritance 
// parent or base class
// class Animal {
//     void eat() {
//         System.out.println("Eats");
//     }

//     void sleep() {
//         System.out.println("Sleeps");
//     }
// }

//child or derived class
// class Fish extends Animal {
//     void swim() {
//         System.out.println("Swims");
//     }
// }

// Constructor 

class Student {
    String name;
    int rollNo;
    String password;
    int[] marks;

    Student() {  /// Non-Parameterized Constructor
        System.out.println("Constructor is initialized.");
        marks = new int[3];
    }

    Student (String name) { // Parameterized Constructor
        this.name = name;
        marks = new int[3];
    }

    Student (int rollNo) {
        this.rollNo = rollNo;
        marks = new int[3];
    }

    // copy constructor

    // shallow copy constructor
    // Student (Student s1) {
    //     this.name = s1.name;
    //     this.rollNo = s1.rollNo;
    //     marks = new int[3];
    //     this.marks = s1.marks;  /// passed by reference
    // }

    // deep copy constructor
    Student (Student s1) {
        this.name = s1.name;
        this.rollNo = s1.rollNo;
        marks = new int[3];
        for(int i = 0; i < 3 ; i++) {
            this.marks[i] = s1.marks[i];  /// passed by value
        }
    }
}

// getter and setter

class Pen {
    private String color;
    private int tipSize;

    String getColor() {
        return this.color;
    }

    int getTipSize() {
        return this.tipSize;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setTipSize(int tipSize) {
        this.tipSize = tipSize;
    }
}

// access Modifire

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}