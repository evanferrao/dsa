// write a code to return the first number that is repeating in the given array
// if no number is repeating then return -1
// do not use hashmaps or any other data structures

class FirstRepeatingElementInArray{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,1};
        int answer = firstRepeatingElement(arr);
        System.out.println(answer);
    }

    static int firstRepeatingElement(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }

}