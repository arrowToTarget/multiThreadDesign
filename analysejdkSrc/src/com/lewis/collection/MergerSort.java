package com.lewis.collection;


import java.util.Arrays;

/**
 * Created by zhangminghua on 2016/5/3.
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] array = Utils.generateArray(10000,100000);
        System.out.println("before sort array = "+Arrays.toString(array));
        long beginTime = System.currentTimeMillis();
        mergerSort(array,1,array.length);
        System.out.println("costTime time#"+(System.currentTimeMillis()-beginTime));
        System.out.println("after sort Array = "+Arrays.toString(array));
    }



    /**
     * 将数组array中从startIndex到middleIndex的部分 和  从middleIndex+1到endIndex部分  合并
     * array[startIndex]到array[middleIndex]之间的部分有有序数组
     * array[middleIndex+1]到array[endIndex]之间的部分为有序数组
     */
    private static void merger(int[] array,int startIndex,int middleIndex,int endIndex){
        int leftArrayLength =  middleIndex -startIndex +1;
        int rightArrayLength = endIndex - middleIndex;
        int[] leftArray = new int[leftArrayLength+1];
        int[] rightArray = new int[rightArrayLength+1];
        for (int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = array[startIndex+i-1];
        }
        leftArray[leftArray.length-1] = Integer.MAX_VALUE;
        for (int i = 0; i < rightArrayLength; i++) {
            rightArray[i] = array[middleIndex+i];
        }
        rightArray[rightArray.length-1] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = startIndex-1; k < endIndex; k++) {
            if (leftArray[i] > rightArray[j]) {
                array[k] = rightArray[j];
                j++;
            }else {
                array[k] = leftArray[i];
                i++;
            }
        }
    }

    public static void mergerSort(int[] array, int startIndex,int endIndex){
        if (startIndex < endIndex) {
            int middleIndex = (startIndex+endIndex)/2;
            mergerSort(array,startIndex,middleIndex);
            mergerSort(array,middleIndex+1,endIndex);
            merger(array,startIndex,middleIndex,endIndex);
        }
    }
}
