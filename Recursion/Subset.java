import java.util.*;

public class Subset {

    public static void printSubset(int currentIndex, List<Integer> ds, int[] nums, int n, List<List<Integer>> finalAnswer){
        if (currentIndex == n){
            finalAnswer.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[currentIndex]);
        printSubset(currentIndex + 1, ds, nums, n, finalAnswer);

        ds.remove(ds.size() - 1);
        printSubset(currentIndex + 1, ds, nums, n, finalAnswer);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> finalAnswer = new ArrayList<>();

        printSubset(0, ds, nums, n, finalAnswer);

        return finalAnswer;
    }

    // -------- DRIVER CODE --------
    public static void main(String[] args) {

        // Assumed Input
        int[] nums = {1, 2, 3};

        Solution sol = new Solution();
        List<List<Integer>> result = sol.subsets(nums);

        System.out.println("Subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
