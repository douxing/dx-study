package leetcode;

import java.util.LinkedList;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    List<Integer> l;
    int index;

    void fill(NestedInteger ni) {
	if (ni.isInteger()) {
	    l.add(ni.getInteger());
	} else {
	    for (NestedInteger ni1 : ni.getList()) {
		fill(ni1);
	    }
	}
    }

    public NestedIterator(List<NestedInteger> nestedList) {
	this.l = new LinkedList();
	for (NestedInteger ni : nestedList) {
	    fill(ni);
	}
	this.index = 0;
    }

    @Override
    public Integer next() {
	if (this.hasNext()) {
	    return this.l.get(this.index++);
	}
	return null;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.l.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
