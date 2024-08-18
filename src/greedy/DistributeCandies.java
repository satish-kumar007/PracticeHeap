package greedy;

import java.util.Arrays;

/*
Problem Description
N children are standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109



Input Format
The first and only argument is an integer array A representing the rating of children.



Output Format
Return an integer representing the minimum candies to be given.



Example Input
Input 1:

 A = [1, 2]
Input 2:

 A = [1, 5, 2, 1]


Example Output
Output 1:

 3
Output 2:

 7


Example Explanation
Explanation 1:

 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:

 Candies given = [1, 3, 2, 1]
 */
public class DistributeCandies {
    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1};
        int ans = numOfCandies(A);
        System.out.println(ans);
    }
    public static int numOfCandies(int[] arr){
        int n = arr.length;
        System.out.println(n);
        int[] candies = new int[n+1];
        System.out.println(candies.length);
        Arrays.fill(candies, 1);
        for(Integer i:candies){
            System.out.print(i+" ");
        }
        for(int i=2;i<=n;i++){
            if(arr[i-1] > arr[i-2]){
                candies[i] = candies[i-1]+1;
            }
        }
        System.out.println();
        for(Integer i:candies){
            System.out.print(i+" ");
        }
        for(int i = n-1;i>=1;i--){
            if(arr[i-1] > arr[i]){
                candies[i] = Math.max(candies[i], candies[i-1]+1);
            }
        }
        System.out.println();
        for(Integer i:candies){
            System.out.print(i+" ");
        }

        int minCandies = 0;
        System.out.println();
        for(int i=1;i<=n;i++){
            //System.out.print(candies[i]+" ");
            minCandies += candies[i];
        }
        System.out.println(minCandies);
        return minCandies;
    }
}
