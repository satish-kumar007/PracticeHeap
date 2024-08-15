package heap2;

public class KthLargestElementMinHeap_1 {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 6, 3, 9, 7 };
        int k = 2;
        int x = findKthLargest(arr, k);
        System.out.println(x);
    }

    static int size = 0;
    public static int findKthLargest(int[] nums, int k) {
        size = nums.length;
        int ans = 0;
        int last = (size-1)/2;
        for(int i=last;i>=0;i--)
            downheapify(nums,i);
        for(int i=1;i<=k;i++)
            ans = remove(nums);
        return ans;
    }

    public static void swap(int []nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int remove(int []nums) {
        swap(nums,0,size - 1);
        int temp = nums[size - 1];
        size--;
        downheapify(nums,0);
        return temp;
    }

    public static void downheapify(int []nums,int pi) {

        int mini = pi;
        int li = 2 * pi + 1;
        int ri = 2 * pi + 2;

        if (li < size && nums[li] > nums[mini])
            mini = li;

        if (ri < size && nums[ri] > nums[mini])
            mini = ri;

        if (mini != pi) {
            swap(nums,mini, pi);
            downheapify(nums,mini);
        }
    }
}
