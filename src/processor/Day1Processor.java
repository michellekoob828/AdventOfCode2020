package src.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1Processor {

	public static final String FILE_NAME = "src/resources/InputDay1";

	public void process() throws FileNotFoundException {
		System.out.println("Part 1 Started");
		List<Integer> expenseReportEntries = this.mapExpenseReportEntries();
		boolean foundEntries = false;
		
		for(int i = 0; i < expenseReportEntries.size(); i++) {
			Integer int1 = expenseReportEntries.get(i);
			
			for(int j = i+1; j < expenseReportEntries.size(); j++) {
				Integer int2 = expenseReportEntries.get(j);
				if(2020 == int1 + int2) {
					System.out.println("int1 = " + int1);
					System.out.println("int2 = " + int2);
					System.out.println("int1 + int2 = " + (int1 + int2));
					System.out.println("int1 * int2 = " + (int1 * int2));
					foundEntries = true;
					break;
				}
			}
			if(foundEntries) {
				break;
			}
		}
		System.out.println("Part 1 Ended");
	}
	
	public void processPart2() {
		System.out.println("Part 2 Started");
		List<Integer> expenseReportEntries = this.mapExpenseReportEntries();
		boolean foundEntries = false;
		
		for(int i = 0; i < expenseReportEntries.size(); i++) {
			Integer int1 = expenseReportEntries.get(i);
			
			for(int j = i+1; j < expenseReportEntries.size(); j++) {
				Integer int2 = expenseReportEntries.get(j);
				
				for(int k = j+1; k < expenseReportEntries.size(); k++) {
					Integer int3 = expenseReportEntries.get(k);
					if(2020 == int1 + int2 + int3) {
						System.out.println("int1 = " + int1);
						System.out.println("int2 = " + int2);
						System.out.println("int3 = " + int3);
						System.out.println("int1 + int2 + int3 = " + (int1 + int2 + int3));
						System.out.println("int1 * int2 * int3 = " + (int1 * int2 * int3));
						foundEntries = true;
						break;
					}
					if(foundEntries) {
						break;
					}
				}
				if(foundEntries) {
					break;
				}
			}
			if(foundEntries) {
				break;
			}
		}
		System.out.println("Part 2 Ended");
	}
	
	private List<Integer> mapExpenseReportEntries() {
		List<Integer> entries = new ArrayList<>();
				
		try {
			FileReader fr = new FileReader(FILE_NAME); 
			BufferedReader bufr = new BufferedReader(fr);
			
			String line = bufr.readLine();
			
			while(line != null){
				Integer entry = Integer.parseInt(line);
				entries.add(entry);
				line = bufr.readLine(); 
			}
			
			bufr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return entries;
	}
}
