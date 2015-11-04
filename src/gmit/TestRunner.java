package gmit;

import java.io.IOException;
import java.util.Scanner;

import gmit.*;

public class TestRunner {
	static int choice=0;
	static long startTime,endTime,totalTime;
    static double sec;
	
	public static void main(String[] args) throws IOException {
		InputOutput.showMenu();
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter choice: ");
		choice = scanner.nextInt();
		
		while(choice!=99){
		    switch (choice) {
        
		        case 1:
		            // encrypt a file
		        	//encrypt and decrypt a file
			    	//sets up Encryption Hash map
					Encryption.initEncrypt();
					
					//sets key 
					InputOutput.setKey();
					
					//sets up arrays
					Encryption.buildMatrix(InputOutput.key);
					
					//Start the timer
					startTime = System.nanoTime();
					
					//parse the file, build and populate matrix
					InputOutput.parse(InputOutput.TEXT_FILE);
					
					//output to file
					InputOutput.encyptedOutputToFile();
					
					// End the Timer
			         endTime   = System.nanoTime();
			         totalTime = endTime - startTime;
			        // Print the total Time
			         sec = (double)totalTime / 1000000000.0;
			        System.out.println("Total time is: "+sec); 	
			        System.out.println(); 
		        	
		            break;
		        case 2:
		        	//decrypt a file
		        	
		        	//sets key 
					InputOutput.setKey();
					
					//sets up arrays
					Encryption.buildMatrix(InputOutput.key);
		        	
					//Start the timer
					startTime = System.nanoTime();
					
					//parse the file, build and populate matrix decrypt and output to file
					InputOutput.parseDecrypt(InputOutput.ENC_FILE);
					
					//End the Timer
			        endTime   = System.nanoTime();
			        totalTime = endTime - startTime;
			        //Print the total Time
			        sec = (double)totalTime / 1000000000.0;
			        System.out.println("Total time is: "+sec);	        
		            break;
		        case 99:
		            System.out.println("Goodbye");
		            break;
		        default:
		            System.out.println("Invalid Option");
		    }//switch
			
		    InputOutput.showMenu();
		    System.out.println("Enter choice: ");
			choice = scanner.nextInt();
			
			
		}//while
		scanner.close();
		
	}//end main
	
}//end testRunner
