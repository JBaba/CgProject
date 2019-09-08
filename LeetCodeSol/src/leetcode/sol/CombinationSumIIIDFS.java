/**

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

    All numbers will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
 * Memory Usage: 33.4 MB, less than 8.00% of Java online submissions for Combination Sum III.
 * <p>
 * O(C(9,k))-> O(9^k), space: k
 */
class CombinationSumIIIDFS {

    public List<List<Integer>> combinationSum3(int k, int n) {

        /**
         * You can't make sum n=2 when k=3. to run at least n>=k
         * and using [1,9] you can't make sum more than 45.
         * K can not be more than 9 since we have 9 choices only
         */
        if (n < k || n > 45 || k > 9)
            return Collections.EMPTY_LIST;


        List<List<Integer>> response = new ArrayList<>();
        int candidates[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinationSum3(candidates, k, 0, 0, n, response, new ArrayList<>());
        return response;
    }

    private void combinationSum3(int[] candidates, int k, int i, int currentSum, int target, List<List<Integer>> response, List<Integer> temp) {

        //3. Our goal: when currentSum = target & k numbers only
        if (temp.size() == k) {

            if (currentSum == target)
                response.add(new ArrayList<>(temp));


            return;
        }

        if (i == candidates.length)
            return;


        //1. Our choices: We can choose a number from the list any number of times and all the numbers
        for (int s = i; s < candidates.length; s++) {

            //if this element is greater than target, then adding it to current sum make bigger than target
            //since,elements are sorted, then all the element after this element are > target
            if (candidates[s] > target)
                break;

            //Our constraints : We can't go beyond target, we can take more element than available in array
            if (currentSum + candidates[s] <= target) {
                currentSum += candidates[s];
                temp.add(candidates[s]);

                combinationSum3(candidates, k, s + 1, currentSum, target, response, temp);

                //backtrack
                temp.remove(temp.size() - 1);
                currentSum -= candidates[s];
            }
        }

    }
}
