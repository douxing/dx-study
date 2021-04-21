package lc;

import java.lang.Math;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class MinDist {
    void parse(TreeNode r, List<Integer> l) {
	if (r == null) {
	    return;
	}

	parse(r.left, l);
	l.add(r.val);
	parse(r.right, l);
    }


    public int minDiffInBST(TreeNode root) {
	List<Integer> l = new LinkedList();
	parse(root, l);
	ListIterator<Integer> i = l.listIterator();
	int prev = i.next();
	int next = i.next();
	int min = Math.abs(prev - next);
	while (i.hasNext()) {
	    prev = next;
	    next = i.next();
	    min = Math.min(min, Math.abs(prev - next));
	}
	return min;
    }    
}
