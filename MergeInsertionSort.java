import java.util.Random;
import java.util.Arrays;
 
public class MergeInsertionSort {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int sum = 0;
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            if (i % 2 == 0) {
                arr[i] = random.nextInt(900000) + 100000;
            } else {
                arr[i] = (random.nextInt(900000) + 100000) * -1;
            }
        }
        long startTime = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, 32);
        long finishTime = System.currentTimeMillis();
        sum = (int) (sum + (finishTime - startTime));
        System.out.print(Arrays.toString(arr));
    }
 
    public static void mergeSort(int[] arr, int p, int r, int n) {
        int q;
        if (r - p <= n) {
            insertionSort(arr, p, r);
        } else {
            q = (int) Math.floor((p + r) / 2);
            mergeSort(arr, p, q, n);
            mergeSort(arr, q + 1, r, n);
            merge(arr, p, q, r);
        }
    }
 
    public static void merge(int[] arr, int p, int q, int r) {
        int i, j, k;
        int x = q - p + 1;
        int y = r - q;
        int[] leftArray = new int[x];
        int[] rightArray = new int[y];
 
        for (i = 0; i < x; i++) {
            leftArray[i] = arr[p + i];
        }
        for (j = 0; j < y; j++) {
            rightArray[j] = arr[q + 1 + j];
        }
 
        i = 0;//left subarray index start
        j = 0;//right subarray index start
        k = p;//resulting array, or the original array
        while ((i < x) && (j < y)) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
 
        while (i < x) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
 
        while (j < y) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
 
    public static void insertionSort(int[] arr, int left, int right) {
        left++;
        int key;
        int i;
        int beginning = left;
        for (; left <= right; left++) {
            key = arr[left];
            i = left - 1;
            while ((i >= beginning - 1) && (arr[i] > key)) {
                arr[i+1] = arr[i];
                i = i - 1;
            }
            arr[i+1] = key;
        }
    }
}