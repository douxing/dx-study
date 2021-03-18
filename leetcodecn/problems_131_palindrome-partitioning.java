class Solution {
    boolean revEqual(String lhs, String rhs) {
	int len = lhs.length();
	if (len != rhs.length()) {
	    return false;
	}

	for (int i = 0; i < len; i += 1) {
	    if (lhs.charAt(i) != rhs.charAt(len - 1 - i)) {
		return false;
	    }
	}

	return true;
    }

    void addUnique(List<List<String>> res, List<String> two) {
	for (List<String> one: res) {
	    if (one.equals(two)) {
		return;
	    }
	}
	res.add(two);
    }

    public List<List<String>> partition(String s) {
	// assert(s.length() >= 1);
	List<List<String>> out = new ArrayList();
	List<String> one = new ArrayList();
	for (char ch : s.toCharArray()) {
	    one.add(s.valueOf(ch));
	}
	out.add(one);
	if (s.length() == 1) {
	    return out;
	}
	
	// assert(s.length() >= 2);
	for (int i = 0; i < out.size(); i += 1) {
	    one = out.get(i);

	    int j = 0;
	    while (j < one.size() - 2) {
		// ..., max j, len-2, len-1, len
		if (revEqual(one.get(j), one.get(j + 1))) {
		    List<String> two = new ArrayList(one.subList(0, j));
		    two.add(one.get(j) + one.get(j + 1));
		    two.addAll(one.subList(j + 2, one.size()));
		    // out.add(two);
		    addUnique(out, two);
		}
		if (revEqual(one.get(j), one.get(j + 2))) {
		    List<String> two = new ArrayList(one.subList(0, j));
		    two.add(one.get(j) + one.get(j + 1) + one.get(j + 2));
		    two.addAll(one.subList(j + 3, one.size()));
		    // out.add(two);
		    addUnique(out, two);
		}
		j += 1;
	    }

	    if (j == one.size() - 2 && revEqual(one.get(j), one.get(j + 1))) {
		// ..., j, len - 1, len
		List<String> two = new ArrayList(one.subList(0, j));
		two.add(one.get(j) + one.get(j + 1));
		// out.add(two);
		addUnique(out, two);
	    }
	}

	return out;
    }
}
