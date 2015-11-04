package gmit;

import java.util.Comparator;

public class IndexComparitor implements Comparator<KeyColumn>{

	public int compare(KeyColumn current, KeyColumn next) {
		if(current.getIndex()<next.getIndex()){
			return -1;
		}
		else if (current.getIndex()>next.getIndex()){
			return +1;
		}
		else{
			return 0;
		}//end else
	}//end compare

}//end indexComparitor
