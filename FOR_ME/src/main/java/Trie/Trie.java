package Trie;

public class Trie {
    TriNote root;

    //Contrast an empty trie Object
    public Trie() {
        root = new TriNote();
    }

    //Insert a new word into trie
    public void insert(String givenWords) {
        //from hashmap
        TriNote currentNode = root;
        //from String givenWords
        char[] arrayOfGivenWords = givenWords.toCharArray();
        // we are looping characters from givenWords and if we have created new one if not get that one
        // and say that that words true

        for (char eachCharactersFromGivenWords : arrayOfGivenWords) {
            if (!currentNode.children.containsKey(eachCharactersFromGivenWords)) {
                currentNode.children.put(eachCharactersFromGivenWords, new TriNote());
            }
            currentNode=currentNode.children.get(eachCharactersFromGivenWords);
        }
        currentNode.isWord=true;
    }

    public boolean search(String wordGiven) {
        TriNote currentNode = root;
        char[] charArrayWordGiven = wordGiven.toCharArray();
        for (char charactersCharArrayWordGiven : charArrayWordGiven) {
            if (!currentNode.children.containsKey(charactersCharArrayWordGiven)){
                return false;
            }
            currentNode=currentNode.children.get(charactersCharArrayWordGiven);
        }
        return currentNode.isWord;
    }

    public boolean startsWith(String GivenPrefix) {
        TriNote currentNode = root;
        char[] toCharArrayGivenPrefix = GivenPrefix.toCharArray();
        for (char charactersOfPrefix : toCharArrayGivenPrefix) {
            if (!currentNode.children.containsKey(charactersOfPrefix)){
                return false;
            }
            currentNode.children.get(charactersOfPrefix);// Move to next Node
        }

        return true;
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie);
     * obj.insert(word);
     * boolean param_2 = obj.search (word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
