package lc;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        java.util.Hashtable<Integer, Integer> s = new java.util.Hashtable();
	for (int i = 0; i < answers.length; i += 1) {
	    int k = answers[i];
	    Integer v = s.get(k);
	    if (v == null) {
		s.put(k, 1);
	    } else {
		s.put(k, v + 1);
	    }
	}

	int total = 0;
	for (Integer k : s.keySet()) {
	    int v = s.get(k); // v is count of key
	    if (k == 0) {
		total += v;
	    } else {
		int count = v / (k + 1);
		if (v % (k + 1) > 0) {
		    count += 1;
		}
		total += count * (k + 1);
	    }
	} 

	return total;
    }
}
