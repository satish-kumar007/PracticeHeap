package heap1;

public class InsertionInMinHeap {
    public static void main(String[] args) {
        int[] arr = {2,12,20,25,13,24,22,35,10};
        int[] upHeapify = upHeapify(arr, 8);
        for(Integer up : upHeapify){
            System.out.print(up+" ");
        }
    }

    public static int[] upHeapify(int[] heap, int index){
        int parentNodeIndex = (index -1)/2;
        System.out.println(index+" value : "+heap[index]+ " ============ "+parentNodeIndex+"  value : "+heap[parentNodeIndex]);
        while(index != 1 && heap[parentNodeIndex] > heap[index]){
            int temp = heap[index];
            heap[index] = heap[parentNodeIndex];
            heap[parentNodeIndex] = temp;
            //System.out.println(index+" value : "+heap[index]+ " ============ "+parentNodeIndex+"  value : "+heap[parentNodeIndex]);

            //Now, after swapping -> make current index as parent
            index = parentNodeIndex;
            //repeat find the parent
            parentNodeIndex = (index-1)/2;
            System.out.println(index+" value : "+heap[index]+ " ============ "+parentNodeIndex+"  value : "+heap[parentNodeIndex]);

        }
        return heap;
    }
}
