package heap2;

public class BuildMaxHeap {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        upHeapify(arr);
        System.out.println();
        buildHeapSiftdown(arr);
    }
    public static void upHeapify(int[] arr){
        for(int i=1;i<arr.length;i++){
            shiftUp(arr, i);
        }
        for(Integer i : arr){
            System.out.print(i+" ");
        }
    }

    public static void shiftUp(int[] arr, int index){
        if(index < 1)
            return;
        int parentIndex = (index-1)/2;
        if(arr[parentIndex] < arr[index]){
            swap(arr, parentIndex, index);
            shiftUp(arr, parentIndex);
        }
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void buildHeapSiftdown(int[] arr) {
        for (int i = (int) Math.floor(arr.length/2); i >= 0; i--) {
            siftdown(arr, i);
        }
        for(Integer i : arr){
            System.out.print(i+" ");
        }
    }

    public static void siftdown(int[] arr, int level) {
        if (arr.length <= 1) {
            return;
        }

        int leftIdx = 2*level + 1;
        int rightIdx = 2*level + 2;
        int largest = level;

        // See if the left child is larger
        if (leftIdx < arr.length && arr[leftIdx] > arr[largest]) {
            largest = leftIdx;
        }

        // See if the right child is larger
        if (rightIdx < arr.length && arr[rightIdx] > arr[largest]) {
            largest = rightIdx;
        }

        if (largest != level) {
            // There's a child that's larger; switch with the largest child, and
            // see if we're smaller than its children
            swap(arr, largest, level);
            siftdown(arr, largest);
        }
    }

}
