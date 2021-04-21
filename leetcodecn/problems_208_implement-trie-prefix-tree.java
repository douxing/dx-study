package lc;

public class PrefixTrie {}

class Trie {
    Trie[] ts;
    boolean end;

    /** Initialize your data structure here. */
    public Trie() {
	this.ts = new Trie[26];
	this.end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
	Trie curr = this;
	Trie next = null;
	for (int i = 0; i < word.length(); i += 1) {
	    int idx = word.charAt(i) - 'a';
	    if (curr.ts[idx] == null) {
		curr.ts[idx] = new Trie();
	    }
	    curr = curr.ts[idx];
	}

	curr.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
	Trie curr = this;
	Trie next = null;

	for (int i = 0; i < word.length(); i += 1) {
	    next = curr.ts[word.charAt(i) - 'a'];
	    if (next == null) {
		return false;
	    }
	    curr = next;
	}

	return curr.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
	Trie curr = this;
	Trie next = null;

	for (int i = 0; i < prefix.length(); i += 1) {
	    next = curr.ts[prefix.charAt(i) - 'a'];
	    if (next == null) {
		return false;
	    }
	    curr = next;
	}

	return true;
    }
}
