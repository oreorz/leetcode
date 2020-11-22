class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        
        int[] l2r = new int[nums.length];
        int[] r2l = new int[nums.length];
        
        l2r[0] =  nums[0];
        
        int resultl2r = l2r[0];
        int largest = nums[0];
        
        //left to right
        for(int i = 1; i < nums.length; i++){
            if(l2r[i-1] == 0){
                l2r[i] = nums[i];
            } else{
                  l2r[i] = l2r[i-1] * nums[i];
            }
            if(l2r[i] > resultl2r){
                resultl2r = l2r[i];
            }
            if(largest < nums[i]){
                largest = nums[i];
            }
        }
        
        r2l[nums.length -1] = nums[nums.length -1];
        int resultr2l = nums[nums.length - 1];
        //right to left
         for(int i = nums.length - 2; i > -1; i--){
            if(r2l[i+1] == 0){
                r2l[i] = nums[i];
            } else{
                  r2l[i] = r2l[i+1] * nums[i];
            }
            if(r2l[i] > resultr2l){
                resultr2l = r2l[i];
                System.out.println(resultr2l);
            }
        }
        int result = Math.max(resultl2r, resultr2l);
        result = Math.max(result, largest);
        return result;
    }
}
