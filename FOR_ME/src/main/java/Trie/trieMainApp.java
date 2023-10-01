package Trie;

public class trieMainApp {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie);
     * obj.insert(word);
     * boolean param_2 = obj.search (word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {
        Trie myTrie = new Trie();
        myTrie.insert("apple");
        System.out.println(myTrie.search("apple"));
        System.out.println(myTrie.search("app"));
        myTrie.insert("app");
        System.out.println(myTrie.search("app")+" => after insertion");
    }
}
