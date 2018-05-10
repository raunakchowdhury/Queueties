//Susan Lin 
//APCS2 pd02
//HW#46 -- Arrr, There Be Priorities Here Matey . . .
//R 2018-05-10 

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
	ArrayList<String> q = new ArrayList<String>();
	
	//runtime of O(1)
    public void add (String x) {
		q.add(x); 
	}
	
	//runtime of O(1)
    public boolean isEmpty() {
		return q.size() == 0; 
	}
	
	//runtime of O(n)
    public String peekMin() {
		String min = "Empty Queue";
		if (!q.isEmpty()) {
	    	min = q.get(0);
	    	for (int x = 1; x < q.size(); x++) {
				if (q.get(x).compareTo(min) != 0)
		    		min = q.get(x); 
			}
		}
		return min; 
	}
	
	//runtime of O(n)
    public String removeMin() {
		String min = this.peekMin();
		String retStr = "";
		for (int x = 0; x < q.size(); x++) {
	    	if (q.get(x).equals(min)) {
				retStr = min;
				q.remove(x);
	    	}
		}
		return retStr;
	}
	
    public static void main(String[] args) {
    }
}