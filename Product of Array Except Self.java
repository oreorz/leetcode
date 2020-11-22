class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
      
        int[] l2r = new int[nums.length];
        int[] r2l = new int[nums.length];
        l2r[0] = 1;
        r2l[nums.length - 1] = 1;
        
        for(int i = 0; i < nums.length - 1; i++){
            l2r[i+1] = l2r[i] * nums[i];
        }
        
        for(int i = nums.length - 1; i > 0; i--){
            r2l[i-1] = r2l[i] * nums[i];
        }
        
        for(int i = 0; i < nums.length; i++){
            result[i] = l2r[i] * r2l[i];
        }
        
        return result;
}
}

// l2r: [1, 1, 2, 6]
// r2l: [24, 12, 4, 1]
