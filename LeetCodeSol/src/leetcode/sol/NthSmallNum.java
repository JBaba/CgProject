import old.p13;

public class NthSmallNum {

    public static void main(String[] args) {

        // my code
        for(int i=1;i<=8;i++) {
            int[] a = {10, 9, 1, 5, 2, 11, 3, 15};
            int n = nthsmallnum(a, i-1, 0, a.length - 1);
            System.out.println(n);
        }

        // leetcode
        for(int i=1;i<=8;i++) {
            int[] a = {10, 9, 1, 5, 2, 11, 3, 15};
            int n = findKthSmall2(a, i);
            System.out.println(n);
        }
    }

    // we assuming k is 0 to len
    private static int nthsmallnum(int[] a, int k, int start, int end) {

        int index = partition(a, start, end);

        if (k == index) {
            return a[index];
        } else if (k < index) {
            return nthsmallnum(a, k, start, index-1);
        } else {
            return nthsmallnum(a, k, index + 1, end);
        }

    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[start];
        int high = end;
        int low = start;

        while (high > low) { // this condition is equal to breaking loop when high == low
            while (pivot > a[low]) {
                low++;
            }
            while (pivot < a[high]) {
                high--;
            }
            if (high > low) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
//                low++; // dont need this
//                high--; // dont need this
            }
        }

//        a[start] = a[high];
//        a[high] = pivot;

        printAry(a);
        return high;
    }

    public static int findKthSmall2(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(k, nums, 0, nums.length - 1);
    }

    public  static int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);
        printAry(nums);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    private static void printAry(int[] ary) {
        for (int a : ary)
            System.out.print(a + ",");
        System.out.println();
    }

}
