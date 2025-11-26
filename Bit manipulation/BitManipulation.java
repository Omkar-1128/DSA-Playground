import java.util.*;

public class BitManipulation {

    public static void evenOddNumber(int n) {
        if((n & 1) == 0) {
            System.out.println("Given Number is even number.");
        } else {
            System.out.println("Given number is odd number");
        }
    }

    public static void GetithBit(int n , int i) {
        int bitMask = 1 << i;
        if((n & bitMask) == 0) {
            System.out.println("bit: " + 0);
        } else {
            System.out.println("bit: " + 1);
        }
    }

    public static void SetithBit(int n , int i) {
        int bitMask = 1 << i;
        System.out.println(n | bitMask);
    }

    public static int ClearIthBit(int n , int i) {
        int bitMask = ~(1 << i);
        // System.out.println(n & bitMask);
        return n & bitMask;
    }

    public static void updateIthBit(int n , int i , int newBit) {
        // int bitMask = 1 << i;
        // if(newBit == 0) {
        //     System.out.println(n & (~bitMask));
        // } else {
        //     System.out.println(n | bitMask);
        // }

        n = ClearIthBit(n, i);
        int bitMask = newBit << i;
        System.out.println(n | bitMask);
    }

    public static void ClearLastIBits(int n , int i) {
        int bitMask = ((~0) << i);

        System.out.println(n & bitMask);
    }

    public static void ClearRangeOfBits(int n , int i , int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;

        System.out.println(n & bitMask);
    }

    public static boolean PowerOfTwo(int n) {
        return ((n & (n - 1)) == 0);
    }

    // count set bits 

    public static void CountSetBits(int n) {
        int count = 0;
        while (n != 0) {
            int lsb = n & 1;
            if(lsb == 1) {
                count++;
            }

            n = n>>1;
        }

        System.out.println("Count of set bits: " + count);
    }

    // fast exponential

    public static void fastExpo(int a , int n) {
        int ans = 1;

        while (n > 0) {
            if((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;

            n = n>>1;
        }

        System.out.println("Answer: " + ans);
    }
    
    // add 1 to an integer using bit

    public static int addone(int n) {
        return -(~n);
    }

    public static char uppertolowerCase(char ch) {
        int bitMask = 3 << 5;
        return (char)(ch | bitMask);
    }
    public static void main(String[] args) {
        // System.out.println(5 & 6);
        // System.out.println(5 | 6);
        // System.out.println(5 ^ 6);
        // System.out.println(~5);
        // System.out.println(~0);
        // System.out.println(5<<2); // binary left shift (shortcut: if a << b then c = a * 2^b)  // 5 * 2^2 = 20;
        // System.out.println(6 >> 1); // binary right shift (if a >> b then c = a / 2^b)

        // evenOddNumber(4);
        // GetithBit(10, 2);
        // GetithBit(5, 2);

        // SetithBit(10, 2);
        // ClearIthBit(10, 1);
        // updateIthBit(10, 1 , 0);

        // ClearLastIBits(15, 1);

        // ClearRangeOfBits(1257, 2, 7);

        // System.out.println(PowerOfTwo(16));

        // CountSetBits(7);

        // fastExpo(3, 5);

        // System.out.println(addone(5));

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Capital Letter: ");
        // char ch = (char) sc.next().charAt(0);
        // System.out.println("Small Letter: " + uppertolowerCase(ch));

        for(char i = 'A' ; i <= 'Z' ; i++) {
            System.out.print(uppertolowerCase(i) + " ");
        }
    }
}
