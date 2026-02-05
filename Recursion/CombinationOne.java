// https://leetcode.com/problems/combination-sum/

import java.util.*;

class CombinationOne {

    public static void findCombination(int currentIndex, List<Integer> ds, int candidates[], int n, int target, List<List<Integer>> finalAnswer){

        if (currentIndex == n){
            if(target == 0){
                finalAnswer.add(new ArrayList<>(ds));
            }
            return;
        }

        if (candidates[currentIndex] <= target){
            ds.add(candidates[currentIndex]);

            // Reuse same element
            findCombination(currentIndex, ds, candidates, n, target - candidates[currentIndex], finalAnswer);

            ds.remove(ds.size() - 1);
        }

        // Move to next index
        findCombination(currentIndex + 1, ds, candidates, n, target, finalAnswer);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int n = candidates.length;

        List<List<Integer>> finalAnswer = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombination(0, ds, candidates, n, target, finalAnswer);

        return finalAnswer;
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] candidates = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            candidates[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        Solution obj = new Solution();

        List<List<Integer>> result = obj.combinationSum(candidates, target);

        System.out.println("Possible combinations are:");
        for(List<Integer> list : result){
            System.out.println(list);
        }

        sc.close();
    }
}
