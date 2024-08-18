package heap2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
    public static void main(String[] args) {
        int[][] A = {{9, 11, 15},
                {10, 15, 17}};
        int B = 6;
        int ans = solve(A, B);
        System.out.println(ans);
    }
    public static int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        PriorityQueue< Integer > q = new PriorityQueue(new CustomComp1());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (q.size() < B)
                    q.offer(A[i][j]);
                else {
                    if (A[i][j] < q.peek()) {
                        q.poll();
                        q.offer(A[i][j]);
                    }
                }
            }
        }
        return q.peek();
    }
}

class CustomComp1 implements Comparator< Integer > {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}