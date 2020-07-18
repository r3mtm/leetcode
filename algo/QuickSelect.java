public class QuickSelect {
    public static void main(String[] args) {
        int[] nums = {8,14,82,50,11,3,6,90,1};
        int k = 6;
        new Solution().select(nums, 0, nums.length - 1, k);
        System.out.println(nums[k - 1]);
    }
}

class Solution {

    public void select(int[] nums, int start, int end, int k) {

        if (start == end) return;

        int pivotIndex = partition(nums, start, end);
        if (pivotIndex == k) {
            return;
        } else if (pivotIndex < k) {
            select(nums, pivotIndex + 1, end, k);
        } else {
            select(nums, start, pivotIndex - 1, k);
        }
    }


    // Lomuto Partitioning
    private int partition(int[] nums, int start, int end) {
        int pivot = end;
        int i = start, j = start;
        while (j < pivot) {
            if (nums[j] < nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
            }
            ++j;
        }
        int temp = nums[i];
        nums[i] = nums[pivot];
        nums[pivot] = temp;
        return i;
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}