package OOPs;
import java.util.Scanner;

public class OOPS2 {
    public static void main(String[] args) {
        // Vehicle v = new Car();
        // v.print1();

        // Car c = new Car();
        // c.print();

        // Vehicle v = new Vehicle();
        // v.print();
         Scanner sc = new Scanner(System.in);
        ComplexNo c1 = new ComplexNo();
        ComplexNo c2 = new ComplexNo();

        System.out.println("Enter First Complex Number: ");
        System.out.print("Real Value-> ");
        int r1 = sc.nextInt();
        System.out.print("img Value-> ");
        int i1 = sc.nextInt();
        System.out.println("Enter Second Complex Number: ");
        System.out.print("Real Value-> ");
        int r2 = sc.nextInt();
        System.out.print("img Value-> ");
        int i2 = sc.nextInt();

        c1.setReal(r1);
        c1.setImg(i1);
        c2.setReal(r2);
        c2.setImg(i2);

        c1.sum(c2);
        c1.product(c2);
    }
}

class ComplexNo {
    int real , img;

    public void setImg(int img) {
        this.img = img;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void sum(ComplexNo c1) {
        int sumReal = this.real + c1.real;
        int sumImg = this.img + c1.img;

        System.out.println("Sum: " + sumReal + " + " + sumImg + "i");
    }

    public void product(ComplexNo c1) {
        int sumReal = this.real * c1.real;
        int sumImg = this.img * c1.img;

        System.out.println("Product: " + sumReal + " + " + sumImg + "i");
    }
}

class Vehicle {
    void print() {
        System.out.println("Base Class Vehicle");
    }
}

class Car extends Vehicle {
    void print1() {
        System.out.println("Derived class Car");
    }
}
