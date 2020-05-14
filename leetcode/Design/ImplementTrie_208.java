/*

TAGS={Design, Trie}

208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/

// 36ms solution
/*
import java.util.HashMap;

class TrieNode {
    boolean isEnd;
    HashMap<Character, TrieNode> map;
    
    public TrieNode () {
        map = new HashMap<>();
        isEnd = false;
    }
}

 class Trie {
    
    TrieNode root;
    
    public Trie() {
        root = null;
    }
    
    public void insert(String word) {
        if (root == null) {
            TrieNode node = new TrieNode();
            TrieNode nextNode = new TrieNode();
            node.map.put(word.charAt(0), nextNode);
            root = node;
            
            TrieNode temp = nextNode;
            
            for (int i = 1; i < word.length(); ++i) {
                TrieNode newNode = new TrieNode();
                temp.map.put(word.charAt(i), newNode);
                temp = newNode;
            }
            temp.isEnd = true;
        } 
        else {
            TrieNode temp = root;
            TrieNode curTemp;
            for (int i = 0; i < word.length(); ++i) {
                curTemp = temp.map.getOrDefault(word.charAt(i), null);
                if (curTemp != null) {
                    temp = curTemp;
                } else {
                    while (i < word.length()) {
                        TrieNode node = new TrieNode();
                        temp.map.put(word.charAt(i), node);
                        temp = node;
                        ++i;
                    }
                }
            }
            temp.isEnd = true;
        }
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            node = node.map.getOrDefault(word.charAt(i), null);
            if (node == null) return false;
        }
        return node.isEnd == true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            node = node.map.getOrDefault(prefix.charAt(i), null);
            if (node == null) return false;
        }
        return true;
    }
}
 */


// 30ms solution
class TrieNode {
    boolean isEnd;
    TrieNode[] map;
    
    public TrieNode () {
        map = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    
    TrieNode root;
    
    public Trie() {
        root = null;
    }
    
    public void insert(String word) {
        if (root == null) {
            TrieNode node = new TrieNode();
            TrieNode nextNode = new TrieNode();
            node.map[word.charAt(0) - 'a'] = nextNode;
            root = node;
            
            TrieNode temp = nextNode;
            
            for (int i = 1; i < word.length(); ++i) {
                TrieNode newNode = new TrieNode();
                temp.map[word.charAt(i) - 'a'] = newNode;
                temp = newNode;
            }
            temp.isEnd = true;
        } 
        else {
            TrieNode temp = root;
            TrieNode curTemp;
            for (int i = 0; i < word.length(); ++i) {
                curTemp = temp.map[word.charAt(i) - 'a'];
                if (curTemp != null) {
                    temp = curTemp;
                } else {
                    while (i < word.length()) {
                        TrieNode node = new TrieNode();
                        temp.map[word.charAt(i) - 'a'] = node;
                        temp = node;
                        ++i;
                    }
                }
            }
            temp.isEnd = true;
        }
    }
    
    public boolean search(String word) {
        if (root == null) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            node = node.map[word.charAt(i) - 'a'];
            if (node == null) return false;
        }
        return node.isEnd == true;
    }
    
    public boolean startsWith(String prefix) {
        if (root == null) return false;
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            node = node.map[prefix.charAt(i) - 'a'];
            if (node == null) return false;
        }
        return true;
    }
}

public class ImplementTrie_208 {
    public static void main (String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}