import java.util.*;

class ArrayPermutationOne {

    private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> finalAnswer, boolean[] freq) {
        
        if (ds.size() == nums.length){
            finalAnswer.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermute(nums, ds, finalAnswer, freq);
                freq[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        recurPermute(nums, ds, finalAnswer, freq);
        return finalAnswer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        List<List<Integer>> result = obj.permute(nums);

        // Print permutations
        System.out.println("Permutations:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }

        sc.close();
    }
}
