// https://leetcode.com/problems/combination-sum-ii/
import java.util.*;

class CombinationTwo {

    public static void findCombination(int currentIndex, List<Integer> ds, int candidates[], int target, List<List<Integer>> finalAnswer){
        
        if (target == 0){
            finalAnswer.add(new ArrayList<>(ds));
            return;
        }

        for (int i = currentIndex; i < candidates.length; i++){

            if (i > currentIndex && candidates[i] == candidates[i-1]) continue;

            if (candidates[i] > target) break;

            ds.add(candidates[i]);

            findCombination(i + 1, ds, candidates, target - candidates[i], finalAnswer);

            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> finalAnswer = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombination(0, ds, candidates, target, finalAnswer);

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

        List<List<Integer>> result = obj.combinationSum2(candidates, target);

        System.out.println("Unique combinations are:");
        for(List<Integer> list : result){
            System.out.println(list);
        }

        sc.close();
    }
}
