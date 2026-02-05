import java.util.*;

class ArrayPermutationTwo {

    public void recurPermute(int index, int nums[], List<List<Integer>> finalAnswer){
        if (index == nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            finalAnswer.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i=index; i<nums.length; i++){
            swap(index, i, nums);
            recurPermute(index+1, nums, finalAnswer);
            swap(index, i, nums);
        }
    }
    
    public void swap(int x, int y, int nums[]){
        int temp = nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        recurPermute(0, nums, finalAnswer);
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

        // Input elements
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
