package src.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1Processor {

	public static final String FILE_NAME = "src/InputFileDay1.txt";

	public void process() throws FileNotFoundException {
		
		FileReader fr = new FileReader(FILE_NAME); 
		BufferedReader bufr = new BufferedReader(fr);
				
		try {
			String line = bufr.readLine();
			
			while(line != null){
				//do stuff
				line = bufr.readLine(); 
			}
			
			bufr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
