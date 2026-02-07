package Backtracking;
import java.util.*;

public class StringPartition {

    private static List<List<String>> ans;

    public static void findPartitions(String s , List<String> temp , int index) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Patition
        for(int i = index ; i < s.length() ; i++) {
            temp.add(s.substring(index, i + 1));

            findPartitions(s, temp, index + 1);

            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        ans = new ArrayList<>();

        String s = "aab";
        // Partitions :- [[a , a , b], [aa , b] , [a , ab] , [aab]]
        findPartitions(s, new ArrayList<>() , 0);

        System.out.println(ans);
    }
}
