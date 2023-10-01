package Trie;

import java.util.HashMap;
import java.util.Map;

public class TriNote {
    public Map<Character, TriNote> children = new HashMap<>();
    public boolean isWord = false;
}
