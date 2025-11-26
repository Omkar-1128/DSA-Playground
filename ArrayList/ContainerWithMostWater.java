package ArrayList;

import java.util.ArrayList;

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

public class ContainerWithMostWater {

    // Brute Force  - O(n^2)
    public static int maxArea(ArrayList<Integer> height) {
        int maxWater = 0;
        int n = height.size();
        for (int i = 0 ; i < n ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                int width = j - i;
                int minHeight = Math.min(height.get(i) , height.get(j));

                int area = width * minHeight;
                maxWater = Math.max(maxWater, area);
            }
        }

        return maxWater;
    }

    // Optimized - O(n)
    // Two Pointer Approch
    public static int maxArea2(ArrayList<Integer> height) {
        int maxWater = 0;

        int leftP = 0;
        int rightP = height.size() - 1;

        while (leftP < rightP) {

            // Calculate Area
            int width = rightP - leftP;
            int minHeight = Math.min(height.get(leftP) , height.get(rightP));

            int area = width * minHeight;

            maxWater = Math.max(area , maxWater);

            // Update Pointers
            if (height.get(leftP) < height.get(rightP)) {
                leftP++;
            } else {
                rightP--;
            }
        }

        return maxWater;
    }

public static void main(String[] args) {
    // int height[] = {1,8,6,2,5,4,8,3,7};
    // int height[] = {1 , 1};

    ArrayList<Integer> height = new ArrayList<>();

    height.add(1);
    height.add(8);
    height.add(6);
    height.add(2);
    height.add(5);
    height.add(4);
    height.add(8);
    height.add(3);
    height.add(7);

    int maxWater = maxArea2(height);
    System.out.println("Maximum Water can be: " + maxWater);
}  
}
