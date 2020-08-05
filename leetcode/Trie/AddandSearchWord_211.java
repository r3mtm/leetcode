/*

TAGS={Trie, Backtracking, Design}

211. Add and Search Word - Data structure design


Design a data structure that supports the following two operations:


void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true


Note:
You may assume that all words are consist of lowercase letters a-z.

*/

class Trie {
    boolean isEnd;
    Trie map[];
    public Trie() {
        map = new Trie[26];
    }
        
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); ++i) {
            if (node.map[word.charAt(i) - 'a'] == null) {
                Trie newNode = new Trie();
                node.map[word.charAt(i) - 'a'] = newNode;
                node = newNode;
            } else {
                node = node.map[word.charAt(i) - 'a'];
            }
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == '.') {
                return dfs(word, node, i);
            }
            node = node.map[word.charAt(i) - 'a'];
            if (node == null) return false;
        }
        if (node.isEnd) return true;
        
        return false;
    }

    private boolean dfs(String word, Trie node, int index) {
        if (index >= word.length()) {
            return node.isEnd;
        }

        if (word.charAt(index) == '.') {
            for (int j = 0; j < 26; ++j) {
                if (node.map[j] != null) {
                    if (dfs(word, node.map[j], index + 1)) return true;
                }
            }
            return false;
        }

        if (node.map[word.charAt(index) - 'a'] == null) return false;

        if (dfs(word, node.map[word.charAt(index) - 'a'], index + 1)) return true;

        return false;
    }
}

class WordDictionary {

    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}

class AddandSearchWord_211 {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("aaaaaaaaaaaaaa");
        dict.addWord("aa");
        System.out.println(dict.search("a."));
    }
}
