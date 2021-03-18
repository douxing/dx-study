class Solution {
    public String removeDuplicates(String S) {
	StringBuffer sb = new StringBuffer();
	int index = 0;

	while (index < S.length()) {
	    char ch = S.charAt(index);
	    if (sb.length() == 0 || ch != sb.charAt(sb.length() - 1)) {
		sb.append(ch);
	    } else {
		sb.deleteCharAt(sb.length() - 1);
	    }
	    index += 1;
	}

	return sb.toString();
    }
}
