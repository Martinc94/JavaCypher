package gmit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyColumn{
	private char keyCharacter;
	private int index = 0;
	private int size=0;
	private List<Character> chars = new ArrayList<Character>();
	//private static List<Character> chars = new ArrayList<Character>();
	
	public KeyColumn(int index,char key){
		this.keyCharacter=key;
		this.index=index;
	}//keyColumn
	
	public void addTo(int index,char c){
		chars.add(index,c);		
	}//end add
	
	public void addToEnd(char c){
		chars.add(c);		
	}//end add
	
	public char getChar(int index){
		return	chars.get(index);	
	}//end get
	
	public int getIndex(){
		return this.index;	
	}//end getIndex
	
	public char getKeyCharacter(){
		return this.keyCharacter;
	}//end getKeyCharacter
	
	public int getCharSize(){
		
		return this.chars.size();
	}//end getIndex
	
public void outputToArray(){
	//outputList
	Iterator<Character> itr = chars.iterator();
    while(itr.hasNext()) {
       Object element = itr.next();
       InputOutput.outputList.add((Character) element);   
    }//while
	
	}//end outputToArray

public void setLoopSize(int loops) {
	this.size=loops;	
}//setLoopSize

public int getLoopSize() {
	return size;
}//setLoopSize
	
}//end keyColumn


