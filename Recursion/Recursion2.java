public class Recursion2 {
    // Tiling
    public static int Tiles(int n) { // 2 x n = floor size
        // if(n == 0 || n == 1) {
        //     return 1;
        // }

        // Verticle Choice
        // int fnm1 = Tiles(n - 1);

        // Horizontal Choice
        // int fnm2 = Tiles(n - 2);

        // return fnm1 + fnm2;

        if(n == 0 || n ==1) return 1;
        return Tiles(n - 1) + Tiles(n - 2);
    }

    // Remove duplicates from the string
    public static void duplicates(String str , int i , StringBuffer sb , boolean map[]) {
        if(i == str.length()) {
            System.out.println(sb);
            return;
        }
        char currChar = str.charAt(i);
        if(map[currChar - 'a']) {
            duplicates(str, i + 1, sb, map);
        } else {
            map[currChar - 'a'] = true;
            duplicates(str, i + 1, sb.append(currChar), map);
        }
    }

    // Friends Paring Problem
    public static int FriendsPair(int n ) {
        if(n == 1 || n == 2) return n;
        return FriendsPair(n - 1) + ((n - 1) * FriendsPair(n - 2));
    }

    // Print Binary String Problem
    public static void BinaryString(int n , int lastPlace , StringBuilder sb) {
        if(n == 0) {
            System.out.println(sb.toString());
            return;
        }
        
        BinaryString(n - 1, 0, sb.append('0'));
            sb.deleteCharAt(sb.length() - 1);
        if(lastPlace == 0) {
            BinaryString(n - 1, 1, sb.append('1'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        // System.out.println(Tiles(5));

        // duplicates("lightningace", 0, new StringBuffer(), new boolean[26]);

        // System.out.println(FriendsPair(10));

        BinaryString(3, 0 ,new StringBuilder(""));
        
    }
}
