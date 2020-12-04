package src.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import src.vo.PasswordDetails;

public class Day2Processor {

	public static final String FILE_NAME = "src/resources/InputDay2";

	public void process() throws IOException {
		System.out.println("Part 1 Started");
		BufferedReader bufr = this.initializeBufferedReader();
		int validPasswordCount = 0;
		String line = bufr.readLine();
		
		while(line != null){
			PasswordDetails pwDetails = this.parseInputLine(line);
			if(this.isPasswordValid(pwDetails)) {
				validPasswordCount++;
			}
			line = bufr.readLine(); 
		}
		
		bufr.close();
		System.out.println("Valid password count: " + validPasswordCount);
		System.out.println("Part 1 Ended");
	}
	
	public void processPart2() throws IOException {
		System.out.println("Part 2 Started");
		BufferedReader bufr = this.initializeBufferedReader();
		int validPasswordCount = 0;
		String line = bufr.readLine();
		
		while(line != null){
			PasswordDetails pwDetails = this.parseInputLine(line);
			if(this.isPasswordValidPart2(pwDetails)) {
				validPasswordCount++;
			}
			line = bufr.readLine(); 
		}
		
		bufr.close();
		System.out.println("Valid password count: " + validPasswordCount);
		System.out.println("Part 2 Ended");
	}
	
	private PasswordDetails parseInputLine(String line) {
		PasswordDetails pwDetails = new PasswordDetails();
		String[] splitLine = line.split(" ");
		String[] appearancesRange = splitLine[0].split("-");
		pwDetails.setFirstNumber(Integer.parseInt(appearancesRange[0]));
		pwDetails.setSecondNumber(Integer.parseInt(appearancesRange[1]));
		pwDetails.setLetter(splitLine[1].charAt(0));
		pwDetails.setPassword(splitLine[2]);
		
		return pwDetails;
	}
	
	private boolean isPasswordValid(PasswordDetails pwDetails) {
		int letterOccuranceCount = this.countLetterOccurances(pwDetails.getPassword(), pwDetails.getLetter());
		
		//first number: min appearances
		//second number: max appearances
		return ((letterOccuranceCount >= pwDetails.getFirstNumber()) &&
				(letterOccuranceCount <= pwDetails.getSecondNumber()));
	}
	
	private boolean isPasswordValidPart2(PasswordDetails pwDetails) {
		int matchingCount = 0;
		
		//first number: first position
		if(this.doesLetterMatchPosition(pwDetails.getPassword(), pwDetails.getLetter(), pwDetails.getFirstNumber())) {
			matchingCount++;
		}
		//second numnber: second position
		if(this.doesLetterMatchPosition(pwDetails.getPassword(), pwDetails.getLetter(), pwDetails.getSecondNumber())) {
			matchingCount++;
		}
		
		return (matchingCount == 1);
	}
	
	private boolean doesLetterMatchPosition(String password, char letter, int position) {
		//Position 1 in input file is position 0 in array
		char currentLetter = password.charAt(position - 1);
		
		return(letter == currentLetter);
	}
	
	private int countLetterOccurances(String password, char letter) {
		int letterOccuranceCount = 0;
		
		for(int i=0; i<password.length(); i++) {
			char currentLetter = password.charAt(i);
			
			if(letter == currentLetter) {
				letterOccuranceCount++;
			}
		}
		
		return letterOccuranceCount;
	}
	
	private BufferedReader initializeBufferedReader() throws FileNotFoundException {
		FileReader fr = new FileReader(FILE_NAME); 
		return new BufferedReader(fr);
	}
}
