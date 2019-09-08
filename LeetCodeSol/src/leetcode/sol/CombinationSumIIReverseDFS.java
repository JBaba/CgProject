/**

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

 * {@link CombinationSumIReverseDFS}
 * * The only thing we need to add, is to avoid duplicate combination now. To avoid duplicate,
 * * we can sort the array and avoid taking same element as first element for the solution.
 * * Example: [1,1,7]; once we take the first 1 {0'th index} and found 7 as our solution [1,7] . Then we should not take second 1 {1'st index} as our first element
 * *
 * <p>
 * Runtime: 2 ms, faster than 99.96% of Java online submissions for Combination Sum II.
 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Combination Sum II.
 */

class CombinationSumIIReverseDFS {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0)
            return Collections.EMPTY_LIST;

        List<List<Integer>> response = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum2(candidates, 0, target, response, new ArrayList<>());
        return response;
    }

    private void combinationSum2(int[] candidates, int i, int target, List<List<Integer>> response, List<Integer> temp) {

        //3. Our goal: when currentSum = target
        if (0 == target) {
            response.add(new ArrayList<>(temp));
            return;
        }

        if (i == candidates.length)
            return;

        //1. Our choices: We can choose a number from the list any number of times and all the numbers
        for (int s = i; s < candidates.length; s++) {

            //if this element is greater than target, then subtracting it  make target negetive
            //since,elements are sorted, then all the element after this element are > target
            if (candidates[s] > target)
                break;

            //Avoid duplicates [1,1,7]; once we take the first 1 and found 7 as our solution [1,7] . Then we should not take second 1 as our first element
            //and try to find a solution.
            if (s > i && candidates[s] == candidates[s - 1])
                continue;

            //Our constraints : We can't go beyond target, we can take more element than available in array
            if (target - candidates[s] >= 0) {
                target -= candidates[s];
                temp.add(candidates[s]);

                combinationSum2(candidates, s + 1, target, response, temp);

                //backtrack
                temp.remove(temp.size() - 1);
                target += candidates[s];
            }
        }

    }

}

/**
 * {@link CombinationSumIDFS}
 * The only thing we need to add, is to avoid duplicate combination now. To avoid duplicate,
 * we can sort the array and avoid taking same element as first element for the solution.
 * Example: [1,1,7]; once we take the first 1 {0'th index} and found 7 as our solution [1,7] . Then we should not take second 1 {1'st index} as our first element
 * <p>
 * Runtime: 3 ms, faster than 81.29% of Java online submissions for Combination Sum II.
 * Memory Usage: 38.7 MB, less than 77.90% of Java online submissions for Combination Sum II.
 */
class CombinationSumIIDFS {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0)
            return Collections.EMPTY_LIST;

        List<List<Integer>> response = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum2(candidates, 0, 0, target, response, new ArrayList<>());
        return response;
    }

    private void combinationSum2(int[] candidates, int i, int currentSum, int target, List<List<Integer>> response, List<Integer> temp) {

        //3. Our goal: when currentSum = target
        if (currentSum == target) {
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

            //Avoid duplicates [1,1,7]; once we take the first 1 and found 7 as our solution [1,7] . Then we should not take second 1 as our first element
            //and try to find a solution.
            if (s > i && candidates[s] == candidates[s - 1])
                continue;

            //Our constraints : We can't go beyond target, we can take more element than available in array
            if (currentSum + candidates[s] <= target) {
                currentSum += candidates[s];
                temp.add(candidates[s]);

                combinationSum2(candidates, s + 1, currentSum, target, response, temp);

                //backtrack
                temp.remove(temp.size() - 1);
                currentSum -= candidates[s];
            }
        }

    }

}
