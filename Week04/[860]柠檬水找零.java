class Solution {
    public boolean lemonadeChange(int[] bills) {
        int t5=0,t10=0,t20=0;;
        int len=bills.length;
        for(int i=0;i<len;i++){
            int t=bills[i];
            if(t==5){
                t5++;
            }else if(t==10){
                t10++;
                t5--;
            }else{
                t20++;
                if(t10>0){
                    t10--;
                    t5--;
                }else{
                    t5-=3;
                }
            }
            if(t5<0) return false;
        }
        return true;
    }
}