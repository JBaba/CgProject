import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllSubSet {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        allSet(a,0, list, set);
        System.out.println(list);
    }

    private static void allSet(int[] a, int start, List<List<Integer>> list, List<Integer> set) {

        if(set.size()>0){
            list.add(new ArrayList<>(set));
        }

        for(int i=start;i<a.length;i++){
            set.add(a[i]);
            allSet(a,i+1,list,set);
            set.remove(set.size()-1);
        }

    }


    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null)
            return null;

        Arrays.sort(S);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < S.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            //get sets that are already in result
            for (ArrayList<Integer> a : result) {
                temp.add(new ArrayList<Integer>(a));
            }

            //add S[i] to existing sets
            for (ArrayList<Integer> a : temp) {
                a.add(S[i]);
            }

            //add S[i] only as a set
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(S[i]);
            temp.add(single);

            result.addAll(temp);
        }

        //add empty set
        result.add(new ArrayList<Integer>());

        return result;
    }
    
}
