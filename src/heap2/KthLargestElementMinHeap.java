package heap2;

import java.util.PriorityQueue;

public class KthLargestElementMinHeap {
    public static int KthLargestElement(int arr[], int k) {
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(); // creating min-heap
        int i;
        for (i = 0; i < n; i++) {
            q.add(arr[i]); // push every element into the heap
            if (q.size() > k)
                q.remove(q.peek()); // if the size of the heap becomes greater than k, pop the element
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 6, 3, 9, 7 };
        int k = 2;
        int x = KthLargestElement(arr, k);
        System.out.print("Kth largest element is " + x);
    }
}
