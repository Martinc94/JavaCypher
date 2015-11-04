package gmit;

import java.util.Comparator;

public class KeyComparator implements Comparator<KeyColumn>{
	public int compare(KeyColumn current, KeyColumn next) {
		
		if(current.getKeyCharacter()<next.getKeyCharacter()){
			return -1;
		}//end if
		else if (current.getKeyCharacter()>next.getKeyCharacter()){
			return +1;
		}//end else if
		else
			return 0;
	}//end else
}
