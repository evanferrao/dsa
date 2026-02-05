// https://leetcode.com/problems/combination-sum-ii/

import java.util.*;

class CombinationTwoAlternate {

    public static void findCombination(int currentIndex, List<Integer> ds,
                                       int[] candidates, int n, int target,
                                       List<List<Integer>> finalAnswer){

        // If target reached
        if (target == 0){
            finalAnswer.add(new ArrayList<>(ds));
            return;
        }

        // If out of bounds OR target becomes negative
        if (currentIndex == n || target < 0){
            return;
        }

        // ---------------- INCLUDE ----------------
        if (candidates[currentIndex] <= target){
            ds.add(candidates[currentIndex]);

            // Move to next index (no reuse allowed)
            findCombination(currentIndex + 1, ds, candidates, n,
                            target - candidates[currentIndex], finalAnswer);

            ds.remove(ds.size() - 1);
        }

        // ---------------- EXCLUDE ----------------
        int nextIndex = currentIndex + 1;

        // Skip duplicates
        while(nextIndex < n && candidates[nextIndex] == candidates[currentIndex]){
            nextIndex++;
        }

        findCombination(nextIndex, ds, candidates, n, target, finalAnswer);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target){

        Arrays.sort(candidates);

        List<List<Integer>> finalAnswer = new ArrayList<>();
        findCombination(0, new ArrayList<>(), candidates,
                        candidates.length, target, finalAnswer);

        return finalAnswer;
    }
}


public class Main {

    public static void main(String[] args){

        int[] candidates = {1,1,1,2,2};
        int target = 4;

        Solution sol = new Solution();

        List<List<Integer>> result = sol.combinationSum2(candidates, target);

        System.out.println("Unique Combinations:");
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }
}
