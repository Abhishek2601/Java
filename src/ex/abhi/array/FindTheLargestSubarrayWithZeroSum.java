package ex.abhi.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhishekshukla on 1/23/17.
 */
public class FindTheLargestSubarrayWithZeroSum {

    public static int maxLen(int a[]){
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int sum = 0, max_len = 0;
        for(int i=0; i<a.length; i++){

            sum += a[i];
            if(a[i] == 0 && max_len == 0){
                max_len = i+1;
            }

            Integer prev_i = hm.get(sum);
            if(prev_i != null){
                max_len = Math.max(max_len,i-prev_i);
            }
            else{
                hm.put(sum,i);
            }
        }
        System.out.print("Element of Map :");

        return max_len;
    }

    public static void main(String [] args){
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is "
                + maxLen(arr));

    }
}
