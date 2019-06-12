import java.util.ArrayList;
import java.util.List;

public class GetXRowPascalsTriangle {

    public static void main(String[] args) {
        List<Integer> list = getRow(5);
        System.out.println(list);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if(rowIndex < 0) return list;
        list.add(1);
        for(int i=1;i<=rowIndex;i++){
            for(int j=list.size()-2;j>=0;j--){
                list.set(j+1,list.get(j)+list.get(j+1));
            }
            list.add(1);
        }
        return list;
    }

}
