package LeetCode.src.com.vnail.easy._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]+arr[j]==target)
                    return new int[]{i,j};
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] arr,int target){
        Map<Integer,Integer> map = new HashMap<>(arr.length);

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
                return new int[]{map.get(arr[i]),i};
            map.put(target-arr[i],i);
        }

        return null;

    }

    public static void main(String[] args){
        int[] arr=new int[]{2, 7, 11, 15};
        int[] ret=twoSum1(arr,9);
        System.out.println(Arrays.toString(ret));
    }

    public String multi(String n1,String n2){
        if(n1.equals("0")||n2.equals("0")) return "0";

        char[] arr1 = n1.toCharArray();
        char[] arr2 = n2.toCharArray();

        return null;


    }
}
