package heap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractMinFromHeap {
    public static void main(String[] args) {
        solution();
    }
    public static void solution(){
        int[] arr = {2, 4, 5, 11, 6, 7, 8, 20, 12};
        for(Integer i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] swap = swap(arr, 0, arr.length - 1);
        for(Integer i : swap){
            System.out.print(i+" ");
        }
        System.out.println();
        ArrayList<Integer> al = new ArrayList<>();
        for(Integer i : swap){
            al.add(i);
        }
        System.out.println(al);
        al.remove(al.size()-1);
        System.out.println(al);

        int[] heap = al.stream().mapToInt(i->i).toArray();
        for(Integer i : heap){
            System.out.print(i+" ");
        }

        System.out.println("");
        int[] downHeapify = downHeapify(heap, 0);
        for(Integer i : downHeapify){
            System.out.print(i+" ");
        }

    }

    public static int[] downHeapify(int[] heap, int i){
        int n = heap.length;
        int leftChild = (2*i)+1;
        int rightChild = (2*i)+2;
        while(leftChild < n){
            System.out.println(leftChild+" ======= "+rightChild+" ======== "+(rightChild == n));
            if(rightChild == n){
                if(heap[i] > heap[leftChild]){
                    swap(heap, i, leftChild);
                }
                break;
            }
            if(heap[leftChild] < heap[i] && heap[leftChild] <= heap[rightChild]){
                swap(heap, i, leftChild);
                i = leftChild;
                leftChild = (2*i)+1;
                rightChild = (2*i)+2;
            }else if(heap[rightChild] < heap[i] && heap[rightChild] < heap[leftChild]){
                swap(heap, i, rightChild);
                i = rightChild;
                leftChild = (2*i)+1;
                rightChild = (2*i)+2;
            }else{
                break;
            }
        }
        return heap;
    }

    public static int[] swap(int[] heap, int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
        return heap;
    }
}
