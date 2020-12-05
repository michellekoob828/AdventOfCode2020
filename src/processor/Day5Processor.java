package src.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay5";
	public static final char LOWER_ROWS = 'F';
	public static final char UPPER_ROWS = 'B';
	public static final char LOWER_COLUMNS = 'L';
	public static final char UPPER_COLUMNS = 'R';

	public void processPart1() throws Exception {
		System.out.println("Part 1 Started");
		List<String> input = this.parseInput();
		int maxSeatId = 0;
		
		for(String inputRow : input) {
			int row = this.determinePosition(inputRow.substring(0, 7), 127);
			int column = this.determinePosition(inputRow.substring(7, 10), 7);
			int currentSeatId = (row * 8) + column;
			System.out.print("row " + row);
			System.out.print(", column " + column);
			System.out.println(", seat ID " + currentSeatId);
			if(currentSeatId > maxSeatId) {
				maxSeatId = currentSeatId;
			}
		}
		
		System.out.println("highest seat id: " + maxSeatId);
		System.out.println("Part 1 Ended");
	}
	
	private int determinePosition(String rowInput, int maxValue) throws Exception {
		int minValue = 0;
		int difference;
		
		for(char c : rowInput.toCharArray()) {
			difference = maxValue - minValue + 1;
			if(LOWER_ROWS == c || LOWER_COLUMNS == c) {
				maxValue = maxValue - (difference / 2);
			} else if(UPPER_ROWS == c || UPPER_COLUMNS == c) {
				minValue = minValue + (difference / 2);
			}
		}
		
		if(minValue != maxValue) {
			throw new Exception("minValue does not equal maxValue. minValue: " + minValue + " maxValue: " + maxValue);
		}
		
		return minValue;
	}
	
	private List<String> parseInput() throws IOException {
		List<String> input = new ArrayList<>();
		
		FileReader fr = new FileReader(FILE_NAME); 
		BufferedReader bufr = new BufferedReader(fr);
		String line = bufr.readLine();
		
		while(line != null){
			input.add(line);
			line = bufr.readLine(); 
		}
		
		bufr.close();
		return input;
	}
	
}
