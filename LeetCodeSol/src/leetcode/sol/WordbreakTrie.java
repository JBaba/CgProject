import java.util.*;

/**
 * onetwothree
 */

public class WordbreakTrie {

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
