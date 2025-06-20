class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        boolean isword = false;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();

    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];

        }
        node.isword = true;

    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index]; // move next
        }
        return node.isword;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index]; // move next

        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//

// TrieNode class definition
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

// Trie class definition
class Trie {
    TrieNode root; // This is the Trie's main entrance node

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
}

// Main Solution class
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        // Using a clearer variable name 'rootWord' for the String from the dictionary
        for (String rootWord : dictionary) {
            trie.insert(rootWord);
        }

        StringBuilder resultSentence = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            // Here, we pass 'trie.root' which is the TrieNode, NOT the String
            resultSentence.append(findShortestRoot(currentWord, trie.root));

            if (i < words.length - 1) {
                resultSentence.append(" ");
            }
        }

        return resultSentence.toString();
    }

    private String findShortestRoot(String word, TrieNode root) {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];
            prefix.append(ch);

            if (current.isEndOfWord) {
                return prefix.toString();
            }
        }

        return word;
    }
}

//
// Trie Node class
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // 26 letters in English alphabet
        isEndOfWord = false;
    }
}

// Trie class
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEndOfWord = true;
    }
}