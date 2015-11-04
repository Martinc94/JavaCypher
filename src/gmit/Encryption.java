package gmit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Character;

public class Encryption {
//Declare variables/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static Map <Character,String> encryptMap = new HashMap <Character,String>();
	static Map <String,Character> decryptMap = new HashMap <String,Character>();
	static List<KeyColumn>matrix = new ArrayList<KeyColumn>();
	static List<Character> decOut = new ArrayList<Character>();
	
//METHODS/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void initEncrypt (){
//Sets up Encryption Hash map////////////////////////////////////////////////////////////////////////////////////////////////////////////
				encryptMap.put(new Character('P'),"AA");
				encryptMap.put(new Character('H'),"AD");
				encryptMap.put(new Character('0'),"AF");
				encryptMap.put(new Character('Q'),"AG");
				encryptMap.put(new Character('G'),"AV");
				encryptMap.put(new Character('6'),"AX");
				encryptMap.put(new Character(' '),"AY");//ADDED FOR SPACE
				encryptMap.put(new Character('+'),"AZ");
				
				encryptMap.put(new Character('4'),"DA");
				encryptMap.put(new Character('M'),"DD");
				encryptMap.put(new Character('E'),"DF");
				encryptMap.put(new Character('A'),"DG");
				encryptMap.put(new Character('1'),"DV");
				encryptMap.put(new Character('Y'),"DX");
				encryptMap.put(new Character('.'),"DY");//add full stop
				encryptMap.put(new Character('*'),"DZ");
						
				encryptMap.put(new Character('L'),"FA");
				encryptMap.put(new Character('2'),"FD");
				encryptMap.put(new Character('N'),"FF");
				encryptMap.put(new Character('O'),"FG");
				encryptMap.put(new Character('F'),"FV");
				encryptMap.put(new Character('D'),"FX");
				encryptMap.put(new Character('"'),"FY");// ADD "
				encryptMap.put(new Character('£'),"FZ");
				
				encryptMap.put(new Character('X'),"GA");
				encryptMap.put(new Character('K'),"GD");
				encryptMap.put(new Character('R'),"GF");
				encryptMap.put(new Character('3'),"GG");
				encryptMap.put(new Character('C'),"GV");
				encryptMap.put(new Character('V'),"GX");
				encryptMap.put(new Character('!'),"GY");//ADD !
				encryptMap.put(new Character('$'),"GZ");
				
				encryptMap.put(new Character('S'),"VA");
				encryptMap.put(new Character('5'),"VD");
				encryptMap.put(new Character('Z'),"VF");
				encryptMap.put(new Character('W'),"VG");
				encryptMap.put(new Character('7'),"VV");
				encryptMap.put(new Character('B'),"VX");
				encryptMap.put(new Character('?'),"VY");//ADD ?
				encryptMap.put(new Character('%'),"VZ");
				
				encryptMap.put(new Character('J'),"XA");
				encryptMap.put(new Character('9'),"XD");
				encryptMap.put(new Character('U'),"XF");
				encryptMap.put(new Character('T'),"XG");
				encryptMap.put(new Character('I'),"XV");
				encryptMap.put(new Character('8'),"XX");
				encryptMap.put(new Character(','),"XY");
				encryptMap.put(new Character('='),"XZ");
				
				encryptMap.put(new Character('-'),"YA");
				encryptMap.put(new Character('('),"YD");
				encryptMap.put(new Character(')'),"YF");
				encryptMap.put(new Character('&'),"YG");
				encryptMap.put(new Character(':'),"YV");
				encryptMap.put(new Character(';'),"YX");
				encryptMap.put(new Character('/'),"YY");
				encryptMap.put(new Character('@'),"YZ");
				
				encryptMap.put(new Character('\b'),"ZA");
				encryptMap.put(new Character('\r'),"ZD");
				encryptMap.put(new Character('\t'),"ZF");
				encryptMap.put(new Character('\f'),"ZG");
				encryptMap.put(new Character('\n'),"ZV");
				encryptMap.put(new Character('\''),"ZX");
				encryptMap.put(new Character('Ã'),"ZY");
				encryptMap.put(new Character('~'),"ZZ");
				
				//Unrecognized chars will be converted to "_ _" later
				
