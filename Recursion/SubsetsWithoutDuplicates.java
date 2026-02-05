import java.util.*;

class SubsetsWithoutDuplicates {

    public static void printSubset(int currentIndex, List<Integer> ds, int[] nums, int n, List<List<Integer>> finalAnswer){
        if (currentIndex == n){
            finalAnswer.add(new ArrayList<>(ds));
            return;
        }
         
        // Include
        ds.add(nums[currentIndex]);
        printSubset(currentIndex + 1, ds, nums, n, finalAnswer);
        ds.remove(ds.size() - 1);

        // Exclude
        int nextIndex = currentIndex + 1;
        while (nextIndex < n && nums[nextIndex] == nums[currentIndex]){
            nextIndex++;
        }
        printSubset(nextIndex, ds, nums, n, finalAnswer);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        List<Integer> ds = new ArrayList<Integer>();
        List<List<Integer>> finalAnswer = new ArrayList<>();
        printSubset(0, ds, nums, n, finalAnswer);
        return finalAnswer;
    }
}


public class Main {
    public static void main(String[] args) {

        // Assumed Test Input
        int[] nums = {1, 2, 2};

        Solution sol = new Solution();
        List<List<Integer>> result = sol.subsetsWithDup(nums);

        System.out.println("Subsets Without Duplicates:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
