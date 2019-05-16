package LeetCode.src.com.vnail.easy._44;

public class Solution {
    public boolean match(String s,String p){
        char[] ps= p.toCharArray();
        char[] ss=s.toCharArray();
        int ssLen=ss.length;
        int j=0;
        for(int i=0;i<ps.length;i++){
            if(j>=ssLen){
                break;
            }
            if('?'==ps[i]){
                j++;
                continue;
            }

            if('*'==ps[i]){
                do{
                   j++;
                }while(ss[j]==ps[i+1]&&j<ssLen);
            }

            if('?'!=ps[i]&&'*'!=ps[i]){
                if(ps[i]!=ss[j]) {
                    break;
                }else {
                    j++;
                }
            }
        }
        return j<ssLen?false:true;
    }
}
