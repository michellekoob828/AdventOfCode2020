package src.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.vo.Constants;

public class Day6Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay6";
	
	public void process() throws Exception {
		List<List<char[]>> groups = this.parseInput();
		this.processPart1(groups);
		this.processPart2(groups);
	}

	private void processPart1(List<List<char[]>> groups) throws Exception {
		System.out.println("Part 1 Started");
		this.countYesPerGroupPart1(groups);
		System.out.println("Part 1 Ended");
	}
	
	private void processPart2(List<List<char[]>> groups) throws Exception {
		System.out.println("Part 2 Started");
		this.countYesPerGroupPart2(groups);
		System.out.println("Part 2 Ended");
	}
	
	private void countYesPerGroupPart2(List<List<char[]>> groups) {
		int totalSum = 0;
		
		for(List<char[]> g : groups) {
			//get first form, add everything, remove from there as needed
			StringBuilder groupYesAnswers = this.parseFirstForm(g.get(0));
			
			for(char[] form : g) {
				StringBuilder answersToRemove = new StringBuilder();
				for(int i = 0; i<groupYesAnswers.length(); i++) {
					if(!this.doesFormContainYesAnswer(form, groupYesAnswers.charAt(i))) {
						answersToRemove.append(groupYesAnswers.charAt(i));
					}
				} //end for each yes answer in group
				for(char c : answersToRemove.toString().toCharArray()) {
					groupYesAnswers.deleteCharAt(groupYesAnswers.toString().indexOf(c));
				}
			} //end for each form in group
			System.out.println(groupYesAnswers);
			System.out.println("Number of yes answers in group: " + groupYesAnswers.length());
			totalSum += groupYesAnswers.length();
		} //end for each group
		
		System.out.println("Total sum: " + totalSum);
	}
	
	private boolean doesFormContainYesAnswer(char[] form, char yesAnswer) {
		for(char a : form) {
			if(yesAnswer == a) {
				return true;
			}
		}
		
		return false;
	}
	
	private StringBuilder parseFirstForm(char[] firstForm) {
		StringBuilder sb = new StringBuilder();
		for(char yesAnswer : firstForm) {
			sb.append(yesAnswer);
		}
		
		return sb;
	}
	
	private void countYesPerGroupPart1(List<List<char[]>> groups) {
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
