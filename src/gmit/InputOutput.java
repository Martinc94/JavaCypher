package gmit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//import java.util.Comparator;
//import java.util.List;
import java.util.Scanner;

public class InputOutput {
//Declare Variables/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static String key;
	static Character letter;
	static int count=0,index=0,charIndex=0,counter=0,totalCharCount=0,colCharCount=0;
	static List<Character>outputList = new ArrayList<Character>();
	static List<Character>decryptList = new ArrayList<Character>();
	static List<Character>decList = new ArrayList<Character>();
   // static char decChar1,decChar2;//char or character
	
	//Change to different texts
	//static final String TEXT_FILE = "PoblachtNaHEireann.txt";
	static final String TEXT_FILE = "WarAndPeace-LeoTolstoy.txt";
	
	static final String ENC_FILE = "encrypted.txt";
	
//METHODS/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void setKey (){
		@SuppressWarnings("resource")
		Scanner console=new Scanner(System.in);
		do{
		System.out.print("Enter Keyword: ");
		key =console.next();
		}while(key.length()<2);
		
	}//setKey
	
	public static String getKey (){
		return key;

	}//getKey
	
	public static void parse (String FileName) throws IOException{
		// Input file
		File f = new File(TEXT_FILE);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		letter=null;
	
		while ((letter =(char)br.read())!=65535){//Character class can't hold -1 so uses maxNumber(65535) when input 
			letter=Character.toUpperCase(letter);//changes to letter to upper case
			Encryption.encrypt(letter);//adds letter to matrix
		}//end while
		
		br.close();
		Collections.sort(Encryption.matrix,new KeyComparator());//sorts the matrix by index
		System.out.println("Matrix Populated and Columnar transposition completed.");
	}//end parse
	
	public static void encyptedOutputToFile() throws IOException{
		FileWriter fw = new FileWriter("encrypted.txt");
		int i=0;
		
		count=0;
		index=0;
		counter=0;
		
		//set count of all chars in array
		setCharCount();
		
		//add to output array
		index=0;
		for(i=0;i<key.length();i++){
			
			Encryption.matrix.get(index).outputToArray();//adds from chars array to output array for each index
			
			counter++;						
			index++;//changes column
			
			if (counter==InputOutput.key.length()){
				count++;
				index=0;
				counter=0;				
			}//if
		}//for
		
		Iterator<Character> itr = outputList.iterator();
	    while(itr.hasNext()) {
	       Object element = itr.next();
	      
	       try {
				fw.flush();
				fw.append((Character) element);
			} catch (Exception e) {
		}//Try Catch
	    }//while
		
		fw.close();//closes file writer
	
	}//end outputToFile

	public static void setCharCount() {
		int i=0;
		//get count of all chars in array for each column and add to total
		for (i = 0;i<key.length();i++){
			totalCharCount+=Encryption.matrix.get(InputOutput.index).getCharSize();
		}//end of for
}
	
	public static void setCharCountDec() {
		int i=0;
		//get count of all chars in array for each column and add to total
		index=0;
		totalCharCount=0;
		for (i = 0;i<key.length();i++){
			totalCharCount+=Encryption.matrix.get(InputOutput.index).getCharSize();
			index++;	
		}//end of for
}

	public static void showMenu(){
		System.out.println("ADFGVXYZ Cipher by Martin Coleman");
		System.out.println("====================================================================");
		System.out.println("Enter 1 to Encrypt a text file and output to encrypted.txt");
		System.out.println("Enter 2 to Decrypt a text file and output to decrypted.txt");
		System.out.println("Enter 99 to Quit");
		System.out.println("====================================================================");
		System.out.println();
		
		
	}

	public static void parseDecrypt (String FileName) throws IOException{
		// Input file
		File f = new File(ENC_FILE);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		Character encLtr;
		int charCount=0,mod=0,remainder=0,loops=0,loopCounter=0,i=0,j=0;
		
		//read file into array	
		while ((encLtr =(char)br.read())!=65535){
			decryptList.add(encLtr);//adds to list from file
		}											
		charCount=decryptList.size();
		
		//get modulus
		mod = (charCount%getKey().length());
	
		//lenght of key -modulus
		remainder =(InputOutput.getKey().length()-mod);	
		
		//how many chars each column holds
		loops = (charCount+remainder)/getKey().length();
		
		index=0;
		loopCounter=0;
		for(i=0;i<key.length();i++){	
			Encryption.matrix.get(index).setLoopSize(loops);
			loopCounter++;			
			if (loopCounter==mod){
				loops-=1;
			}//if
		
			counter++;						
			index++;//changes column
			
			if (counter==InputOutput.key.length()){
				index=0;
				counter=0;	
			}//if
			
		}//for
				
		//sort the array by key
		Collections.sort(Encryption.matrix,new KeyComparator());//sorts the matrix by key       
		
		
		//read into each column
		index=0;
		j=0;
		Iterator<Character> dItr = decryptList.iterator();
		for(i=0;i<key.length();i++){	
			colCharCount=Encryption.matrix.get(index).getLoopSize();
	
			
				while(j!=colCharCount-1){
			
					j++;
			    dItr.hasNext();
			    
			    Object element;
				
					element = dItr.next();
					Encryption.matrix.get(index).addToEnd((Character) element);		
			}//for

			j=0;						
			index++;//changes column
		
		}//for		
		
		System.out.println("matrix populated from encrypted file");
		//sort array by index 
		Collections.sort(Encryption.matrix,new IndexComparitor());//sorts the matrix by index   //////////
		
		decryptList.clear();
		
		br.close();//close file		////////////////////////////////////////////////////////////
	
		//method to get total
		setCharCountDec();
		
		index=0;
		count=0;
		counter=0;
		//loop till end of matrix 
		for(i=0;i<totalCharCount-1;i++){
			try {
				//add to array
				decList.add(Encryption.matrix.get(InputOutput.index).getChar(InputOutput.count));
			} catch (Exception e) {
			}//end try catch
			
			InputOutput.counter++;
			InputOutput.index++;//changes column
			
			if (InputOutput.counter==InputOutput.key.length()){
				InputOutput.count++;
				InputOutput.index=0;
				InputOutput.counter=0;
			}//end if

		}//for										
		
		//setup up decrypt hashmap 
		Encryption.initDecrypt();
		
		//iterate and pass to decrypt a string
		Iterator<Character> decItr = decList.iterator();
		j=0;
		Character decChar1,decChar2;
	
		while(j!=((decList.size()/2)+decList.size()%2)){
	       try {
	    	   j++;
		       Object decElement = decItr.next();
		       decChar1 = (Character) decElement;
		       
		       Object decElement2 = decItr.next();
		       decChar2=(Character) decElement2;
	      
	       Encryption.decrypt(decChar1,decChar2);
				
			} catch (Exception e) {
		}//Try Catch
	    }//while
		
	    //output decrypted file
		decryptedOutputToFile();
	    
	}//end parseDecrypt
	
	public static void decryptedOutputToFile() throws IOException {
		//outputs a Decrypted a file 
		FileWriter fw = new FileWriter("decrypted.txt");
		
		System.out.println("Beginning output to decrypted.txt");
		
		Iterator<Character> OutItr = Encryption.decOut.iterator();
	    while(OutItr.hasNext()) {
	       Object element = OutItr.next();
	      
	       try {
				fw.flush();
				fw.append((Character) element);
			} catch (Exception e) {
		}//Try Catch
	    }//while	
	
	    System.out.println("Decrypted file output to decrypted.txt");
		fw.close();
	}//end decryptedOutputToFile
	
}//end inputOutput
