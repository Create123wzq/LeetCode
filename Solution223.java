package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by apple on 2019/8/25.
 */
public class Solution223 {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(A > G || E> C){
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        if(B > H || F > D){
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        int width = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        return (C-A)*(D-B) + (G-E)*(H-F) - width*height;
    }

    public static void quickSort(int[] array, int left, int right){
        if(left>=right) return;
        int p = partition(array, left, right);
        quickSort(array, left, p-1);
        quickSort(array, p+1, right);
    }

    public static int partition(int[] array, int left, int right){
        int t = array[left];
        while (left<right){
            while (left < right && array[right] >= t) right--;
            array[left] = array[right];

            while (left < right && array[left] <= t) left++;
            array[right] = array[left];
        }
        array[left] = t;
        return left;
    }
}
