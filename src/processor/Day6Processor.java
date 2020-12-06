package src.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.vo.Constants;

public class Day6Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay6";

	public void processPart1() throws Exception {
		System.out.println("Part 1 Started");
		List<List<char[]>> groups = this.parseInput();
		this.countYesPerGroup(groups);
		System.out.println("Part 1 Ended");
	}
	
	private void countYesPerGroup(List<List<char[]>> groups) {
		int totalSum = 0;
		
		for(List<char[]> g : groups) {
			StringBuilder groupYesAnswers = new StringBuilder();
			for(char[] form : g) {
				for(char yesAnswer : form) {
					if(-1 == groupYesAnswers.toString().indexOf(yesAnswer)) {
						//no one in the group has answered yes to the question yet
						groupYesAnswers.append(yesAnswer);
					}
				} //end for each answer on form
			} //end for each form in group
			System.out.println("Number of yes answers in group: " + groupYesAnswers.length());
			totalSum += groupYesAnswers.length();
		} //end for each group
		
		System.out.println("Total sum: " + totalSum);
	}
	
	private List<List<char[]>> parseInput() throws IOException {
		List<List<char[]>> groups = new ArrayList<>();
		groups.add(new ArrayList<char[]>());
		
		FileReader fr = new FileReader(FILE_NAME); 
		BufferedReader bufr = new BufferedReader(fr);
		String line = bufr.readLine();
		
		while(line != null){
			if(Constants.EMPTY_STRING.equals(line)) {
				groups.add(new ArrayList<char[]>());
			} else {
				char[] yesAnswers = line.toCharArray();
				groups.get(groups.size()-1).add(yesAnswers);
			}
			
			line = bufr.readLine(); 
		}
		
		bufr.close();
		return groups;
	}
	
}
