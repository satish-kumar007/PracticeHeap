package heap1;
/*
Problem Description
Given an array A of N integers, convert that array into a min heap and return the array.
NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.

Problem Constraints
1 ≤ N ≤ 105
0 ≤ A[i] ≤ 109

Input Format
First and only argument of input contains a single integer array A of length N.

Output Format
Return the reordered array A such that it forms a min heap.

Example Input
Input:
A = [5, 13, -2, 11, 27, 31, 0, 19]

Example Output
Output:
A = [-2, 5, 0, 13, 11, 19, 27, 31]
 */
public class BuildHeapMinHeap {
    public static void main(String[] args) {
        int[] A = {5, 13, -2, 11, 27, 31, 0, 19};
        for(Integer i : A){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] buildHeap = buildHeap(A);
        System.out.println();
        for(Integer i : buildHeap){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int[] buildHeap(int[] A) {
        int n = A.length;
        int mid = n / 2 - 1;
        //System.out.println(m);
        for (int i = mid; i >= 0; i--)
            minHeapify(A, i);
        return A;
    }

    private static void minHeapify(int[] A, int i) {
        int n = A.length;
        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        System.out.println(n+" ===== "+smallest+ " ======= "+leftChild+ " ====== "
                +rightChild+" === "+(leftChild < n && A[leftChild] < A[smallest])+" ====== "
                +(rightChild < n && A[rightChild] < A[smallest])+" ==== "+(smallest != i));
        if (leftChild < n && A[leftChild] < A[smallest])
            smallest = leftChild;
        if (rightChild < n && A[rightChild] < A[smallest])
            smallest = rightChild;
        if (smallest != i) {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            minHeapify(A, smallest);
        }
    }
}
