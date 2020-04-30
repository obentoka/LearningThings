public class MaxSubArray {

    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }

    public static int maxSubArray(int[] nums) {
        int lsum = 0;
        for(int i = 0; i < nums.length; i++){
            int currSum = nums[i];
            for(int j = i+1; j < nums.length; j++){
                currSum += nums[j];
                if(currSum > lsum){
                    lsum = currSum;
                }else
                    break;
            }
        }
        return lsum;
    }
}
