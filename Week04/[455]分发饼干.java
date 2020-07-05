class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int glen=g.length;
        int slen=s.length;
        if(glen==0||slen==0) return 0;
        int cnt=0,currentS=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0;i<glen;i++){
            if(currentS>=slen)break;
            for(int j=currentS;j<slen;j++){
                if(s[j]>=g[i]){
                    cnt++;
                    currentS=j+1;
                    break;
                }
            }
        }
        return cnt;

    }
}