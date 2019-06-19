import java.util.*;

/**
 * onetwothree
 */

public class WordBreakAllTypeProb {

    static int count = 0;

    public static void main(String[] args) {

        Set<String> dict = new HashSet<>();
        dict.add("one");
        dict.add("on");
        dict.add("two");
        dict.add("three");
        dict.add("threei");
        dict.add("thr");
        dict.add("ee");
        dict.add("e");

        String str = "onetwothreeeeeei";
        boolean f = false;
//        sabadTodoAndBadhiPatternChapo("",str,dict);
        int[] ary = new int[str.length() + 1];
        for (int i = 0; i < ary.length; i++)
            ary[i] = -1;
        count = 0;
        f = sabadTodoAndBadhiPatternChapoMemo("", str, dict, ary);
        System.out.println(count);
        System.out.println(f);
        System.out.println("--------------------");
        count = 0;
        f = wordBreakExponantialTime(dict, str);
        System.out.println(count);
        System.out.println(f);
        System.out.println("--------------------");
        TrieNode head = new TrieNode();
        insertTrie(head, dict);
        System.out.println(wordbreak(head, str));
    }

    // Word break with memory saves repeat 
    private static boolean sabadTodoAndBadhiPatternChapoMemo(String pre, String str, Set<String> dict, int[] ary) {
        int n = str.length();

        if (str.length() == 0) {
            System.out.println(pre);
            return true;
        }

        if (ary[n] == -1) {
            ary[n] = 0;
            for (int i = 0; i <= str.length(); i++) {
                count++;
                String _pre = str.substring(0, i);
                System.out.println(_pre+"----"+pre+"----"+str);
                if (dict.contains(_pre)) {
                    boolean f = sabadTodoAndBadhiPatternChapoMemo(pre + _pre + " ", str.substring(i), dict, ary);
                    if (f) {
                        ary[n] = 1;
                        return true;
                    }
                }
            }
        }
        return ary[n] == 1;
    }

    // Function to determine if String can be segmented into a space-
    // separated sequence of one or more dictionary words
    public static boolean wordBreakExponantialTime(Set<String> dict, String str) {
        // return true if we have reached the end of the String,
        if (str.length() == 0) {
            return true;
        }

        for (int i = 1; i <= str.length(); i++) {
            count++;
            // consider all prefixes of current String
            String prefix = str.substring(0, i);
            System.out.println(prefix+"----"+str);
            // return true if prefix is present in the dictionary and
            // remaining string also forms space-separated sequence of
            // one or more dictionary words

            if (dict.contains(prefix) && wordBreakExponantialTime(dict, str.substring(i))) {
                return true;
            }
        }

        // return false if the String can't be segmented
        return false;
    }

    // word break print all posibiliteis
    private static void sabadTodoAndBadhiPatternChapo(String pre, String str, Set<String> dict) {
        if (str.length() == 0) {
            System.out.println(pre);
            return;
        }
        for (int i = 0; i <= str.length(); i++) {
            String _pre = str.substring(0, i);
            if (dict.contains(_pre)) {
                sabadTodoAndBadhiPatternChapo(pre + _pre + " ", str.substring(i), dict);
            }
        }
    }

    // word break with trie data structures
    private static void insertTrie(TrieNode head, Set<String> dict) {
        for (String word : dict) {
            TrieNode node = head;
            for (int i = 0; i < word.length(); i++) {
                if (node.next[word.charAt(i) - 'a'] == null) {
                    node.next[word.charAt(i) - 'a'] = new TrieNode();
                    node.c = word.charAt(i);
                }
                node = node.next[word.charAt(i) - 'a'];
            }
            node.exits = true;
        }
    }

    private static boolean wordbreak(TrieNode head, String word) {
        boolean[] good = new boolean[word.length()+1];
        good[0] = true;
        for(int i=0;i<word.length();i++){
            if(good[i]){
                TrieNode node = head;
                for(int j=i;j<word.length();j++){
                    if(node == null)
                        break;
                    node = node.next[word.charAt(j)-'a'];
                    if(node!= null && node.exits){
                        good[j+1] = true;
                    }
                }
            }
        }
        return good[word.length()];
    }
}

class TrieNode {

    boolean exits;
    TrieNode[] next;
    char c;

    public TrieNode() {
        next = new TrieNode[26];
        exits = false;
    }

}
