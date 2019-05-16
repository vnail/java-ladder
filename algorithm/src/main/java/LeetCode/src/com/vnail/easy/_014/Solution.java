package LeetCode.src.com.vnail.easy._014;

public class Solution {
    public static String findCommonPrefix(String[] strs){
        if(strs==null||strs.length<2)
            return "";

        int minLen=0;
        for(String str:strs) minLen=Math.min(minLen,str.length());

        for(int i=1;i<strs.length;i++){
            for(int j=0;j<minLen;j++){
                if(strs[0].charAt(j)!=strs[i].charAt(j))
                    return strs[0].substring(0,j);
            }

        }

        return strs[0].substring(0,minLen);
    }
}
