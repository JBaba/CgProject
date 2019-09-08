/**

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 * {@link Java.LeetCode.pair.element.problems.twoSum.TwoSum2Sum}
 * The difference here is we can choose same number multiple time.
 * <p>
 * In order to see does a set of numbers (could be same number or different) can make up the target.
 * we can assume that each number in given list is undirected connected graph, s.t. each node is also connected to
 * itself too.
 * <p>
 * We need to apply dfs, to see does adding this node value can lead to target or not
 * with backtracking
 * <p>
 * Backtracking
 * 1. Our choices: We can choose a number from the list any number of times and all the numbers
 * 2. Our constraints : We can't go beyond target, we can take more element than available in array
 * 3. Our goal: when currentSum = target
 * <p>
 * O(2^n)
 * Runtime: 1 ms, faster than 100% of Java online submissions for Combination Sum.
 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Combination Sum.
 * <p>
 */
class CombinationSumIDFS {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0)
            return Collections.EMPTY_LIST;

        List<List<Integer>> response = new ArrayList<>();

        combinationSum(candidates, 0, 0, target, response, new ArrayList<>());
        return response;
    }

    private void combinationSum(int[] candidates, int i, int currentSum, int target, List<List<Integer>> response, List<Integer> temp) {

        //Our constraints : We can't go beyond target, we can take more element than available in array
        if (i >= candidates.length)
            return;


        //3. Our goal: when currentSum = target
        if (currentSum == target) {
            response.add(new ArrayList<>(temp));
            return;
        }

        //1. Our choices: We can choose a number from the list any number of times and all the numbers
        for (int s = i; s < candidates.length; s++) {

            //Our constraints : We can't go beyond target, we can take more element than available in array
            if (currentSum + candidates[s] <= target) {
                currentSum += candidates[s];
                temp.add(candidates[s]);

                combinationSum(candidates, s, currentSum, target, response, temp);

                //backtrack
                temp.remove(temp.size() - 1);
                currentSum -= candidates[s];
            }
        }

    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0)
            return Collections.EMPTY_LIST;

        List<List<Integer>> response = new ArrayList<>();

        combinationSum(candidates, 0, target, response, new ArrayList<>());
        return response;
    }

    private void combinationSum(int[] candidates, int i, int target, List<List<Integer>> response, List<Integer> temp) {

        //Our constraints : We can't go beyond target, we can take more element than available in array
        if (i >= candidates.length)
            return;


        //3. Our goal: when currentSum = target
        if (0 == target) {
            response.add(new ArrayList<>(temp));
            return;
        }

        //1. Our choices: We can choose a number from the list any number of times and all the numbers
        for (int s = i; s < candidates.length; s++) {

            //Our constraints : We can't go beyond target, we can take more element than available in array
            if (target - candidates[s] >= 0) {

                target -= candidates[s];

                temp.add(candidates[s]);


                combinationSum(candidates, s, target, response, temp);

                //backtrack
                temp.remove(temp.size() - 1);
                target += candidates[s];
            }
        }

    }

}
