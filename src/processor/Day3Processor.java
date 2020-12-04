package src.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.vo.Directions;

public class Day3Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay3";
	public static final String FILE_NAME_DIRECTIONS = "src/resources/DirectionsDay3";
	public static final char POUND = '#';

	public void process() throws IOException {
		System.out.println("Part 1 Started");
		BufferedReader bufr = this.initializeBufferedReader(FILE_NAME);
		
		//Start on second line
		String line = bufr.readLine();
		line = bufr.readLine();
		
		int horizontalPosition = 0;
		int treeCount = 0;
		
		while(line != null){
			horizontalPosition = this.findNextHorizontalPosition(horizontalPosition, line.length(), 3);
			if(this.isTree(horizontalPosition, line)) {
				treeCount++;
			}
			
			line = bufr.readLine(); 
		}
		
		bufr.close();
		System.out.println("Final tree count: " + treeCount);
		System.out.println("Part 1 Ended");
	}
	
	public void processPart2() throws IOException {
		System.out.println("Part 2 Started");
		List<String> input = this.mapInput();
		List<Directions> directions = this.mapDirections();
		long multipliedTreeCount = 1;
		for(Directions d : directions) {
			int horizontalPosition = 0;
			int treeCount = 0;
			System.out.println("Right " + d.getRight() + ", down " + d.getDown());
			
			for(int i=d.getDown(); i<input.size(); i=i+d.getDown()) {
				horizontalPosition = this.findNextHorizontalPosition(horizontalPosition, input.get(i).length(), d.getRight());
				if(this.isTree(horizontalPosition, input.get(i))) {
					treeCount++;
				}
			}
			multipliedTreeCount = multipliedTreeCount * treeCount;
			System.out.println("Tree count for given direction: " + treeCount);
		}
		
		System.out.println("Final answer: " + multipliedTreeCount);
		System.out.println("Part 2 Ended");
	}
	
	private List<String> mapInput() throws IOException {
		List<String> input = new ArrayList<>();
		BufferedReader bufr = this.initializeBufferedReader(FILE_NAME);
		String line = bufr.readLine();
		while(line != null){
			input.add(line);
			
			line = bufr.readLine(); 
		}
		
		bufr.close();
		
		return input;
	}
	
	private List<Directions> mapDirections() throws IOException {
		List<Directions> directions = new ArrayList<>();
		BufferedReader bufr2 = this.initializeBufferedReader(FILE_NAME_DIRECTIONS);
		String line = bufr2.readLine();
		while(line != null){
			String[] splitDirections = line.split(",");
			Directions d = new Directions(Integer.parseInt(splitDirections[0]), Integer.parseInt(splitDirections[1]));
			directions.add(d);
			line = bufr2.readLine(); 
		}
		
		bufr2.close();
		
		return directions;
	}
	
	private int findNextHorizontalPosition(int currentPosition, int stringLength, int rightAmount) {
		int nextPosition = currentPosition + rightAmount;
		if(nextPosition >= stringLength) {
			nextPosition = nextPosition - stringLength;
		}
		return nextPosition;
	}
	
	private boolean isTree(int horizontalPosition, String line) {
		return (POUND == line.charAt(horizontalPosition));
	}
	
	private BufferedReader initializeBufferedReader(String fileName) throws FileNotFoundException {
		FileReader fr = new FileReader(fileName); 
		return new BufferedReader(fr);
	}
	
}
