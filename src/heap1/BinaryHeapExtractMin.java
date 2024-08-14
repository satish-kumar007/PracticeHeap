package heap1;


import java.util.PriorityQueue;

public class BinaryHeapExtractMin {
    static int capacity; /*Maximum elements that can be stored in heap*/
    static int size; /*Current no of elements in heap*/
    static int arr[]; /*array for storing the keys*/

    BinaryHeapExtractMin(int cap) {
        capacity = cap; /*Assigning the capacity*/
        size = 0; /*Intailly size of hepa is zero*/
        arr = new int[capacity]; /*Creating a array*/
    }

    /*returns the parent of ith Node*/
    static int parent(int i) {
        return (i - 1) / 2;
    }
    /*returns the left child of ith Node*/
    static int left(int i) {
        return 2 * i + 1;
    }
    /*Returns the right child of the ith Node*/
    static int right(int i) {
        return 2 * i + 2;
    }

    /*Insert a new key x*/
    static void Insert(int x) {
        if (size == capacity) {
            System.out.println("Binary Heap Overflown");
            return;
        }
        arr[size] = x; /*Insert new element at end*/
        int k = size; /*store the index ,for checking heap property*/
        size++; /*Increase the size*/

        /*Fix the min heap property*/
        while (k != 0 && arr[parent(k)] > arr[k]) {
            int temp = arr[parent(k)];
            arr[parent(k)] = arr[k];
            arr[k] = temp;
            k = parent(k);
        }
    }

    static void Heapify(int ind) {
        int ri = right(ind); /*right child*/
        int li = left(ind); /*left child*/
        int smallest = ind; /*intially assume violated value in Min value*/
        if (li < size && arr[li] < arr[smallest])
            smallest = li;
        if (ri < size && arr[ri] < arr[smallest])
            smallest = ri;
        /*smallest will store the minvalue index*/
    /*If the Minimum among the three nodes is the parent itself,
    that is Heap property satisfied so stop else call function recursively on Minvalue node*/
        if (smallest != ind) {
            int temp = arr[ind];
            arr[ind] = arr[smallest];
            arr[smallest] = temp;
            Heapify(smallest);
        }
    }


    static int getMin() {
        return arr[0];
    }


    static int ExtractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return arr[0];
        }
        int mini = arr[0];
        arr[0] = arr[size - 1]; /*Copy last Node value to root Node value*/
        size--;
        Heapify(0); /*Call heapify on root node*/
        return mini;
    }

    public static void main(String args[]){
        /*PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(4);
        pq.offer(1);
        pq.offer(2);
        pq.offer(6);
        pq.offer(7);
        pq.offer(3);
        pq.offer(8);
        pq.offer(5);*/

        BinaryHeapExtractMin pq = new BinaryHeapExtractMin(20);
        pq.Insert(4);
        pq.Insert(1);
        pq.Insert(2);
        pq.Insert(6);
        pq.Insert(7);
        pq.Insert(3);
        pq.Insert(8);
        pq.Insert(5);

        System.out.println(pq);
        System.out.println("Min value is " + pq.getMin());
        pq.Insert(-1);
        System.out.println(pq);
        System.out.println("Min value is " + pq.getMin());
        ExtractMin();
        System.out.println(pq);
        System.out.println("Min value is " + pq.getMin());
    }
}