// https://leetcode.com/problems/subsets-ii/submissions/1909073945/

import java.util.*;

class SubsetTwo {

    public void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) continue;
            // or i != ind would also work

            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }
}

public class Main {
    public static void main(String[] args) {

        // Assumed Input
        int[] nums = {1, 2, 2};

        Solution sol = new Solution();
        List<List<Integer>> result = sol.subsetsWithDup(nums);

        System.out.println("Subsets Without Duplicates:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
