import java.util.*;

// 84. Largest Rectangle in Histogram

// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

public class LargestRectangleHistogram {

    public static void maxArea(int heights[]) {
        Stack<Integer> s = new Stack<>();
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];
        int maxArea = 0;

        // next smaller right
        for (int i = heights.length - 1 ; i >= 0 ; i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        s = new Stack<>();

        // next smaller left

        for (int i = 0 ; i < heights.length ; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        // calculate area; width = j - i - 1
        for (int i = 0 ; i < heights.length ; i++) {
            // area = heights[i]  * width
            int width = nsr[i] - nsl[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        System.out.println("Maximum Area of Histogram: " + maxArea);
    }
    public static void main(String[] args) {
        // int heights[] = {2,1,5,6,2,3};
        int heights[] = {2 , 4};

        maxArea(heights);
    }
}