class Solution {
    public int shipWithinDays(int[] weight, int days) {
        int start =0;
        int end =0;
        for(int i =0;i<weight.length;i++){
            start= Math.max(start,weight[i]);
            end+=weight[i];
        }
        
       
        while(start<end){
            int mid = start + (end -start)/2;
             int pices =1;
             int sum =0;
            for(int nums :weight){
                if(sum+nums>mid){
                    sum=nums;
                    pices++;
                }
                else{
                    sum+=nums;
                }
            }
            if(pices > days){
                start=mid+1;
            }
            else
                end=mid;
        }
        return end ;
    }
    
}
