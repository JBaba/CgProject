import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        List<String> ladder = wordLadder("hit","cog",dict);
        System.out.println(ladder);

    }

    private static List<String> wordLadder(String start, String end, Set<String> dict) {

        List<WordNode> queue = new ArrayList<>();
        queue.add(new WordNode(start,1));
        dict.add(end);
        while (!queue.isEmpty()) {
            WordNode top = queue.remove(0);
            if (top.word.equalsIgnoreCase(end)) {
                System.out.println(top.numSteps);
                return top.ans;
            }
            char[] cary = top.word.toCharArray();
            for (int i = 0; i < top.word.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char temp = cary[i];
                    cary[i] = j;
                    String word = new String(cary);

                    if (dict.contains(word)) {
                        WordNode node = new WordNode(word,top.numSteps+1);
                        node.ans.addAll(top.ans);
                        queue.add(node);
                        dict.remove(word);
                    }
                    cary[i] = temp;
                }
            }
        }

        return new ArrayList<>();
    }

}

class WordNode{
    String word;
    int numSteps;
    List<String> ans = new ArrayList<>();

    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
        ans.add(word);
    }

}