				//encryptMap.put(new Character(''),"Z");
				

	}//initEncrypt
	
	public static void initDecrypt (){
//sets up decryption Map////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				decryptMap.put("AA",new Character('P'));
				decryptMap.put("AD",new Character('H'));
				decryptMap.put("AF",new Character('0'));
				decryptMap.put("AG",new Character('Q'));
				decryptMap.put("AV",new Character('G'));
				decryptMap.put("AX",new Character('6'));
				decryptMap.put("AY",new Character(' '));//ADDED FOR SPACE
				decryptMap.put("AZ",new Character('+'));//ADDED FOR +
				
				
				decryptMap.put("DA",new Character('4'));
				decryptMap.put("DD",new Character('M'));
				decryptMap.put("DF",new Character('E'));
				decryptMap.put("DG",new Character('A'));
				decryptMap.put("DV",new Character('1'));
				decryptMap.put("DX",new Character('Y'));
				decryptMap.put("DY",new Character('.'));//ADDED FOR .
				decryptMap.put("DZ",new Character('*'));//ADDED FOR *
				
				
				decryptMap.put("FA",new Character('L'));
				decryptMap.put("FD",new Character('2'));
				decryptMap.put("FF",new Character('N'));
				decryptMap.put("FG",new Character('O'));
				decryptMap.put("FV",new Character('F'));
				decryptMap.put("FX",new Character('D'));
				decryptMap.put("FY",new Character('"'));//ADDED FOR "
				decryptMap.put("FZ",new Character('£'));//ADDED FOR £
				
				decryptMap.put("GA",new Character('X'));
				decryptMap.put("GD",new Character('K'));
				decryptMap.put("GF",new Character('R'));
				decryptMap.put("GG",new Character('3'));
				decryptMap.put("GV",new Character('C'));
				decryptMap.put("GX",new Character('V'));
				decryptMap.put("GY",new Character('!'));//ADDED FOR !
				decryptMap.put("GZ",new Character('$'));//ADDED FOR $
				
				decryptMap.put("VA",new Character('S'));
				decryptMap.put("VD",new Character('5'));
				decryptMap.put("VF",new Character('Z'));
				decryptMap.put("VG",new Character('W'));
				decryptMap.put("VV",new Character('7'));
				decryptMap.put("VX",new Character('B'));
				decryptMap.put("VY",new Character('?'));//ADDED FOR ?
				decryptMap.put("VZ",new Character('%'));//ADDED FOR %
				
				decryptMap.put("XA",new Character('J'));
				decryptMap.put("XD",new Character('9'));
				decryptMap.put("XF",new Character('U'));
				decryptMap.put("XG",new Character('T'));
				decryptMap.put("XV",new Character('I'));
				decryptMap.put("XX",new Character('8'));
				decryptMap.put("XY",new Character(','));//ADDED FOR ,
				decryptMap.put("XZ",new Character('='));//ADDED FOR =
				
				decryptMap.put("YA",new Character('-'));//ADDED FOR -
				decryptMap.put("YD",new Character('('));//ADDED FOR (
				decryptMap.put("YF",new Character(')'));//ADDED FOR )
				decryptMap.put("YG",new Character('&'));//ADDED FOR &
				decryptMap.put("YV",new Character(':'));//ADDED FOR :
				decryptMap.put("YX",new Character(';'));//ADDED FOR ;
				decryptMap.put("YY",new Character('/'));//ADDED FOR /
				decryptMap.put("YZ",new Character('@'));//ADDED FOR @
				
				decryptMap.put("ZA",new Character('\b'));//ADDED FOR \b
				decryptMap.put("ZD",new Character('\r'));//ADDED FOR \r
				decryptMap.put("ZF",new Character('\t'));//ADDED FOR \t
				decryptMap.put("ZG",new Character('\f'));//ADDED FOR \f
				decryptMap.put("ZV",new Character('\n'));//ADDED FOR \n
				decryptMap.put("ZX",new Character('\''));//ADDED FOR \
				decryptMap.put("ZY",new Character('Ã'));//ADDED FOR Ã
				decryptMap.put("ZZ",new Character('~'));//ADDED FOR ~
				decryptMap.put("__",new Character('_'));//ADDED FOR Unrecognized characters
		
	}

	public static void buildMatrix (String key){
		int i=0;
		char keyChar=' ';
		
		matrix.clear();//clears the matrix
		
		for (i=0;i<key.length();i++){
			keyChar=key.charAt(i);
			
			KeyColumn k = new KeyColumn(i,keyChar);//creates new keyColumn at given index(i) 
			
			matrix.add(i,k);//adds to matrix arrayList 
		}
		
		System.out.println("Matrix built");
		
	}//end encrypt0
	
	public static void encrypt (Character ltr){
		char char1='#';
		char char2='#';
		String enc= encryptMap.get(ltr);//changes the letter from the file to a string from polybuis
		
		
		//Check if char is recognized by polybius
		if(enc==null){
			//Unrecognized char 
			char1='_';
			char2='_';
		}
		
		else{
			char1=enc.charAt(0);
			char2=enc.charAt(1);
		}
		
		//store in matrix
		if(InputOutput.index<InputOutput.key.length()){
			matrix.get(InputOutput.index).addToEnd(char1);//adds char1 to chars array at given index
			
			InputOutput.counter++;						
			InputOutput.index++;//changes column
			
			if (InputOutput.counter==InputOutput.key.length()){
				InputOutput.count++;
				InputOutput.index=0;
				InputOutput.counter=0;
			}//if
			
			matrix.get(InputOutput.index).addToEnd(char2);//adds char1 to chars array at given index
			
			InputOutput.counter++;
			InputOutput.index++;
						
			if (InputOutput.counter==InputOutput.key.length()){
				InputOutput.count++;
				InputOutput.index=0;
				InputOutput.counter=0;
			}//if			
			
		}//if		

	}//end encrypt

	public static void decrypt(Character encLtr1,Character encLtr2) {
		String decStr;
		String string1 = String.valueOf(encLtr1);
		String string2 = String.valueOf(encLtr2);
		decStr=string1+string2;	
		
		Character dec= decryptMap.get(decStr);//decrypts string into single char
		
		decOut.add(dec);
		
	}//end decrypt
	
}//end Encryption
