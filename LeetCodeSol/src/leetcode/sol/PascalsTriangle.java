import java.util.ArrayList;
import java.util.List;

public class P5 {

    public static void main(String[] args) {
        List<List<Integer>> lists = triangle(5);
        System.out.println(lists);
    }
    
    public static List<List<Integer>> triangle(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        if(rowIndex < 0) return lists;
        // add row "0" with one "1"
        List<Integer> one = new ArrayList<>();
        one.add(1);
        lists.add(one);
        for(int i=1;i<=rowIndex;i++){
            List<Integer> list = new ArrayList<>();
            list.add(1); // first index
            for(int j=2;j<i+1;j++){ // start with two
                list.add(lists.get(i-1).get(j-2)+lists.get(i-1).get(j-1));
            }
            list.add(1); // last index
            lists.add(list);
        }
        return lists;
    }

}
