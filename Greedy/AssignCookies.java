import java.util.*;

class Solution {
    public int findContentChildren(int[] greedyChildren, int[] cookieSize) {
        Arrays.sort(greedyChildren);
        Arrays.sort(cookieSize);

        int child = 0, cookie = 0, contentChildren = 0;

        while (child < greedyChildren.length && cookie < cookieSize.length) {
            if (cookieSize[cookie] >= greedyChildren[child]) {
                contentChildren++;
                child++;
                cookie++;
            } else {
                cookie++;
            }
        }
        return contentChildren;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Case 1: Basic case
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.printf("Case 1 (Basic): %d%n",
                sol.findContentChildren(g1, s1));

        // Case 2: Enough cookies
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.printf("Case 2 (Enough cookies): %d%n",
                sol.findContentChildren(g2, s2));

        // Case 3: No cookies
        int[] g3 = {1, 2, 3};
        int[] s3 = {};
        System.out.printf("Case 3 (No cookies): %d%n",
                sol.findContentChildren(g3, s3));

        // Case 4: Cookies too small
        int[] g4 = {2, 3, 4};
        int[] s4 = {1, 1, 1};
        System.out.printf("Case 4 (Cookies too small): %d%n",
                sol.findContentChildren(g4, s4));

        // Case 5: Unsorted input
        int[] g5 = {4, 1, 2};
        int[] s5 = {2, 1, 3};
        System.out.printf("Case 5 (Unsorted input): %d%n",
                sol.findContentChildren(g5, s5));

        // Case 6: No children
        int[] g6 = {};
        int[] s6 = {1, 2, 3};
        System.out.printf("Case 6 (No children): %d%n",
                sol.findContentChildren(g6, s6));
    }
}
