package heap1;
/*
Problem Description
Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.



NOTE: You can perform the modification on the same element multiple times.



Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100



Input Format
The first argument given is an integer array A.
The second argument given is an integer B.



Output Format
Return an integer denoting the maximum array sum after B modifications.



Example Input
Input 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output
Output 1:

 196
Output 2:

 362


Example Explanation
Explanation 1:


Operation 1: Make -29 to 29,
Operation 2: Make -9 to 9,
Operation 3: Make 9 to -9,
Operation 4: Make -68 to 68.
Thus, the final array after 4 modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 */
import java.util.PriorityQueue;

public class MaximumArraySumBNegations {
    public static void main(String[] args) {
        int[] A = {57, 3, -14, -87, 42, 38, 31, -7, -28, -61};
        int B = 10;
        int ans = solve(A,B);
        System.out.println(ans);
    }
    public static int solve(int[] A, int B) {
        PriorityQueue< Integer > pq = new PriorityQueue();
        // insert all elements into the queue
        for (int x: A) pq.offer(x);
        // perform B modifications
        while (B > 0) {
            // pop minimum lement from the queue
            int x = pq.poll();
            // if minimum element is 0, we will use all remaining opeations on this and the result will be same
            if (x == 0) {
                B = 0;
            }
            // if minimum element is negative, modify the element to -x and push -x to queue.
            else if (x < 0) {
                pq.offer(-x);
            } else {
                //if remaining operations are even, then in one operation we convert x to -x and in another -x to x. So, no change
                //if operations are odd, we will change the number to -x. Set B = 0.
                if (B % 2 == 0) {
                    pq.offer(x);
                } else {
                    pq.offer(-x);
                }
                B = 0;
                break;
            }
            B--;
        }
        int ans = 0;
        // add all the elements in the queue to the answer
        while (pq.size() > 0) {
            ans += pq.poll();
        }
        return ans;
    }
}
