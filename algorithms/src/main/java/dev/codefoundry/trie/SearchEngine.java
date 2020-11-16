package dev.codefoundry.trie;

public class SearchEngine {
	class TrieNode {
        private boolean isEnd;
        TrieNode[] children = new TrieNode[26];
        
        private int indexOf(char c) {
            return c - 'a';
        }
        
        public TrieNode getOrCompute(char c) {
            if (this.children[indexOf(c)] == null) {
                this.children[indexOf(c)] = new TrieNode();
            }
            
            return this.children[indexOf(c)];
        }
        
        public TrieNode get(char c) {
            return this.children[indexOf(c)];
        }
        
        @Override
        public String toString() {
        	StringBuilder sb = new StringBuilder();
        	sb.append("[ ");
        	for (int i = 0; i < this.children.length; i++) {
        		sb.append(this.children[i] == null ? " , " : " , " + (char)(i + 'a'));
        	}
        	sb.append(" ]");
        	
        	return sb.toString();
        }
    }
    
    private TrieNode root;
    
    public SearchEngine() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.getOrCompute(word.charAt(i));
        }
        
        current.isEnd = true;
    }

    public boolean exists(String word) {
        if (word.indexOf(".") == -1) {
            return simpleExists(word);
        }
        
        return wildcardExists(this.root, word, 0);
    }
    
    private boolean simpleExists(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.get(word.charAt(i));
            
            if (current == null) return false;
        }
        
        return current != null && current.isEnd;
    }
    
    private boolean wildcardExists(TrieNode current, String word, int index) {
        if (index < word.length()) {
            if (word.charAt(index) == '.') {
                for (TrieNode node : current.children) {
                    if (node == null) continue;
                    
                    if (wildcardExists(node, word, index + 1)) {
                        return true;
                    }
                }
            } else {
                if (current.get(word.charAt(index)) == null) {
                    return false;
                } else {
                    return wildcardExists(current.get(word.charAt(index)), word, index + 1);
                }
            }
        }
        
        return current != null && current.isEnd && index == word.length();
    }
    
    public static void main(String[] args) {
		SearchEngine se = new SearchEngine();
		se.add("dog");
		se.add("document");
		System.out.println("exists(\"dog\"): " + se.exists("dog"));
		System.out.println("exists(\"docu\"): " + se.exists("docu"));
		System.out.println("exists(\"....\"): " + se.exists("...."));
		System.out.println("exists(\".......\"): " + se.exists("......."));
		System.out.println("exists(\"..g\"): " + se.exists("..g"));
		
	}
}
