import java.util.Scanner;

public class PatternsAdvance {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of lines: ");
    int n = sc.nextInt();

    // INVERTED & ROTATED HALF-PYRAMID pattern
    // for (int i = 1; i <= n ; i++) {
    //     for(int k = 1; k <= n - i ; k++) {
    //         System.out.print(" ");
    //     }
    //     for(int j = 1 ; j <= i ; j++) {
    //         System.out.print("*");
    //     }
    //     System.out.println();
    // }

    // for(int i = 1 ; i <= n; i++) {
    //     for (int j = 1; j <= n + 1 ; j++) {
    //         System.out.print("*");
    //     }
    //     System.out.println();
    // }

    // INVERTED HALF-PYRAMID with Numbers pattern
    
    // for(int i = 1 ; i <= n; i++) {
    //     for(int k = 1 ; k <= (n + 1) - i ; k++) {
    //         System.out.print(k);
    //     }
    //     System.out.println();
    // }

    // FLOYD'S Triangle pattern

    // int count = 1;
    // for(int i = 1; i <= n ; i++) {
    //     for(int j = 1 ; j <= i; j++) {
    //         System.out.print(count + " ");
    //         count++;
    //     }
    //     System.out.println();
    // }

    // 0-1 Triangle pattern
    
    // for(int i = 1; i <= n; i++) {
    //     for(int j = 1; j <= i; j++) {
    //         if((i + j) % 2 == 0) {
    //             System.out.print(1);
    //         } else {
    //             System.out.print(0); 
    //         }
    //     }
    //     System.out.println();
    // }

    // BUTTERFLY pattern

   //  for (int i = 1 ; i <= n; i++) {
   //      for(int j = 1 ; j <= i ; j++) {
   //          System.out.print("*");
   //      }
   //      for(int k = 1; k <= 2 * (n - i); k++) {
   //          System.out.print(" ");
   //      }
   //      for(int l = 1 ; l <= i ; l++) {
   //          System.out.print("*");
   //      }
   //      System.out.println();
   //  }
   //  for (int i = n ; i >= 1; i--) {
   //      for(int j = 1 ; j <= i ; j++) {
   //          System.out.print("*");
   //      }
   //      for(int k = 1; k <= 2 * (n - i); k++) {
   //          System.out.print(" ");
   //      }
   //      for(int l = 1 ; l <= i ; l++) {
   //          System.out.print("*");
   //      }
   //      System.out.println();
   //  }

    // SOLID RHOMBUS pattern

    // for(int i = 1 ; i <= n ; i++) {
    //     for(int k = 1 ; k <= (n + 1) - i ; k++) {
    //         System.out.print(" ");
    //     }
    //     for(int j = 1; j <= n; j++) {
    //         System.out.print("*");
    //     }
    //     System.out.println();
    // }

    // DIAMOND pattern

    for(int i = 1 ; i <= n; i++) {
        for(int k = 1 ; k <= (n+1) - i ;k++) {
            System.out.print(" ");
        }
        for(int j = 1 ; j <= i ; j++) {
            System.out.print("*");
        }
        for(int l = 1 ; l <= i - 1 ; l++) {
            System.out.print("*");
        }
        System.out.println();
    }
    for(int i = n ; i >= 1; i--) {
        for(int k = 1 ; k <= (n+1) - i ;k++) {
            System.out.print(" ");
        }
        for(int j = 1 ; j <= i ; j++) {
            System.out.print("*");
        }
        for(int l = 1 ; l <= i - 1 ; l++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // NUMBER PYRAMID pattern

    // for(int i = 1 ; i <= n ; i++) {
    //     for(int k = 1 ; k <= n - i ; k++) {
    //         System.out.print(" ");
    //     }
    //     for(int j = 1 ; j <= i ; j++) {
    //         System.out.print(i);
    //         System.out.print(" ");
    //     }
    //     System.out.println();
    // }

    // PALINDROMIC Pattern with Numbers pattern

    // for(int i = 1 ; i <= n ; i++) {
    //     for(int k = 1; k <= n - i ; k++) {
    //         System.out.print(" ");
    //     }
    //     for(int j = 1 ; j <= i ; j++) {
    //         System.out.print((n - (n - i)) - (j - 1));
    //     }
    //     for(int l = 1 ; l <= i - 1; l++) {
    //         System.out.print(l + 1);
    //     }
    //     System.out.println();
    // }

    //HOLLOW RECTANGLE pattern

    // for(int i = 1 ; i <= n ; i++) {
    //     for(int j = 1 ; j <= n + 1 ; j++) {
    //         if(i == 1 || j == 1 || j == n + 1 || i == n) {
    //             System.out.print("*");
    //         } else {
    //             System.out.print(" ");
    //         }
    //     }
    //     System.out.println();
    // }

    // HOLLOW RHOMBUS pattern

    // for(int i = 1 ; i <= n ; i++) {
    //     for(int k = 1 ; k <= n - i; k++) {
    //         System.out.print(" ");
    //     }
    //     for(int j = 1 ; j <= n ; j++) {
    //         if(i == 1 || i == n || j == 1 || j == n){
    //             System.out.print("*");
    //         } else {
    //             System.out.print(" ");
    //         }
    //     }
    //     System.out.println();
    // }

    sc.close();
 }   
}
