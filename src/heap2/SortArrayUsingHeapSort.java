package heap2;

public class SortArrayUsingHeapSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr);
        for(Integer i : arr){
            System.out.print(i+ " ");
        }
    }

    public static void sort(int[] arr){
        int N = arr.length;
        int start = N/2-1;
        for (int i = start; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            swap(arr, 0,i);
            heapify(arr, i, 0);
        }
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, N, largest);
        }
    }
}
