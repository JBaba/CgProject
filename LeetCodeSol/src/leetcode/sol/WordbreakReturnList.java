
public class WordbreakReturnList {

    /*
    
    Set<String> dict = new HashSet<>();
        dict.add("one");
        dict.add("on");
        dict.add("two");
        dict.add("three");
        dict.add("threei");
        dict.add("thr");
        dict.add("ee");
        dict.add("e");
        
    str = "onetwothree";
    System.out.println(wordbreakutil(str,dict));
    
    */

    private static List<String> wordbreakutil(String word,Set<String> dict){
        List<String> result = new ArrayList<>();
        ArrayList<String>[] pos = new ArrayList[word.length()+1];
        pos[0] = new ArrayList<>();

        for(int i=0;i<=word.length();i++){
            if(pos[i]!=null){
                for(int j=i+1;j<=word.length();j++){
                    String pre = word.substring(i,j);
                    if(pos[j] == null && dict.contains(pre)){
                        pos[j] =  new ArrayList<>();
                        pos[j].add(pre);
                    }else if(dict.contains(pre)){
                        pos[j].add(pre);
                    }
                }
            }
        }

        if(pos[word.length()]==null){
            return result;
        }else{
            dfs(pos,"",result,word.length());
        }
        return result;
    }

    private static void dfs(ArrayList<String>[] pos, String s, List<String> result, int length) {
        if(length == 0) {
            result.add(s);
            return;
        }

        for(String word:pos[length]){
            String _s = word + " " + s;
            dfs(pos,_s,result,length-word.length());
        }
    }
}
