// write a code in java to print the pascals triangle for a given number of rows using a function
import java.util.Scanner;

class PascalsTriangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Pascal's Triangle: ");
        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<=i; j++){
        //         System.out.print(pascal(i, j) + " ");
        //     }
        //     System.out.println();
        // }
        //printPascalsTriangle(rows);
        // int[][] memo = new int[rows][rows];
        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<=i; j++){
        //         System.out.print(pascalMemo(i, j, memo) + " ");
        //     }
        //     System.out.println();
        // }
        pascalDPSpaceOptimized(rows);
        sc.close();     
    }

    public static void printPascalsTriangle(int rows){
        for(int i=0; i<rows; i++){
            int number = 1;
            for(int j=0; j<=i; j++){
                System.out.print(number + " ");
                // proof using the formula nCr = n! / (r! * (n-r)!) [binomial coefficient]
                number = number * (i-j) / (j+1);
            }
            System.out.println();
        }
    }

    // write another function to print pasclas triangle using recursion
    public static int pascal(int i, int j){
        if(j == 0 || j == i){
            return 1;
        }
        return pascal(i-1, j-1) + pascal(i-1, j);
    }

    // write another function to print pascals triangle using memoization
    public static int pascalMemo(int i, int j, int[][] memo){
        if(j == 0 || j == i){
            return 1;
        }
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        memo[i][j] = pascalMemo(i-1, j-1, memo) + pascalMemo(i-1, j, memo);
        return memo[i][j];
    }

    // write another function to print pascals triangle using dynamic programming
    public static void pascalDP(int rows){
        int[][] dp = new int[rows][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    // write another function to print pascals triangle using dynamic programming with space optimization
    public static void pascalDPSpaceOptimized(int rows){
        int[] dp = new int[rows];
        for(int i=0; i<rows; i++){
            for(int j=i; j>=0; j--){
                if(j == 0 || j == i){
                    dp[j] = 1;
                }else{
                    dp[j] = dp[j-1] + dp[j];
                }
            }

            // does not save the entire triangle, only the current row
            // its indented in the loop to print the triangle
            for(int j=0; j<=i; j++){
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
    }
}