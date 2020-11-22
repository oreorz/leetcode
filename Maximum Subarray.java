class Solution {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        if(nums.length <= 1){
            return nums[0];
        }
        
        if(nums[0] >= 0){
            sums[0] = nums[0];
        } else{
            sums[0] = 0;
        }        
        int result = sums[0];
        int largest = nums[0];
        for(int i = 1; i < nums.length; i++){
            sums[i] = sums[i - 1] + nums[i];
            if(sums[i] < 0){
                sums[i] = 0;
            }
            
            if(sums[i] > result){
                result = sums[i];
            }
            
            if(nums[i] > largest){
                largest = nums[i];
            }
        }
        if(result == 0){
            return largest;
        } else{
            return result;
        }
    }
}
